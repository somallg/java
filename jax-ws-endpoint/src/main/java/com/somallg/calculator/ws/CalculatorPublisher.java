package com.somallg.calculator.ws;

import javax.xml.ws.Endpoint;

public class CalculatorPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9876/calcul", new Calculator());
    }

}
