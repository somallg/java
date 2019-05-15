package com.somallg.design.pattern.chapter04.factorymethod;

import com.somallg.design.pattern.chapter04.factorymethod.product.Pizza;

public class PizzaTestDrive {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ordered a " + pizza.name);
    }
}
