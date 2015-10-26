package com.somallg.spring.core.ch1.test;

import com.somallg.spring.core.test.SpringTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by somallg on 4/12/15.
 */

@ContextConfiguration(locations = "classpath:ch1/spring-core.xml")
public abstract class SpringTestCh1 extends SpringTest {
}
