package com.somallg.javaws.ch1.timeservice.ws;    // time server

import com.somallg.javaws.ch1.timeservice.domain.Person;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;

/**
 * Created by somallg on 5/12/14.
 */

/**
 * @WebService signals this is the SEI
 * @WebMethod signals each method is a service operation
 * @SOAPBinding specify the construction of the service contract
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface TimeServer {
    @WebMethod
    String getTimeAsString();

    @WebMethod
    long getTimeAsElapsed();

    @WebMethod
    Date getTime();

    @WebMethod
    Person getPerson();
}
