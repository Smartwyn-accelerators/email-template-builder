package com.fastcode.email.emailapi.domain.irepository;

import com.fastcode.email.emailapi.domain.model.EmailHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailHistoryRepository extends JpaRepository<EmailHistory, Long> {

}


