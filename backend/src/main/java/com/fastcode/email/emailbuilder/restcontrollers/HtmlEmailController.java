package com.fastcode.email.emailbuilder.restcontrollers;

import java.io.IOException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fastcode.email.emailbuilder.application.emailtemplate.EmailTemplateAppService;
import com.fastcode.email.commons.domain.EmptyJsonResponse;


@RestController
@RequestMapping("/emailbuilder/htmlEmail")
public class HtmlEmailController {

	 @Autowired
	 private EmailTemplateAppService emailTemplateAppService;

	 @RequestMapping(method = RequestMethod.POST)
	 public ResponseEntity<String> jsonToHtml(@RequestBody @Valid String json) throws IOException
	 {
		 if(json != null)
			 return new ResponseEntity(emailTemplateAppService.convertJsonToHtml(json), HttpStatus.OK);
		 else
			 return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.NOT_FOUND);
			 
	 }
}

