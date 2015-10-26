package com.somallg.spring.core.ch10.service.jpa;

import com.somallg.spring.core.ch10.domain.Contact;
import com.somallg.spring.core.ch10.service.ContactService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by somallg on 12/8/14.
 */
@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        List<Contact> contacts = em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
        return contacts;
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
        return null;
    }

    @Override
    public void deleteAll() {
    }

}
