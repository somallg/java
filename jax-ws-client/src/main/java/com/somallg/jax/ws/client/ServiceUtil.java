package com.somallg.jax.ws.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by somallg on 11/29/14.
 */
public class ServiceUtil {
    public static Service getHelloWorldService() throws MalformedURLException {
        URL url = new URL(Constants.WSDL_URL);

        QName qName = new QName(Constants.SERVICE_NAMESPACE,
                Constants.SERVICE_NAME);

        return Service.create(url, qName);
    }
}
