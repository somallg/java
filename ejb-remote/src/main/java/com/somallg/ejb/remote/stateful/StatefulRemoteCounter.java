package com.somallg.ejb.remote.stateful;

/**
 * Created by somallg on 11/20/2014.
 */
public interface StatefulRemoteCounter {

    void increment();

    void decrement();

    int getCount();
}
