package com.somallg.design.pattern.chapter03.decorator;

import com.somallg.design.pattern.chapter03.component.Beverage;

public abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
