package com.somallg.spring.core.ch14.test;

import com.somallg.spring.core.ch14.domain.SimpleContact;
import com.somallg.spring.core.test.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath:ch14/spring-converter.xml")
public class ContactConverterTest extends SpringTest {

    @Autowired
    private SimpleContact simpleContact;

    @Test
    public void testConvert() throws Exception {
        System.out.println(simpleContact);
        assertEquals("Hello", simpleContact.getContact().getFirstName());
        assertEquals("Lala", simpleContact.getContact().getLastName());
    }
}