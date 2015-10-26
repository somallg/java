package com.somallg.spring.core.ch16.jms.app;

import com.somallg.spring.core.ch16.jms.sender.MessageSender;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by somallg on 11/9/14.
 */
public class JmsSenderSample {

    public static void main(String[] args) throws InterruptedException {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ch16/spring-jms-sender.xml");

        MessageSender messageSender = context.getBean(MessageSender.class);

        int i = 0;
        while (true) {
            messageSender.sendMessage("Hello Lala" + i++);
            Thread.sleep(500);
        }
    }
}
