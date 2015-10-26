package com.somallg.javaws.ch06.echo.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by somallg on 10/15/14.
 */

@WebService
public class Echo {

    @WebMethod
    public String echo(String msg) {
        return "Echoing: " + msg;
    }
}
