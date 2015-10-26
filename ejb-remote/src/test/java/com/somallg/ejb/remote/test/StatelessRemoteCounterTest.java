package com.somallg.ejb.remote.test;

import com.somallg.ejb.remote.stateless.StatelessRemoteCounter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by somallg on 12/5/2014.
 */
public class StatelessRemoteCounterTest extends AbstractTest {

    @Autowired
    private StatelessRemoteCounter remoteCounter;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testCounter() {
        for (int i = 0; i < 10; i++) {
            remoteCounter.increment();
        }

        logger.info("Count = " + remoteCounter.getCount());
    }
}
