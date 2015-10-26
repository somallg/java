package com.somallg.jax.ws.authentication.test;

import com.somallg.jax.ws.authentication.HelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by somallg on 12/5/2014.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jax-ws-authentication-spring.xml")
@ActiveProfiles("test")
public class HelloWorldSpringTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private HelloWorld helloWorld;

    @Test
    public void testHelloWorld() {
        logger.info("JAX-WS with container-managed authentication");
        logger.info(helloWorld.sayHello());
        logger.info(helloWorld.sayHello());
        logger.info(helloWorld.sayHello());
    }
}
