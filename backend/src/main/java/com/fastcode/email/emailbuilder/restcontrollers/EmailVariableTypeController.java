package com.fastcode.email.emailbuilder.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastcode.email.emailbuilder.application.emailvariable.IEmailVariableTypeAppService;
import com.fastcode.email.emailbuilder.domain.model.EmailVariableTypeEntity;

@RestController
@RequestMapping("/emailbuilder/emailvariabletypes")
public class EmailVariableTypeController {

	@Autowired
	IEmailVariableTypeAppService emailVariableTypeAppService;
	
	@GetMapping("/variable-types")
	ResponseEntity<EmailVariableTypeEntity> getAll() throws Exception{
		return new ResponseEntity(emailVariableTypeAppService.getAllTypes(), HttpStatus.OK);
	}

}
