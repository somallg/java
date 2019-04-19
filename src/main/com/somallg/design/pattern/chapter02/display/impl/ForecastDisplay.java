package com.somallg.design.pattern.chapter02.display.impl;

import com.somallg.design.pattern.chapter02.display.DisplayElement;
import com.somallg.design.pattern.chapter02.observer.Observer;
import com.somallg.design.pattern.chapter02.subject.Subject;

public class ForecastDisplay implements Observer, DisplayElement {

    private float temp;
    private float humidity;
    private float pressure;
    private Subject subject;

    public ForecastDisplay(Subject s) {
        this.subject = s;
        s.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(String.format("Forecast Display: temperature: %f, humidity %f and pressure: %f", temp, humidity, pressure));
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
