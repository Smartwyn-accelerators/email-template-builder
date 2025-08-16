package com.fastcode.email.emailbuilder.application.emailvariable;

import java.util.List;


import org.springframework.stereotype.Service;

@Service
public interface IEmailCategoryService {

	List<String> getAllCategories() throws Exception;

}
