package com.somallg.javaws.ch04.rand2;

import javax.xml.ws.Endpoint;

public class RandPublisher {
    public static void main(String[] args) {
        final String url = "http://localhost:8888/rs";
        System.out.println("Publishing RandService at endpoint " + url);
        Endpoint.publish(url, new RandServiceImpl());
    }
}