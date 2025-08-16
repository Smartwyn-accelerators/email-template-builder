package com.fastcode.email.emailbuilder.application.emailvariable;

import java.util.List;

import jakarta.validation.constraints.Positive;

import com.fastcode.email.emailbuilder.application.emailvariable.dto.*;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fastcode.email.commons.search.SearchCriteria;
import com.fastcode.email.emailbuilder.domain.model.EmailMergeFieldEntity;

@Service
public interface IEmailVariableAppService {

	CreateEmailVariableOutput create(CreateEmailVariableInput email);

    void delete(@Positive(message ="EmailId should be a positive value")Long eid);

    UpdateEmailVariableOutput update(@Positive(message ="EmailId should be a positive value") Long eid, UpdateEmailVariableInput email);

    FindEmailVariableByIdOutput findById(@Positive(message ="EmailId should be a positive value")Long eid);

    FindEmailVariableByNameOutput findByName(String name);
    
    List<FindEmailVariableByIdOutput> find(SearchCriteria search,Pageable pageable) throws Exception;
    
	List<EmailMergeFieldEntity> getMergeFieldsMapping(Long id);
}

