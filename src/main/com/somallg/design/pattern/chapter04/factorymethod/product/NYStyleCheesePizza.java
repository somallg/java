package com.somallg.design.pattern.chapter04.factorymethod.product;

public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY Style Pizza";
        dough = "Thing Crust";
        sauce = "Marinara Sauce";

        toppings.add("Double Cheese");
    }
}
