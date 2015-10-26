package com.somallg.jax.ws.client.normal;

import com.somallg.jax.ws.client.ServiceUtil;

import javax.xml.ws.Service;

import java.net.MalformedURLException;

/**
 * Created by somallg on 11/29/14.
 */

public class HelloWorldClientNormal {

    @SuppressWarnings("unused")
	public static void main(String[] args) throws MalformedURLException {

        Service service = ServiceUtil.getHelloWorldService();

//        HelloWorld helloWorld = service.getPort(HelloWorld.class);
//
//        System.out.println(helloWorld.sayHello("Lala"));
//        System.out.println(helloWorld.sayHellos("Lala", "LBL"));
    }
}
