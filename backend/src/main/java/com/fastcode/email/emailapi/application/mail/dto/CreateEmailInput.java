package com.fastcode.email.emailapi.application.mail.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import com.fastcode.docmgmt.domain.model.File;

@Getter @Setter
public class CreateEmailInput{

   private static final long serialVersionUID = 1L;
	// Not a good idea to validate email addresses because there are too many
	// variations for an email address
	@NotNull(message = "Id: should not be null")
	private Long id;
	@NotNull(message = "To: should not be null")
	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String emailBody;
	private String contentJson;
	private Set<File> inlineImages = new HashSet<File>();
	private Set<File> attachments = new HashSet<File>();

}

