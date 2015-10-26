package com.somallg.spring.core.ch9.app;

import com.somallg.spring.core.ch9.domain.Contact;
import com.somallg.spring.core.ch9.domain.ContactInterest;
import com.somallg.spring.core.ch9.domain.ContactTelDetail;
import com.somallg.spring.core.ch9.domain.Hobby;
import com.somallg.spring.core.ch9.service.ContactService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by somallg on 11/6/2014.
 */
public class SpringHibernateSample {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
                "ch9/spring-hibernate.xml");
        ContactService contactService = context.getBean(ContactService.class);

        List<Contact> contacts = contactService.findAllWithDetail();
        listContactsWithDetail(contacts);

        /**
         * Contact contact = contactDao.findById(1L); System.out.println("");
         * System.out.println("Contact with id 1 " + contact);
         * System.out.println("");
         *
         * // Add new contact; contact = new Contact();
         * contact.setFirstName("Micheal"); contact.setLastName("Jackson");
         * contact.setBirthDate(new Date());
         *
         * ContactTelDetail contactTelDetail = new ContactTelDetail();
         * contactTelDetail.setTelType("Home");
         * contactTelDetail.setTelNumber("1111111111111");
         *
         * contact.addContactTelDetail(contactTelDetail);
         * contactDao.save(contact);
         *
         * listContactsWithDetail(contactDao.findAllWithDetail());
         */
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
