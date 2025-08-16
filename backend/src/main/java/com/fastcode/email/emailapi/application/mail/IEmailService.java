package com.fastcode.email.emailapi.application.mail;

import java.util.List;
import java.util.Map;

import com.fastcode.docmgmt.domain.model.File;

public interface IEmailService {

	void sendMessage(String to, String cc, String bcc, String subject, String htmlContent, List<File> inlineImages, List<File> attachments,Map<Long,byte[]> imageDataSourceMap);

}

