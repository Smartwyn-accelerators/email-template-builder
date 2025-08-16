package com.fastcode.email.emailbuilder.application.emailtemplate.dto;

import java.util.List;

import com.fastcode.email.emailbuilder.application.datasource.dto.FindDataSourceMetaOutputForMapping;
import com.fastcode.email.emailbuilder.application.emailvariable.dto.FindEmailVariableByIdOutput;

public class FindEmailTemplateMappingDTO {

	private FindEmailVariableByIdOutput mergeField;

	private List<FindDataSourceMetaOutputForMapping> dataSourceMetaList;
	
}
