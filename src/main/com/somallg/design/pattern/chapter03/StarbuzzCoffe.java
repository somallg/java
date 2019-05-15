package com.somallg.design.pattern.chapter03;

import com.somallg.design.pattern.chapter03.component.Beverage;
import com.somallg.design.pattern.chapter03.component.impl.Espresso;
import com.somallg.design.pattern.chapter03.decorator.impl.Mocha;
import com.somallg.design.pattern.chapter03.decorator.impl.Whip;

public class StarbuzzCoffe {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $ " + beverage.cost());

        Beverage beverage2 = new Espresso();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);

        System.out.println(beverage2.getDescription() + " $ " + beverage2.cost());
    }
}
