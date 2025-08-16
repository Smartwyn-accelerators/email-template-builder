package com.fastcode.email.emailbuilder.application.emailvariable.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FindEmailVariableByIdOutput {

	private Long id;
	private String propertyName;
	private String propertyType;
    private String defaultValue;
  //  private Long versiono;
    private String mergeType;
}
	


