package com.somallg.spring.core.ch14.converter;


import com.somallg.spring.core.ch14.domain.Contact;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by somallg on 11/9/14.
 */
public class ContactConverter implements Converter<String, Contact> {
    @Override
    public Contact convert(String s) {
        String[] arrays = s.split(" ");

        Contact c = new Contact();
        c.setFirstName(arrays[0]);
        c.setLastName(arrays[1]);

        return c;
    }
}
