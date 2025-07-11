package io.pragra.designpattern.observer;

import org.springframework.validation.ObjectError;

import java.util.Observable;
import java.util.Observer;

public class PhoneDisplay implements Observers {
    @Override
    public void update(float temperature) {
        System.out.println("Phone Display: Temp updated to " + temperature + "°C");
    }
}
class WatchDisplay implements Observers {
    @Override
    public void update(float temperature) {
        System.out.println("Watch Display: Temp updated to " + temperature + "°C");
    }


public static void main(String[] args) {
    WorkStation ws = new WorkStation();

    Observers obs = new PhoneDisplay();
    Observers obs2 = new WatchDisplay();

    ws.addObserver(obs);
    ws.addObserver(obs2);

    ws.setTemperature(28.0f);
    ws.setTemperature(29.0f);
}
}
