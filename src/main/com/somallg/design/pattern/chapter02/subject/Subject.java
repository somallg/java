package com.somallg.design.pattern.chapter02.subject;

import com.somallg.design.pattern.chapter02.observer.Observer;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
