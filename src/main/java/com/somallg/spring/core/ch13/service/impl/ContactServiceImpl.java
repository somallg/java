package com.somallg.spring.core.ch13.service.impl;

import com.somallg.spring.core.ch13.service.ContactService;
import com.somallg.spring.core.ch9.dao.ContactDao;
import com.somallg.spring.core.ch9.domain.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by somallg on 11/8/14.
 */

@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @SuppressWarnings("unchecked")
	@Override
    public List<Contact> findAll() {
        return contactDao.findAll();
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return contactDao.findAllWithDetail();
    }
}
