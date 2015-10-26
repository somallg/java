package com.somallg.ejb.remote.stateless.impl;

import com.somallg.ejb.remote.stateless.StatelessHelloWorld;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by somallg on 11/20/2014.
 */

@Stateless
@Remote(StatelessHelloWorld.class)
public class StatelessHelloWorldImpl implements StatelessHelloWorld {
    @Override
    public String sayHello() {
        return "Hello Lala";
    }
}
