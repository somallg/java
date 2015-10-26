package com.somallg.spring.core.ch5.javaconfig;

import com.somallg.spring.core.ch5.event.Publisher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExample {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Publisher publisher = context.getBean("publisher", Publisher.class);
        publisher.publish("Hello lala");
        publisher.publish("Hello lala");
    }
}
