package com.somallg.ejbinwar.ejb.stateless;

/**
 * Created by somallg on 11/21/2014.
 */
public interface StatelessEJB {
    void decrement();

    void increment();

    int getCount();
}
