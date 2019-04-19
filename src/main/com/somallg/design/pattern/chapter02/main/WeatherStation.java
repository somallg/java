package com.somallg.design.pattern.chapter02.main;

import com.somallg.design.pattern.chapter02.display.impl.CurrentConditionDisplay;
import com.somallg.design.pattern.chapter02.display.impl.ForecastDisplay;
import com.somallg.design.pattern.chapter02.display.impl.StatisticsDisplay;
import com.somallg.design.pattern.chapter02.observer.Observer;
import com.somallg.design.pattern.chapter02.subject.impl.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        Observer currentConditionsDisplay = new CurrentConditionDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        Observer forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30f);
        weatherData.setMeasurements(82, 70, 32f);
        weatherData.setMeasurements(78, 90, 34f);
    }
}
