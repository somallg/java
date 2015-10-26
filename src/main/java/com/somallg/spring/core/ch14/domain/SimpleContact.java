package com.somallg.spring.core.ch14.domain;

/**
 * Created by somallg on 11/9/14.
 */
public class SimpleContact {

    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "SimpleContact{" +
                "contact=" + contact +
                '}';
    }
}
