package com.somallg.javaws.ch02.ts;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by somallg on 5/12/14.
 */

/**
 * @WebService signals this is the SEI
 * @WebMethod signals each method is a service operation
 * @SOAPBinding specify the construction of the service contract
 */
@WebService
//@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface TimeServer {
    @WebMethod
    String getTimeAsString();

    @WebMethod
    long getTimeAsElapsed();
}
