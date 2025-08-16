package com.fastcode.email.emailbuilder.emailconverter.service;

import static com.fastcode.email.emailbuilder.emailconverter.utils.CommonUtil.writeFile;
import static com.fastcode.email.emailbuilder.emailconverter.utils.CommonUtil.deleteFile;

import java.io.IOException;
import java.util.Date;

import com.fastcode.email.EmailPropertiesConfiguration;
import com.fastcode.email.emailbuilder.emailconverter.utils.MjmlCommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcode.email.emailbuilder.emailconverter.dto.request.Request;
import com.fastcode.email.emailbuilder.emailconverter.dto.response.Response;
import com.fastcode.email.emailbuilder.emailconverter.utils.EmailMjmlTemplateGenrator;

@Service
public class MjmlOwnService {

	@Autowired
  private EmailMjmlTemplateGenrator mjmlTemplateGenrator;
  //
  // private static final String DUMMY_TEMPLATE =
  // "<mjml><mj-body><mj-container><mj-section><mj-column><mj-text
  // \"message\"></mj-text></mj-column></mj-section></mj-container></mj-body></mjml>";

  @Autowired
  EmailPropertiesConfiguration env;

  public Response genrateHtml(Request request) throws IOException {
    String mjmlTemplate = mjmlTemplateGenrator.genrateTemplate(request);
    String file = String.format(env.getMjmlFilePath(), new Date().getTime());
    writeFile.accept(mjmlTemplate, file);
    String resultHtmlMail = MjmlCommandLine.executeCommand(file);
    deleteFile(file);
    return new Response(resultHtmlMail);
  }

  public Response genrateMjml(Request request) throws IOException {
    String mjmlTemplate = mjmlTemplateGenrator.genrateTemplate(request);
    return new Response("", mjmlTemplate);
  }
}

