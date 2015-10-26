package com.somallg.jax.ws.handler;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Created by somallg on 11/30/14.
 */
public class SOAPLogHandler implements SOAPHandler<SOAPMessageContext> {
    @SuppressWarnings("unchecked")
	@Override
    public Set<QName> getHeaders() {
        /*
         *  Return an empty set means the handler does not process any headers
         */
        return Collections.EMPTY_SET;
    }

    @Override
    public boolean handleFault(SOAPMessageContext soapMessageContext) {

        /*
         *  Return true means that message processing is to continue
         */
        return true;
    }

    @Override
    public void close(MessageContext messageContext) {
        // do nothing
    }

    @Override
    public boolean handleMessage(SOAPMessageContext soapMessageContext) {
        System.out.println("*** A SOAP message is received:");
        logSOAPMessage(soapMessageContext);
        /*
            Return true means the message processing is to continue
         */
        return true;
    }

    @SuppressWarnings("rawtypes")
	private void logSOAPMessage(SOAPMessageContext soapMessageContext) {
//        HttpServletRequest servletRequest = (HttpServletRequest) soapMessageContext.get(MessageContext.SERVLET_CONTEXT);

        Boolean outboundFlag = (Boolean) soapMessageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        Map httpRequestHeaders = (Map) soapMessageContext.get(MessageContext.HTTP_REQUEST_HEADERS);

        String httpRequestMethod = (String) soapMessageContext.get(MessageContext.HTTP_REQUEST_METHOD);

        Integer responseCode = (Integer) soapMessageContext.get(MessageContext.HTTP_RESPONSE_CODE);

        Map httpResponseHeaders = (Map) soapMessageContext.get(MessageContext.HTTP_RESPONSE_HEADERS);

        String requestPathInfo = (String) soapMessageContext.get(MessageContext.PATH_INFO);

        String queryString = (String) soapMessageContext.get(MessageContext.QUERY_STRING);

        QName wsdlService = (QName) soapMessageContext.get(MessageContext.WSDL_SERVICE);

        QName wsdlInterface = (QName) soapMessageContext.get(MessageContext.WSDL_INTERFACE);

        QName wsdlOperation = (QName) soapMessageContext.get(MessageContext.WSDL_OPERATION);

        QName wsdlPort = (QName) soapMessageContext.get(MessageContext.WSDL_PORT);

        SOAPMessage soapMessage = soapMessageContext.getMessage();

        /* Print logging data */
//        if (servletRequest != null) {
//            System.out.println(" Request URL from servlet request : " + servletRequest.getRequestURL());
//        }

        String directionString = (outboundFlag) ? "Outbound" : "Inbound";

        System.out.println(" Message direction " + directionString);
        System.out.println(" HTTP request headers: " + httpRequestHeaders);
        System.out.println(" HTTP request methods: " + httpRequestMethod);
        System.out.println(" HTTP response headers: " + httpResponseHeaders);
        System.out.println(" HTTP response code: " + responseCode);
        System.out.println(" HTTP request path info: " + requestPathInfo);
        System.out.println(" HTTP query string:" + queryString);
        System.out.println(" WSDL serivice " + wsdlService);
        System.out.println(" WSDL interface" + wsdlInterface);
        System.out.println(" WSDL operation" + wsdlOperation);
        System.out.println(" WSDL port: " + wsdlPort);

        try {
            soapMessage.writeTo(System.out);
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
