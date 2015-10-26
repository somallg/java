package com.somallg.jax.ws.client.dispatch;

import com.somallg.jax.ws.client.Constants;
import com.somallg.jax.ws.client.ServiceUtil;
import com.somallg.jax.ws.client.beans.ObjectFactory;
import com.somallg.jax.ws.client.beans.SayHello;
import com.somallg.jax.ws.client.beans.SayHelloResponse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import javax.xml.ws.Service;

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by somallg on 11/29/14.
 */
public class HelloWorldClientDispatch {
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws MalformedURLException, JAXBException, ExecutionException, InterruptedException {
        Service service = ServiceUtil.getHelloWorldService();

        JAXBContext context = JAXBContext.newInstance("com.somallg.jax.ws.client.beans");

        QName portQName = new QName(Constants.SERVICE_NAMESPACE, Constants.SERVICE_PORT_NAME);

        Dispatch<Object> dispatch = service.createDispatch(portQName, context, Service.Mode.PAYLOAD);

        // prepare input param
        ObjectFactory objectFactory = new ObjectFactory();
        SayHello sayHelloRequest = objectFactory.createSayHello();
        sayHelloRequest.setArg0("Lala");
        JAXBElement<SayHello> helloElement = objectFactory.createSayHello(sayHelloRequest);


        //invoke synchronous
        JAXBElement<SayHelloResponse> responseElement =
                (JAXBElement<SayHelloResponse>) dispatch.invoke(helloElement);

        System.out.println("Invoke synchronous");
        System.out.println(responseElement.getValue().getReturn());
        System.out.println("=============================");

        //invoke asynchronous polling
        System.out.println("Invoke asynchronous polling");
        Response<Object> invokeAsync = dispatch.invokeAsync(helloElement);

        while (!invokeAsync.isDone()) {
            System.out.println("Request is not done yet...");
        }

        System.out.println("Request is done");

        responseElement = (JAXBElement<SayHelloResponse>) invokeAsync.get();

        System.out.println(responseElement.getValue().getReturn());
        System.out.println("=============================");

        // invoke asynchronous handler
        System.out.println("Invoke asynchronous handler");

        Future<?> future = dispatch.invokeAsync(helloElement, new AsyncHandler<Object>() {
            @Override
            public void handleResponse(Response<Object> response) {
                System.out.println("Response received");

                try {
                    JAXBElement<SayHelloResponse> responseElement = (JAXBElement<SayHelloResponse>) response.get();

                    System.out.println(responseElement.getValue().getReturn());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Waiting for request");
        future.get();
        System.out.println("Request is DONE!");
    }
}
