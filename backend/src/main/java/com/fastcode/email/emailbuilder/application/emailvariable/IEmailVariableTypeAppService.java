package com.fastcode.email.emailbuilder.application.emailvariable;

import java.util.List;


import org.springframework.stereotype.Service;

import com.fastcode.email.emailbuilder.domain.model.EmailVariableTypeEntity;

@Service
public interface IEmailVariableTypeAppService {



	List<EmailVariableTypeEntity> getAllTypes() throws Exception;

}
