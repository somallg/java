package com.somallg.spring.core.ch10.repository;

import com.somallg.spring.core.ch10.domain.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by somallg on 12/8/14.
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findByFirstName(String firstName);

    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
