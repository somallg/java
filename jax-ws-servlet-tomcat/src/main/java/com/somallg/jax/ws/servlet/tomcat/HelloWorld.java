package com.somallg.jax.ws.servlet.tomcat;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by somallg on 11/18/2014.
 */

@WebService
public interface HelloWorld {

    @WebMethod
    String sayHello(String name);

    @WebMethod
    String sayHellos(String firstName, String lastName);

    @WebMethod
    void printHello();
}
