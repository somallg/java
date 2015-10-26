package com.somallg.spring.core.ch8.app;

import com.somallg.spring.core.ch8.dao.ContactDao;
import com.somallg.spring.core.ch8.domain.Contact;
import com.somallg.spring.core.ch8.domain.ContactTelDetail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcContacDaoSample {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
                "ch8/spring-embedded-database.xml");

        ContactDao contactDao = context.getBean("contactDao", ContactDao.class);

        System.out.println("First name for contact id 1 is: "
                + contactDao.findFirstNameById(1L));
        System.out.println("Last name for contact id 1 is: "
                + contactDao.findLastNameById(1L));

        System.out.println(contactDao.findAll());

        List<Contact> contactsWithDetail = contactDao.findAllWithDetail();
        for (Contact contact : contactsWithDetail) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail : contact
                        .getContactTelDetails()) {
                    System.out.println("---" + contactTelDetail);
                }
            }
            System.out.println();
        }
    }
}
