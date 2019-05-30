package com.somallg.design.pattern.chapter12.adapter;

import com.somallg.design.pattern.chapter12.observable.Observer;
import com.somallg.design.pattern.chapter12.duck.Quackable;

public class GooseAdapter implements Quackable {

    Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
