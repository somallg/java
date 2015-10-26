package com.somallg.jax.ws.authentication;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by somallg on 12/4/2014.
 */

@WebService
public interface HelloWorld {

    @WebMethod
    String sayHello();
}
