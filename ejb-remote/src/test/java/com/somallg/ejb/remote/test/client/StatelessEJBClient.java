package com.somallg.ejb.remote.test.client;

import com.somallg.ejb.remote.stateless.StatelessRemoteCounter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by somallg on 11/20/2014.
 */
public class StatelessEJBClient {

    private static int N = 10;

    public static void main(String[] args) throws NamingException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < N; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        invokeStatelessBean();
                        Thread.sleep(1000);
                    } catch (NamingException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
    }

    private static void invokeStatelessBean() throws NamingException {
        StatelessRemoteCounter statelessRemoteCounter = lookupStatelessCounter();

        for (int i = 0; i < 10; i++) {
            statelessRemoteCounter.increment();
        }

        for (int i = 0; i < 10; i++) {
            statelessRemoteCounter.decrement();
        }

        System.out.println(Thread.currentThread().getName() + " Stateless " + statelessRemoteCounter.getCount());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static StatelessRemoteCounter lookupStatelessCounter() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, ConstantEnum.JBOSS_CLIENT_NAMING.getValue());
        final Context context = new InitialContext(jndiProperties);

        // The JNDI lookup name for a stateless session bean has the syntax of:
        // ejb:<appName>/<moduleName>/<distinctName>/<beanName>!<viewClassName>
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
        return (StatelessRemoteCounter) context.lookup(
                "ejb:/ejb-remote/StatelessRemoteCounterImpl!" + StatelessRemoteCounter.class.getName());
    }
}
