package com.fastcode.email.emailapi.application.mail;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import com.fastcode.email.EmailPropertiesConfiguration;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fastcode.docmgmt.domain.file.IFileContentStore;
import com.fastcode.docmgmt.domain.irepository.IFileRepository;
import com.fastcode.email.emailapi.domain.model.EmailHistory;
import com.fastcode.docmgmt.domain.model.File;
import com.fastcode.email.emailapi.domain.irepository.EmailHistoryRepository;


@Service("emailApiService")
public class EmailService implements IEmailService {

	@Autowired
	public JavaMailSender emailSender;

	@Autowired
	private EmailPropertiesConfiguration env;

	@Autowired
	private RestTemplateBuilder restTemplate;

	@Autowired
	private IFileContentStore contentStore;

	@Autowired
	private IFileRepository filesRepo;

	@Autowired
	EmailHistoryRepository emailHistoryRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public void sendMessage(String to, String cc, String bcc, String subject, String htmlContent,
			List<File> inlineImages, List<File> attachments,Map<Long,byte[]> imageDataSourceMap) {

		MimeMessage message = emailSender.createMimeMessage();

		try {

			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			String[] toArray = to.split(",", -1);
			String[] ccArray = (cc != null && !cc.isEmpty()) ? cc.split(",", -1) : new String[0];
			String[] bccArray = (bcc != null && !bcc.isEmpty()) ? bcc.split(",", -1) : new String[0];			helper.setTo(toArray);
			if(!ccArray[0].isEmpty()) {
				helper.setCc(ccArray);
			}
			if(!bccArray[0].isEmpty()) {
				helper.setBcc(bccArray);
			}
			helper.setSubject(subject);
			helper.setText(htmlContent, true);

			// Use the true flag to indicate the text included is HTML

			for (File file : inlineImages) {
				try {

					ByteArrayResource fileStreamResource = getFileStreamResource(Long.valueOf(file.getName()),imageDataSourceMap);
					if (fileStreamResource != null)
						helper.addInline(file.getSummary(), fileStreamResource, "image/jpeg");
				} catch (Exception e) {
					// ignore
					//e.printStackTrace();
				}
			}

			// Now add the real attachments
			for (File file : attachments) {
				ByteArrayResource fileStreamResource = getFileStreamResource(file.getId(),imageDataSourceMap);
				if (fileStreamResource != null)
					helper.addAttachment(file.getName(), fileStreamResource);
			}

		} catch (MessagingException ex) {
			//ex.printStackTrace();
		}

		emailSender.send(message);
		saveHistory(to, cc, bcc, subject, htmlContent);


	}

	private void saveHistory(String to, String cc, String bcc, String subject, String htmlContent) {
		EmailHistory emailHistory = new EmailHistory();
		emailHistory.setTo(to);
		emailHistory.setCc(cc);
		emailHistory.setBcc(bcc);
		emailHistory.setSubject(subject);
		emailHistory.setBody(htmlContent);
		emailHistoryRepository.save(emailHistory);
	}

	public ByteArrayResource getFileStreamResource(Long fileId, Map<Long, byte[]> imageDataSourceMap) { // This method will download file using RestTemplate
		try {
			if(imageDataSourceMap.get(fileId)!=null)
			{
				return  new ByteArrayResource(imageDataSourceMap.get(fileId)) ;
			}
			Optional<File> f = filesRepo.findById(fileId);
			// InputStreamResource inputStreamResource = new
			// InputStreamResource(contentStore.getContent(f.get()));

			InputStream content = contentStore.getContent(f.get());
			return content != null ? new ByteArrayResource(IOUtils.toByteArray(content)) : null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String appendInlineImagePrifix(String name) {
		if (name.startsWith("cid:")) {
			return name;
		} else {
			return "cid:" + name;
		}
	}

}

