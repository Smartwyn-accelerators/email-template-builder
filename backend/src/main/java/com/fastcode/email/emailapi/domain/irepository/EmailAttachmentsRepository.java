package com.fastcode.email.emailapi.domain.irepository;

import com.fastcode.email.emailapi.domain.model.EmailAttachments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmailAttachmentsRepository extends JpaRepository<EmailAttachments, Long> {

}

