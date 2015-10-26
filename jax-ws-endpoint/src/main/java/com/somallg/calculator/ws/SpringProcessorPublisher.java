package com.somallg.calculator.ws;

import javax.xml.ws.Endpoint;

/**
 * Created by somallg on 11/28/2014.
 */
public class SpringProcessorPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9876/sp", new SpringProcessor());
    }
}
