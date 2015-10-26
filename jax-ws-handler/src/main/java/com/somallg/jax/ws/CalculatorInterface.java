package com.somallg.jax.ws;

import javax.jws.WebService;

/**
 * Created by somallg on 11/30/14.
 */

@WebService
public interface CalculatorInterface {
    int divide(int n1, int n2);
}
