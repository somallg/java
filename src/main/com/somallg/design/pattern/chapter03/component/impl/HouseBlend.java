package com.somallg.design.pattern.chapter03.component.impl;

import com.somallg.design.pattern.chapter03.component.Beverage;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
