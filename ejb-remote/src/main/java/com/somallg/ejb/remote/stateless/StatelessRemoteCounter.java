package com.somallg.ejb.remote.stateless;

/**
 * Created by somallg on 11/20/2014.
 */
public interface StatelessRemoteCounter {

    void increment();

    void decrement();

    int getCount();
}
