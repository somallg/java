package com.somallg.design.pattern.chapter12.observable;

import com.somallg.design.pattern.chapter12.observable.Observer;

public interface QuackObservable {
    public void registerObserver(Observer observer);
    public void notifyObservers();
}
