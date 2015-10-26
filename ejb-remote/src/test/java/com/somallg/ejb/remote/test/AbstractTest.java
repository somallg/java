package com.somallg.ejb.remote.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by somallg on 12/5/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ejb-remote-spring.xml")
@ActiveProfiles("test")
public abstract class AbstractTest {
    // base class for all test classes
}
