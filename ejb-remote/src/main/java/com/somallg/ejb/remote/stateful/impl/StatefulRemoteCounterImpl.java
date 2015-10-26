package com.somallg.ejb.remote.stateful.impl;

import com.somallg.ejb.remote.stateful.StatefulRemoteCounter;

import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 * Created by somallg on 11/20/2014.
 */

@Stateful
@Remote(StatefulRemoteCounter.class)
public class StatefulRemoteCounterImpl implements StatefulRemoteCounter {

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
