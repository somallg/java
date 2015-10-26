package com.somallg.ejb.remote.test;

import com.somallg.ejb.remote.stateless.StatelessHelloWorld;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by somallg on 12/5/2014.
 */

public class StatelessHelloWorldTest extends AbstractTest {

    @Autowired
    private StatelessHelloWorld helloWorld;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testHelloWorld() {
        logger.info(helloWorld.sayHello());
        logger.info(helloWorld.sayHello());
        logger.info(helloWorld.sayHello());
    }
}
