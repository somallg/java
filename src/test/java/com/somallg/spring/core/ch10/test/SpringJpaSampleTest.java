package com.somallg.spring.core.ch10.test;

import com.somallg.spring.core.ch10.domain.Contact;
import com.somallg.spring.core.ch10.service.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by somallg on 12/8/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ch10/spring-data-app-context.xml")
public class SpringJpaSampleTest {

    @Qualifier("springJpaContactService")
    @Autowired
    private ContactService contactService;

    private static void listContacts(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }

    @Test
    public void testFindAll() throws Exception {
        List<Contact> contacts = contactService.findAll();

        listContacts(contacts);
    }

    @Test
    public void testFindByFirstName() throws Exception {
        List<Contact> contacts = contactService.findByFirstName("Clarence");

        listContacts(contacts);
    }

    @Test
    public void testDeleteAll() throws Exception {
        contactService.deleteAll();

        List<Contact> contacts = contactService.findAll();

        listContacts(contacts);

        assertEquals(0, contacts.size());
    }
}
