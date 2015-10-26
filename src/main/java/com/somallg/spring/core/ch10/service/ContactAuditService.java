package com.somallg.spring.core.ch10.service;

import com.somallg.spring.core.ch10.domain.ContactAudit;

import java.util.List;

/**
 * Created by somallg on 12/8/14.
 */
public interface ContactAuditService {

    List<ContactAudit> findAll();

    ContactAudit findById(Long id);

    ContactAudit save(ContactAudit contact);

    ContactAudit findAuditByRevision(Long id, int revision);

    List<Number> getRevisions(Long id);
}
