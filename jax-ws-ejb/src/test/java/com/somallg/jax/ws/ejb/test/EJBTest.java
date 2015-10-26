package com.somallg.jax.ws.ejb.test;

import com.somallg.jax.ws.ejb.EJBHelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by somallg on 12/5/2014.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jax-ws-ejb-spring.xml")
public class EJBTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private EJBHelloWorld ejbHelloWorld;

    @Test
    public void testEJBHelloWorld() {
        logger.info("Test Jax-WS EJB");
        logger.info(ejbHelloWorld.sayHello());
    }
}
