package com.somallg.spring.core.ch9.test;

import com.somallg.spring.core.ch9.domain.Contact;
import com.somallg.spring.core.ch9.domain.ContactInterest;
import com.somallg.spring.core.ch9.domain.ContactTelDetail;
import com.somallg.spring.core.ch9.domain.Hobby;
import com.somallg.spring.core.ch9.service.ContactService;
import com.somallg.spring.core.test.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:ch9/spring-hibernate.xml")
public class SpringHibernateSampleTest extends SpringTest {

    @Autowired
    private ContactService contactService;

    @Test
    public void testContactService() {
        List<Contact> contacts = contactService.findAllWithDetail();
        listContactsWithDetail(contacts);
        assertEquals(3, contacts.size());
    }

    private static void listContactsWithDetail(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts with details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail : contact
                        .getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                }
            }

            if (contact.getContactInterests() != null) {
                for (ContactInterest contactInterest : contact
                        .getContactInterests()) {
                    System.out.println(contactInterest);
                }
            }

            if (contact.getHobbies() != null) {
                for (Hobby hobby : contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
            System.out.println();
        }
    }

}