package com.somallg.spring.core.ch1.test;

import com.somallg.spring.core.ch1.SpringSpEL;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpringSpELTest extends SpringTestCh1 {

    @Autowired
    private SpringSpEL springSpEL;

    @Test
    public void testSpringEL() {
        assertEquals("LBL", springSpEL.getName());
        assertEquals(23, springSpEL.getAge());
        assertTrue(!springSpEL.isYoung());
    }
}