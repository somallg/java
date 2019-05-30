package com.somallg.design.pattern.chapter12.duck;

import com.somallg.design.pattern.chapter12.observable.QuackObservable;

public interface Quackable extends QuackObservable {
    public void quack();
}
