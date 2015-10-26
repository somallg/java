package com.somallg.spring.core.ch7.proxyfactorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyFactoryBeanExample {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ch7/spring-aop-proxyfactorybean.xml");

        MyBean bean1 = context.getBean("myBean1", MyBean.class);
        MyBean bean2 = context.getBean("myBean2", MyBean.class);

        System.out.println("Bean 1");
        bean1.execute();

        System.out.println("Bean 2");
        bean2.execute();
    }

}
