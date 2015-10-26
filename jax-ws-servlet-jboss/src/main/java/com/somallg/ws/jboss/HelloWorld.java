package com.somallg.ws.jboss;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by somallg on 11/18/14.
 */

@WebService
public interface HelloWorld {

    @WebMethod
    String sayHello();
}
