package com.somallg.ws.jboss.client;

import com.somallg.ws.jboss.HelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by somallg on 11/19/14.
 */
public class HelloClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/java-ws-jboss?wsdl");

        QName qName = new QName("http://impl.jboss.ws.somallg.com/", "HelloWorldImplService");

        Service service = Service.create(url, qName);

        HelloWorld servicePort = service.getPort(HelloWorld.class);

        for (int i = 0; i < 1; i++) {
            System.out.println(servicePort.sayHello());
        }
    }
}
