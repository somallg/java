package com.somallg.design.pattern.chapter12.factory;

import com.somallg.design.pattern.chapter12.duck.Quackable;

public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedheadDuck();
    public abstract Quackable createDuckCall();
    public abstract Quackable createRubberDuck();
}
