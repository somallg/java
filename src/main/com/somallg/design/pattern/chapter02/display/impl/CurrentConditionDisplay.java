package com.somallg.design.pattern.chapter02.display.impl;

import com.somallg.design.pattern.chapter02.display.DisplayElement;
import com.somallg.design.pattern.chapter02.observer.Observer;
import com.somallg.design.pattern.chapter02.subject.Subject;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temp;
    private float humidity;
    private Subject subject;

    public CurrentConditionDisplay(Subject s) {
        this.subject = s;
        s.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(String.format("Current Condition Display: temperature: %f and humidity %f", temp, humidity));
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }
}
