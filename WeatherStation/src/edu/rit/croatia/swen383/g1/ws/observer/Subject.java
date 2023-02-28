package edu.rit.croatia.swen383.g1.ws.observer;

import java.util.ArrayList;

    /**
     * @author: Michel Brassard
     * @author: Luka Kocovic
     * @author: Bruno Leka
     * @author: Dominik Volic
     * @author: Mislav Culjak
     * @author: Tarik Ceco
     */
public class Subject {
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    /**
     * Instantiates a new Subject.
     */
    public Subject() {}

    /**
     * Attaches a new observer to the list of observers.
     *
     * @param observer the observer
     */
    public void attach(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * Detaches an observer from the list of observers.
     *
     * @param observer the observer
     */
    public void detach(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        if (!observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    /**
     * Notify observers.
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
