package com.somallg.jax.ws.ejb.test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.somallg.jax.ws.ejb.EJBHelloWorld;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by somallg on 11/21/14.
 */
public class EJBClient {

    private static final String WSDL_URL = "http://localhost:8080/jax-ws-ejb/EJBHelloWorldService/EJBHelloWorldImpl?wsdl";

    private static final String NAMESPACE = "http://www.somallg.com/jax-ws-ejb";

    private static final String SERVICE_NAME = "EJBHelloWorldService";

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL(WSDL_URL);
        QName qName = new QName(NAMESPACE, SERVICE_NAME);

        Service service = Service.create(url, qName);

        EJBHelloWorld helloWorld = service.getPort(EJBHelloWorld.class);

        System.out.println(helloWorld.sayHello());
    }
}
