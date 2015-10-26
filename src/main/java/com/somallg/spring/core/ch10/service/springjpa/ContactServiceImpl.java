package com.somallg.spring.core.ch10.service.springjpa;

import com.somallg.spring.core.ch10.domain.Contact;
import com.somallg.spring.core.ch10.repository.ContactRepository;
import com.somallg.spring.core.ch10.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by somallg on 12/8/14.
 */

@Service("springJpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {

        List<Contact> contacts = new ArrayList<Contact>();

        for (Contact c : contactRepository.findAll()) {
            contacts.add(c);
        }

        return contacts;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
        return contactRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public void deleteAll() {
        contactRepository.deleteAll();
    }
}
