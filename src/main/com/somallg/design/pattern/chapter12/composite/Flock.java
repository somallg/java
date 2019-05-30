package com.somallg.design.pattern.chapter12.composite;

import com.somallg.design.pattern.chapter12.observable.Observer;
import com.somallg.design.pattern.chapter12.duck.Quackable;
import com.somallg.design.pattern.chapter12.observable.impl.Observable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flock implements Quackable {
    List<Quackable> ducks = new ArrayList<>();
    Observable observable;

    public Flock() {
        observable = new Observable(this);
    }

    public void add(Quackable duck) {
        ducks.add(duck);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = ducks.iterator();

        while (iterator.hasNext()) {
            Quackable duck = iterator.next();
            duck.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator<Quackable> iterator = ducks.iterator();

        while (iterator.hasNext()) {
            Quackable duck = iterator.next();
            duck.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
    }
}
