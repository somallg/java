package com.somallg.jax.ws.handler.client;

import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import java.util.List;

/**
 * Created by somallg on 11/30/14.
 */
public class ClientHandlerResolver implements HandlerResolver {

    @SuppressWarnings("rawtypes")
	@Autowired
    List<Handler> handlerList;

    @SuppressWarnings("rawtypes")
	@Override
    public List<Handler> getHandlerChain(PortInfo portInfo) {
        return handlerList;
    }
}
