package com.somallg.ejb.remote.test.client;

import com.somallg.ejb.remote.stateful.StatefulRemoteCounter;
import com.somallg.ejb.remote.test.client.ConstantEnum;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Hashtable;

/**
 * Created by somallg on 11/20/2014.
 */
public class StatefulEJBClient {

    public static void main(String[] args) throws NamingException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        invokeStatefulBean();
                    } catch (NamingException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    private static void invokeStatefulBean() throws NamingException {
        StatefulRemoteCounter statefulRemoteCounter = lookupStatefulCounter();

        for (int i = 0; i < 10; i++) {
            statefulRemoteCounter.increment();
        }

        for (int i = 0; i < 10; i++) {
            statefulRemoteCounter.decrement();
        }

        System.out.println(Thread.currentThread().getName() + " Stateful " + statefulRemoteCounter.getCount());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static StatefulRemoteCounter lookupStatefulCounter() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, ConstantEnum.JBOSS_CLIENT_NAMING.getValue());
        final Context context = new InitialContext(jndiProperties);

        // The JNDI lookup name for a stateful session bean has the syntax of:
        // ejb:<appName>/<moduleName>/<distinctName>/<beanName>!<viewClassName>?stateful
        //
        // <appName> The application name is the name of the EAR that the EJB is deployed in
        // (without the .ear). If the EJB JAR is not deployed in an EAR then this is
        // blank. The app name can also be specified in the EAR's application.xml
        //
        // <moduleName> By the default the module name is the name of the EJB JAR file (without the
        // .jar suffix). The module name might be overridden in the ejb-jar.xml
        //
        // <distinctName> : AS7 allows each deployment to have an (optional) distinct name.
        // This example does not use this so leave it blank.
        //
        // <beanName> : The name of the session been to be invoked.
        //
        // <viewClassName>: The fully qualified classname of the remote interface. Must include
        // the whole package name.

        // let's do the lookup
        return (StatefulRemoteCounter) context.lookup(
                "ejb:/ejb-remote/StatefulRemoteCounterImpl!" + StatefulRemoteCounter.class.getName() + "?stateful");
    }
}
