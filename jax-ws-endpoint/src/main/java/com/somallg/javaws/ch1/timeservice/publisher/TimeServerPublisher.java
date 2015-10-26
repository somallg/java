package com.somallg.javaws.ch1.timeservice.publisher;

import com.somallg.javaws.ch1.timeservice.ws.impl.TimeServerImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by somallg on 5/12/14.
 */
public class TimeServerPublisher {

    private static String PUBLISH_URL = "http://localhost:9876/ts";

    public static void main(String[] args) {
        // 1st Argument is the publication URL
        // 2nd argument is SIB instance
        System.out.println("Publish TimeWS to " + PUBLISH_URL);
        Endpoint.publish(PUBLISH_URL, new TimeServerImpl());
    }
}