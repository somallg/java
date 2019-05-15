package com.somallg.design.pattern.chapter03.decorator.impl;

import com.somallg.design.pattern.chapter03.component.Beverage;
import com.somallg.design.pattern.chapter03.decorator.CondimentDecorator;

public class Mocha extends CondimentDecorator {
   Beverage beverage;

   public Mocha(Beverage beverage) {
       this.beverage = beverage;
   }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }
}
