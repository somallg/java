package com.somallg.design.pattern.chapter12.observable.impl;

import com.somallg.design.pattern.chapter12.observable.Observer;
import com.somallg.design.pattern.chapter12.observable.QuackObservable;

public class Quackologist implements Observer {

    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked");
        System.out.println("====");
    }
}
