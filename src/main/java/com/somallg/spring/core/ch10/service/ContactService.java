package com.somallg.spring.core.ch10.service;

import com.somallg.spring.core.ch10.domain.Contact;

import java.util.List;

public interface ContactService {

    // Find all contacts
    List<Contact> findAll();

    // Find contacts by first name
    List<Contact> findByFirstName(String firstName);

    // Find contacts by first name and last name
    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);

    void deleteAll();
}
