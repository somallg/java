package com.somallg.design.pattern.chapter03.decorator.impl;

import com.somallg.design.pattern.chapter03.component.Beverage;
import com.somallg.design.pattern.chapter03.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return 0.19 + beverage.cost();
    }
}
