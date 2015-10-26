package com.somallg.javaws.ch1.timeservice.client.runtime;

import com.somallg.javaws.ch1.timeservice.ws.TimeServer;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by somallg on 5/12/14.
 */
public class TimeClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:9876/ts?wsdl");
        // Qualified name of the service:
        // 1st arg is the service URI
        // 2nd is the service name published in the WSDL
        QName qname = new QName("http://impl.ws.timeservice.ch1/", "TimeServerImplService");

        // Create, in effect, a factory for the service
        Service service = Service.create(url, qname);

        // Extract the endpoint interface, the service "port"
        TimeServer eif = service.getPort(TimeServer.class);

        System.out.println(eif.getTimeAsString());
        System.out.println(eif.getTimeAsElapsed());
        System.out.println(eif.getTime());
        System.out.println(eif.getPerson());
    }
}
