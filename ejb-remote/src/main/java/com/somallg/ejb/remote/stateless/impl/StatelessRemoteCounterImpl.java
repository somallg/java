package com.somallg.ejb.remote.stateless.impl;

import com.somallg.ejb.remote.stateless.StatelessRemoteCounter;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by somallg on 11/20/2014.
 */

@Stateless
@Remote(StatelessRemoteCounter.class)
public class StatelessRemoteCounterImpl implements StatelessRemoteCounter {

    private int count = 0;

    @Override
    public void increment() {
        this.count++;
    }

    @Override
    public void decrement() {
        this.count--;
    }

    @Override
    public int getCount() {
        return this.count;
    }
}
