package io.pragra.designpattern.observer;

import java.util.Observer;

public interface Subject {
    void addObserver(Observers obs);
    void removeObserver(Observers obs);
    void notifyObservers();
}
