package com.somallg.jax.ws.handler.client;

import com.somallg.jax.ws.CalculatorInterface;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by somallg on 11/30/14.
 */
public class CalculatorClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/calculator?wsdl");

        QName qName = new QName("http://ws.jax.somallg.com/", "CalculatorService");

        Service service = Service.create(url, qName);
        // add handler chain
        service.setHandlerResolver(new ClientHandlerResolver());

        CalculatorInterface servicePort = service.getPort(CalculatorInterface.class);

        System.out.println(servicePort.divide(101, 3));
    }
}
