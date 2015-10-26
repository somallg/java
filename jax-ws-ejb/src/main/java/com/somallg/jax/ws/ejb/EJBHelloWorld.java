package com.somallg.jax.ws.ejb;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by somallg on 11/21/14.
 */

@WebService
public interface EJBHelloWorld {

    @WebMethod
    String sayHello();

    @WebMethod
    int increment();
}
