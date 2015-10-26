package com.somallg.javaws.ch1.timeservice.multithread;

import com.somallg.javaws.ch1.timeservice.threadpool.MyThreadPool;
import com.somallg.javaws.ch1.timeservice.ws.impl.TimeServerImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by somallg on 5/12/14.
 */
public class TimePublisherMT {
    private Endpoint endpoint;

    public static void main(String[] args) {
        TimePublisherMT self = new TimePublisherMT();
        self.create_endpoint();
        self.configure_endpoint();
        self.publish();
    }

    private void create_endpoint() {
        endpoint = Endpoint.create(new TimeServerImpl());
    }

    private void configure_endpoint() {
        endpoint.setExecutor(new MyThreadPool());
    }

    private void publish() {
        int port = 8888;
        String url = "http://localhost:" + port + "/ts";
        endpoint.publish(url);
        System.out.println("Publishing TimeServer on port " + port);
    }
}
