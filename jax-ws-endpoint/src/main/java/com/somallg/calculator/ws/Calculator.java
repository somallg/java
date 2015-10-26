package com.somallg.calculator.ws;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceContext;

/**
 * Calculator service implementation class
 */

@WebService(
        name = "Calculator",
        serviceName = "CalculatorService",
        targetNamespace = "http://www.somallg.com/calculator")
@SOAPBinding(
        parameterStyle = SOAPBinding.ParameterStyle.WRAPPED,
        style = SOAPBinding.Style.DOCUMENT,
        use = SOAPBinding.Use.LITERAL)
public class Calculator {
    @Resource
    private WebServiceContext context;

    @PostConstruct
    @WebMethod(exclude = true)
    public void init() {
        System.out.println("WS initialized, context: " + context);
    }

    @WebMethod(
            operationName = "addNumbers", action = "urn:Add")
    public int add(final int n1, final int n2) {
        System.out.println("Adding " + n1 + " and " + n2);
        return n1 + n2;
    }
}
