package com.somallg.spring.core.ch10.test;

import com.somallg.spring.core.ch10.domain.ContactAudit;
import com.somallg.spring.core.ch10.service.ContactAuditService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by somallg on 12/8/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ch10/spring-data-app-context.xml")
public class ContactAuditServiceTest {

    @Autowired
    private ContactAuditService contactAuditService;

    private static void listContacts(List<ContactAudit> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");
        for (ContactAudit contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }

    @Test
    public void testFindAll() throws Exception {
        List<ContactAudit> contacts = contactAuditService.findAll();

        listContacts(contacts);

        System.out.println("Add new contact");
        ContactAudit contact = new ContactAudit();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        contactAuditService.save(contact);
        contacts = contactAuditService.findAll();
        listContacts(contacts);

        // Update contact
        System.out.println("Update contact");
        contact.setFirstName("Tom");
        contactAuditService.save(contact);
        contacts = contactAuditService.findAll();
        listContacts(contacts);

        // Find audit record by revision
        ContactAudit oldContact = contactAuditService.findAuditByRevision(4L, 1);
        System.out.println("");
        System.out.println("Old Contact with id 4 and rev 1:" + oldContact);
        System.out.println("");
        oldContact = contactAuditService.findAuditByRevision(4L, 2);
        System.out.println("");
        System.out.println("Old Contact with id 4 and rev 2:" + oldContact);
        System.out.println("");

        List<Number> revisions = contactAuditService.getRevisions(4L);
        System.out.println(revisions);
    }
}
