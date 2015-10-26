package com.somallg.spring.core.ch8.dao;

import com.somallg.spring.core.ch8.domain.Contact;

import java.util.List;

public interface ContactDao {

    String findFirstNameById(Long id);

    String findLastNameById(Long id);

    List<Contact> findAll();

    List<Contact> findByFirstName(String firstName);

    List<Contact> findAllWithDetail();

    void insert(Contact contact);

    void update(Contact contact);

    void delete(Long contactId);

}
