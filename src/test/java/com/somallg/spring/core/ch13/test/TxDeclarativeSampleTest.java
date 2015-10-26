package com.somallg.spring.core.ch13.test;

import com.somallg.spring.core.ch13.service.ContactService;
import com.somallg.spring.core.ch9.domain.Contact;
import com.somallg.spring.core.test.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath:ch13/spring-hibernate-tx-xml.xml")
public class TxDeclarativeSampleTest extends SpringTest {

    @Autowired
    private ContactService contactService;

    @Test
    public void testTxDeclarative() {
        List<Contact> contacts = contactService.findAllWithDetail();
        assertEquals(3, contacts.size());

        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

}