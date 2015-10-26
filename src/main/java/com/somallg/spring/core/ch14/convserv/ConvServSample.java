package com.somallg.spring.core.ch14.convserv;

import com.somallg.spring.core.ch14.domain.SimpleContact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by somallg on 11/9/14.
 */
public class ConvServSample {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("ch14/spring-converter.xml");

        SimpleContact contact = context.getBean(SimpleContact.class);

        System.out.println(contact);
    }
}
