package com.somallg.ejb.remote.test.client;

/**
 * Created by somallg on 11/20/2014.
 */
public enum ConstantEnum {
    JBOSS_CLIENT_NAMING("org.jboss.ejb.client.naming");

    private String value;

    private ConstantEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
