package com.somallg.javaws.ch1.teamservice.publisher;

import com.somallg.javaws.ch1.teamservice.ws.impl.TeamsImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by somallg on 5/12/14.
 */
public class TeamPublisher {
    public static void main(String[] args) {
        int port = 8888;
        String url = "http://localhost:" + port + "/teams";
        System.out.println("Publishing Teams on port " + port);
        Endpoint.publish(url, new TeamsImpl());
    }
}
