package com.somallg.spring.core.ch9.service;

import com.somallg.spring.core.ch9.domain.Contact;

import java.util.List;

public interface ContactService {

    @SuppressWarnings("rawtypes")
	List findAll();

    List<Contact> findAllWithDetail();

    Contact findById(Long id);

    Contact save(Contact contact);

    void delete(Contact contact);
}
