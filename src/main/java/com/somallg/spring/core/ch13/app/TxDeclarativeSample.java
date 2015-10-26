package com.somallg.spring.core.ch13.app;

import com.somallg.spring.core.ch13.service.ContactService;
import com.somallg.spring.core.ch9.domain.Contact;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by somallg on 11/8/14.
 */
public class TxDeclarativeSample {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ch13/spring-hibernate-tx-xml.xml");

        ContactService contactService = context.getBean(ContactService.class);

        List<Contact> contacts = contactService.findAllWithDetail();

        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}

