package com.somallg.spring.core.ch7.aspectjannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJAnnotationExample {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("ch7/spring-aop-aspectj.xml");

        MyBean bean = context.getBean("myBean", MyBean.class);

        System.out.println("Bean");
        bean.execute();

        InputWrapper inputWrapper = context.getBean(InputWrapper.class);
        System.out.println(inputWrapper);
    }
}
