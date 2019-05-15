package com.somallg.design.pattern.chapter04.factorymethod;

import com.somallg.design.pattern.chapter04.factorymethod.product.NYStyleCheesePizza;
import com.somallg.design.pattern.chapter04.factorymethod.product.NYStyleVeggiePizza;
import com.somallg.design.pattern.chapter04.factorymethod.product.Pizza;

public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new NYStyleVeggiePizza();
        }

        return null;
    }
}
