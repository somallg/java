package com.somallg.design.pattern.chapter12.duck.impl;

import com.somallg.design.pattern.chapter12.duck.Quackable;
import com.somallg.design.pattern.chapter12.observable.Observer;
import com.somallg.design.pattern.chapter12.observable.impl.Observable;

public class DuckCall implements Quackable {
    Observable observable;

    public DuckCall() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println(toString() + " Kwak");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    @Override
    public String toString() {
        return "DuckCall";
    }
}
