package com.somallg.spring.core.ch16.jms.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by somallg on 11/9/14.
 */
public class JmsListenerSample {

    public static void main(String[] args) throws InterruptedException {
        @SuppressWarnings({ "resource", "unused" })
		ApplicationContext context = new ClassPathXmlApplicationContext("ch16/spring-jms.xml");

        while (true) {
            Thread.sleep(1000);
        }
    }
}
