package com.somallg.spring.core.ch7.aopnamespace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopNamespaceExample {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ch7/spring-aop-aopnamespace.xml");

        MyBean bean = context.getBean("myBean", MyBean.class);

        System.out.println("Bean");
        bean.execute();
    }

}
