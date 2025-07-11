package io.pragra.designpattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class WorkStation implements Subject {
    private List<Observers> observers = new ArrayList<>();
    private float temperature;

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void addObserver(Observers obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observers obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observers obs : observers) {
            obs.update(temperature);
        }
    }
}
