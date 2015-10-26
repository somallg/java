package com.somallg.jax.ws;

import javax.jws.HandlerChain;
import javax.jws.WebService;

/**
 * Created by somallg on 11/30/14.
 */

@WebService(endpointInterface = "com.somallg.jax.ws.CalculatorInterface")
@HandlerChain(file = "handlerChain.xml")
public class Calculator implements CalculatorInterface {

    public int divide(int n1, int n2) {
        System.out.println("Dividing " + n1 + " and " + n2);

        if (n1 == 10) {
            throw new IllegalArgumentException("System exception");
        }

        return n1 / n2;
    }
}
