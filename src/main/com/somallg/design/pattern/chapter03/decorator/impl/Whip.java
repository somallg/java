package com.somallg.design.pattern.chapter03.decorator.impl;

import com.somallg.design.pattern.chapter03.component.Beverage;
import com.somallg.design.pattern.chapter03.decorator.CondimentDecorator;

public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return 0.29 + beverage.cost();
    }
}
