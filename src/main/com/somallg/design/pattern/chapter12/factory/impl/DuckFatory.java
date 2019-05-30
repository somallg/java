package com.somallg.design.pattern.chapter12.factory.impl;

import com.somallg.design.pattern.chapter12.duck.Quackable;
import com.somallg.design.pattern.chapter12.duck.impl.DuckCall;
import com.somallg.design.pattern.chapter12.duck.impl.MallardDuck;
import com.somallg.design.pattern.chapter12.duck.impl.RedheadDuck;
import com.somallg.design.pattern.chapter12.duck.impl.RubberDuck;
import com.somallg.design.pattern.chapter12.factory.AbstractDuckFactory;

public class DuckFatory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }
}
