package com.somallg.jax.ws.authentication.test;

import com.somallg.jax.ws.authentication.HelloWorld;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloWorldImplTest {

    public static final String SERVICE_NAMESPACE = "http://impl.authentication.ws.jax.somallg.com/";
    public static final String SERVICE_NAME = "HelloWorldImplService";
    private static Service service;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        URL url = new URL("file:hello.xml");

        QName qName = new QName(SERVICE_NAMESPACE, SERVICE_NAME);

        service = Service.create(url, qName);
    }


    @Test
    public void testSayHello() throws Exception {
        HelloWorld servicePort = service.getPort(HelloWorld.class);

        BindingProvider bp = (BindingProvider) servicePort;

        bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");

        System.out.println(servicePort.sayHello());
    }
}