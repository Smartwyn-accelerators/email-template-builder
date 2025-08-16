package com.fastcode.email.emailbuilder.application.emailtemplate.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import com.fastcode.docmgmt.domain.model.File;

@Getter @Setter
public class CreateEmailTemplateOutput {

	private Long id;
	private String templateName;
	private String category;
	private String contentHtml;
	private String contentJson;
	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private Boolean active;
	private String attachmentpath;
	private String description;
	List<File> inlineImages;
	List<File> attachments;

}


