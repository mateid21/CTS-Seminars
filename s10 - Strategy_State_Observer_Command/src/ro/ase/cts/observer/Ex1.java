package ro.ase.cts.observer;

import java.util.ArrayList;
import java.util.List;

interface Subject{
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers();
}

interface Observer{
    void update(float temperature, float humidity, float pressure);
}

class WeatherDisplay implements Observer{
    private float temperature;
    private float humidity;
    private float pressure;


    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    private void display(){
        System.out.println("Temperature: " + temperature + " degrees, Humidity: " + humidity + "%, Pressure: " + pressure + "Pa.");
    }
}

class WeatherStation implements Subject{
    private float temperature;
    private float humidity;
    private float pressure;
    private List<Observer> observers;

    public WeatherStation(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}

public class Ex1 {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        WeatherDisplay display1 = new WeatherDisplay();
        WeatherDisplay display2 = new WeatherDisplay();

        weatherStation.registerObserver(display1);
        weatherStation.registerObserver(display2);

        weatherStation.setMeasurements(75,60,30.4f);
        weatherStation.setMeasurements(80,65,29.2f);
    }
}
