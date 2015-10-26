package com.somallg.ejbinwar.ejb.stateful.impl;

import com.somallg.ejbinwar.ejb.stateful.StatefulEJB;

import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 * Created by somallg on 11/21/2014.
 */

@Stateful
@Remote(StatefulEJB.class)
public class StatefulEJBImpl implements StatefulEJB {

    private int count;

    @Override
    public void decrement() {
        this.count--;
    }

    @Override
    public void increment() {
        this.count++;
    }

    @Override
    public int getCount() {
        return this.count;
    }
}
