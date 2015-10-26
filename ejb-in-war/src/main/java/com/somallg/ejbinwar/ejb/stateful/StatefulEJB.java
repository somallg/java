package com.somallg.ejbinwar.ejb.stateful;

/**
 * Created by somallg on 11/21/2014.
 */
public interface StatefulEJB {
    void decrement();

    void increment();

    int getCount();
}
