package com.somallg.jax.ws.servlet.tomcat.impl;

import com.somallg.jax.ws.servlet.tomcat.HelloWorld;

import javax.jws.Oneway;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

/**
 * Created by somallg on 11/18/2014.
 */

@WebService(
        endpointInterface = "com.somallg.jax.ws.servlet.tomcat.HelloWorld",
        portName = "HelloWorldPort",
        serviceName = "HelloWorldService",
        targetNamespace = "http://www.somallg.com/hello"
)
@Addressing(enabled = true, required = true)
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }

    @Override
    public String sayHellos(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName + "!";
    }

    @Override
    @Oneway
    public void printHello() {
        System.out.println("Hello World!");
    }
}
