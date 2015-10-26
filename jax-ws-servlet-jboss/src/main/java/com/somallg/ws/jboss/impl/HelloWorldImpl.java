package com.somallg.ws.jboss.impl;

import com.somallg.ws.jboss.HelloWorld;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 * Created by somallg on 11/18/14.
 */

@WebServlet(urlPatterns = "/*")
@WebService(endpointInterface = "com.somallg.ws.jboss.HelloWorld")
public class HelloWorldImpl extends HttpServlet implements HelloWorld {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
    private WebServiceContext webServiceContext;

    @Override
    public String sayHello() {
        MessageContext messageContext = webServiceContext.getMessageContext();

        for (String key : messageContext.keySet()) {
            System.out.println("Key= " + key + " value= " + messageContext.get(key));
        }

        System.out.println(messageContext.toString());

        return "Hello Lala";
    }
}
