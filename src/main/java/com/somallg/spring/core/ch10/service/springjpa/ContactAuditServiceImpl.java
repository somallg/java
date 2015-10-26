package com.somallg.spring.core.ch10.service.springjpa;

import com.somallg.spring.core.ch10.domain.ContactAudit;
import com.somallg.spring.core.ch10.repository.ContactAuditRepository;
import com.somallg.spring.core.ch10.service.ContactAuditService;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by somallg on 12/8/14.
 */
@Service("contactAuditService")
@Repository
@Transactional
public class ContactAuditServiceImpl implements ContactAuditService {

    @Autowired
    private ContactAuditRepository contactAuditRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<ContactAudit> findAll() {
        Iterable<ContactAudit> contactAudits = contactAuditRepository.findAll();
        List<ContactAudit> retVal = new ArrayList<ContactAudit>();

        for (ContactAudit c : contactAudits) {
            retVal.add(c);
        }

        return retVal;
    }

    @Override
    public ContactAudit findById(Long id) {
        return contactAuditRepository.findOne(id);
    }

    @Override
    public ContactAudit save(ContactAudit contact) {
        return contactAuditRepository.save(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public ContactAudit findAuditByRevision(Long id, int revision) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        return auditReader.find(ContactAudit.class, id, revision);
    }

    public List<Number> getRevisions(Long id) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        return auditReader.getRevisions(ContactAudit.class, id);
    }
}
