package com.somallg.spring.core.ch13.dao;

import com.somallg.spring.core.ch13.domain.Contact;

import java.util.List;

public interface ContactDao {

    @SuppressWarnings("rawtypes")
	List findAll();

    List<Contact> findAllWithDetail();

    Contact findById(Long id);

    Contact save(Contact contact);

    void delete(Contact contact);
}
