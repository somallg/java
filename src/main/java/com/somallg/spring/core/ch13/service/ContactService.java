package com.somallg.spring.core.ch13.service;

import com.somallg.spring.core.ch9.domain.Contact;

import java.util.List;

/**
 * Created by somallg on 11/8/14.
 */
public interface ContactService {

    List<Contact> findAll();

    List<Contact> findAllWithDetail();
}
