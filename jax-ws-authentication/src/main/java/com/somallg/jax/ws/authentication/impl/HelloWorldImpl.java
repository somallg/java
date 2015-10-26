package com.somallg.jax.ws.authentication.impl;

import com.somallg.jax.ws.authentication.HelloWorld;

import javax.jws.WebService;

/**
 * Created by somallg on 12/4/2014.
 */

@WebService(endpointInterface = "com.somallg.jax.ws.authentication.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String sayHello() {
        return "Hello World";
    }
}
