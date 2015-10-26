package com;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by somallg on 7/28/14.
 */
public class MyListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("attributeAdded " + httpSessionBindingEvent.getName() + " " + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("attributeRemoved " + httpSessionBindingEvent.getName() + " " + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("attributeReplaced " + httpSessionBindingEvent.getName() + " " + httpSessionBindingEvent.getValue());
    }
}
