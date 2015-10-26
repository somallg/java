package com.somallg.spring.core.ch14.pe;

import com.somallg.spring.core.ch14.domain.SimpleContact;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by somallg on 11/9/14.
 */
public class PropEditorSample {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ch14/spring-editor.xml");

        SimpleContact contact = context.getBean(SimpleContact.class);

        System.out.println(contact);
    }
}
