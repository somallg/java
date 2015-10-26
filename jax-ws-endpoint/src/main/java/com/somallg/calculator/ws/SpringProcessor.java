package com.somallg.calculator.ws;

import javax.xml.transform.Source;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceProvider;

/**
 * Created by somallg on 11/28/2014.
 */

@WebServiceProvider
public class SpringProcessor implements Provider<Source> {
    @Override
    public Source invoke(Source request) {

        System.out.println("SpringProcessor");

        return null;
    }
}
