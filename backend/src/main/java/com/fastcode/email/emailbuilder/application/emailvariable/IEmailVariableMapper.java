package com.fastcode.email.emailbuilder.application.emailvariable;

import com.fastcode.email.emailbuilder.application.emailvariable.dto.*;
import org.mapstruct.Mapper;
import java.util.List;

import com.fastcode.email.emailbuilder.application.datasource.dto.DataSourceMetaOutput;
import com.fastcode.email.emailbuilder.domain.model.DataSourceMetaEntity;
import com.fastcode.email.emailbuilder.domain.model.EmailVariableEntity;

@Mapper(componentModel = "spring")
public interface IEmailVariableMapper {

    EmailVariableEntity createEmailVariableInputToEmailVariableEntity(CreateEmailVariableInput emailDto);

    CreateEmailVariableOutput emailVariableEntityToCreateEmailVariableOutput(EmailVariableEntity entity);

    EmailVariableEntity updateEmailVariableInputToEmailVariableEntity(UpdateEmailVariableInput emailDto);

    UpdateEmailVariableOutput emailVariableEntityToUpdateEmailVariableOutput(EmailVariableEntity entity);

    FindEmailVariableByIdOutput emailVariableEntityToFindEmailVariableByIdOutput(EmailVariableEntity entity);

    FindEmailVariableByNameOutput emailVariableEntityToFindEmailVariableByNameOutput(EmailVariableEntity entity);
    
    List<DataSourceMetaOutput> dataSourceEntityToDataSourceMetaList(List<DataSourceMetaEntity> list);
    
}
