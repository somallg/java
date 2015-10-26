package com.somallg.jax.ws.handler.test;

import com.somallg.jax.ws.CalculatorInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by somallg on 12/1/2014.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jax-ws-handler-test.xml")
public class CalculatorTest {

    @Autowired
    private CalculatorInterface calculatorInterface;

    @Test
    public void testDivide() {
        assertNotNull(calculatorInterface);
        assertEquals(100, calculatorInterface.divide(100, 1));
        assertEquals(50, calculatorInterface.divide(100, 2));
        assertEquals(33, calculatorInterface.divide(100, 3));
    }
}
