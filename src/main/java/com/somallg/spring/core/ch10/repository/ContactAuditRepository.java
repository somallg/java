package com.somallg.spring.core.ch10.repository;

import com.somallg.spring.core.ch10.domain.ContactAudit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by somallg on 12/8/14.
 */
public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long> {
}
