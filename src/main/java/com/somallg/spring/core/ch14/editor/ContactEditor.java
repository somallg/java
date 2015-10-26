package com.somallg.spring.core.ch14.editor;

import com.somallg.spring.core.ch14.domain.Contact;

import java.beans.PropertyEditorSupport;

/**
 * Created by somallg on 11/9/14.
 */
public class ContactEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        String[] arrays = s.split(" ");

        Contact c = new Contact();
        c.setFirstName(arrays[0]);
        c.setLastName(arrays[1]);

        setValue(c);
    }
}
