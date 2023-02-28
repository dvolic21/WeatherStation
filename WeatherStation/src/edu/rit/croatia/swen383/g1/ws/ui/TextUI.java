package edu.rit.croatia.swen383.g1.ws.ui;

import edu.rit.croatia.swen383.g1.ws.WeatherStation;
import edu.rit.croatia.swen383.g1.ws.observer.Observer;
import edu.rit.croatia.swen383.g1.ws.observer.Subject;
import edu.rit.croatia.swen383.g1.ws.util.MeasurementUnit;

import java.util.EnumMap;

/**
 * This class provides a simple text user interface for a weather station.
 */
public class TextUI implements Observer {

    private WeatherStation station;

    /**
     * Creates a new TextUI object that is associated with a WeatherStation.
     *
     * @param weatherStation The WeatherStation object that this UI is associated with.
     */
    public TextUI(WeatherStation weatherStation) {
        this.station = weatherStation;
        this.station.attach(this);
    }

    /**
     * Prints the current weather reading to the console.
     */
    public void update() {
        for (MeasurementUnit measurementUnit : MeasurementUnit.values()) {
            System.out.printf("Reading in %10s is %6.2f%n", measurementUnit, station.getReading(measurementUnit));
        }
        System.out.println(" ");
    }
}
