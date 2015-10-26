package com.somallg.spring.core.ch9.service.impl;

import com.somallg.spring.core.ch9.dao.ContactDao;
import com.somallg.spring.core.ch9.domain.Contact;
import com.somallg.spring.core.ch9.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by somallg on 11/8/14.
 */

@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @SuppressWarnings("rawtypes")
	@Override
    @Transactional(readOnly = true)
    public List findAll() {
        return contactDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllWithDetail() {
        return contactDao.findAllWithDetail();
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return contactDao.findById(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    public void delete(Contact contact) {
        contactDao.delete(contact);
    }
}
