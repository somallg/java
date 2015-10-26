package com.somallg.jax.ws.ejb.impl;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import com.somallg.jax.ws.ejb.EJBHelloWorld;

/**
 * Created by somallg on 11/21/14.
 */

@WebService(
        endpointInterface = "com.somallg.jax.ws.ejb.EJBHelloWorld",
        targetNamespace = "http://www.somallg.com/jax-ws-ejb",
        serviceName = "EJBHelloWorldService",
        portName = "EJBHelloWorldPort"
)
@Remote(EJBHelloWorld.class)
@Stateless
public class EJBHelloWorldImpl implements EJBHelloWorld {

    @Resource
    private WebServiceContext webServiceContext;

    @Override
    public String sayHello() {

        System.out.println(webServiceContext.toString());

        return "Hello Lala from EJB";
    }

    @Override
	public int increment() {
		return 0;
	}
}
