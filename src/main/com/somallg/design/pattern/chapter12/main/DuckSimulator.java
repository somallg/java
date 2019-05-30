package com.somallg.design.pattern.chapter12.main;

import com.somallg.design.pattern.chapter12.adapter.Goose;
import com.somallg.design.pattern.chapter12.adapter.GooseAdapter;
import com.somallg.design.pattern.chapter12.composite.Flock;
import com.somallg.design.pattern.chapter12.decorator.QuackCounter;
import com.somallg.design.pattern.chapter12.duck.Quackable;
import com.somallg.design.pattern.chapter12.factory.AbstractDuckFactory;
import com.somallg.design.pattern.chapter12.factory.impl.CountingDuckFactory;
import com.somallg.design.pattern.chapter12.observable.impl.Quackologist;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    private void simulate(AbstractDuckFactory duckFactory) {
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\nDuck Simulator: With Composite");

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();
        flockOfMallards.add(duckFactory.createMallardDuck());
        flockOfMallards.add(duckFactory.createMallardDuck());
        flockOfMallards.add(duckFactory.createMallardDuck());
        flockOfMallards.add(duckFactory.createMallardDuck());

        flockOfDucks.add(flockOfMallards);

        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);

        System.out.println("\nDuck Simulator: Whole Flock");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Whole Flock of Mallards");
        simulate(flockOfMallards);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }
}
