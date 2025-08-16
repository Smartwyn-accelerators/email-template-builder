package com.fastcode.email.emailbuilder.domain.irepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastcode.email.emailbuilder.domain.model.EmailVariableTypeEntity;

public interface IEmailVariableTypeRepository extends JpaRepository<EmailVariableTypeEntity, Long> {

}
