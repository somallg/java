package com.somallg.javaws.ch02.ts;

import javax.xml.ws.Endpoint;

/**
 * Created by somallg on 5/12/14.
 */
public class TimeServerPublisher {
    public static void main(String[] args) {
        // 1st Argument is the publication URL
        // 2nd argument is SIB instance
        Endpoint.publish("http://127.0.0.1:9876/ts", new TimeServerImpl());
    }
}