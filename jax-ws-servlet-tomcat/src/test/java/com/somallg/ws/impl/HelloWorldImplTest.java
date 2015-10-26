package com.somallg.ws.impl;

import com.somallg.jax.ws.servlet.tomcat.HelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jax-ws-servlet-tomcat-spring.xml")
public class HelloWorldImplTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HelloWorld helloWorld;

    @Test
    public void testSayHello() throws Exception {
        logger.info(helloWorld.sayHello("Lala"));
        logger.info(helloWorld.sayHello("Lili"));
        logger.info(helloWorld.sayHello("Lolo"));
    }

    @Test
    public void testSayHellos() throws Exception {
    }

    @Test
    public void testPrintHello() throws Exception {
    }
}