package com.somallg.javaws.ch06.echo.service;

import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by somallg on 10/15/14.
 */
public class EchoPublisher {
    public static void main(String[] args) {
        Endpoint endpoint = Endpoint.create(new Echo());
        Binding binding = endpoint.getBinding();

        @SuppressWarnings("rawtypes")
		List<Handler> hchain = new LinkedList<Handler>();
        //hchain.add(new ServiceHandler());
        binding.setHandlerChain(hchain);

        String url = "http://localhost:7777/echo";
        System.out.printf(url);
        endpoint.publish(url);
    }
}
