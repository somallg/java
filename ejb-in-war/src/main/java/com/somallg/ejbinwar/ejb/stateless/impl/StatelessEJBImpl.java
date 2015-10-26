package com.somallg.ejbinwar.ejb.stateless.impl;

import com.somallg.ejbinwar.ejb.stateless.StatelessEJB;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by somallg on 11/21/2014.
 */

@Stateless
@Remote(StatelessEJB.class)
public class StatelessEJBImpl implements StatelessEJB {
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
