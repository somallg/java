package com.somallg.design.pattern.chapter03.component.impl;

import com.somallg.design.pattern.chapter03.component.Beverage;

public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
