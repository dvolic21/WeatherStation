package edu.rit.croatia.swen383.g1.ws.util;

import java.util.ArrayList;
import java.util.List;

/**
 * This enum holds the constants for temperature and pressure measurement units
 * .
 * 
 * @author Michel Brassard
 * @author: Luka Kocovic
 * @author: Bruno Leka
 * @author: Dominik Volic
 * @author: Mislav Culjak
 * @author: Tarik Ceco
 * @version 1
 */
public enum MeasurementUnit {
    /**
     * Kelvin measurement unit.
     */
    KELVIN(SensorType.TEMPERATURE, 1, 0),
    /**
     * Celsius measurement unit.
     */
    CELSIUS(SensorType.TEMPERATURE, 1, -27315),
    /**
     * Fahrenheit measurement unit.
     */
    FAHRENHEIT(SensorType.TEMPERATURE, 1.8, -45967),
    /**
     * Inhg measurement unit.
     */
    INHG(SensorType.PRESSURE, 1, 0),
    /**
     * Mbar measurement unit.
     */
    MBAR(SensorType.PRESSURE, 33.8639, 0),
    /**
     * Pct measurement unit.
     */
    PCT(SensorType.HUMIDITY, 100, 0);

    private final SensorType type;
    private final double cf1; //conversion factor
    private final double cf2; // conversion factor

    MeasurementUnit(SensorType type, double cf1, double cf2) {
        this.type = type;
        this.cf1 = cf1;
        this.cf2 = cf2;
    }

    /**
     * .Used to calculate the reading from the sensor into a specific
     *
     * @param reading the senosr's reading
     * @return the double
     */
    public double get(int reading) {
        return (cf1 * reading + cf2) / 100.00;
    }

    /**
     * Used to get a list of measurement units of a specific sensor type.
     *
     * @param type type of sensor
     * @return list of measurement units
     */
    public static List<MeasurementUnit> valueOf(SensorType type) {
        List<MeasurementUnit> list = new ArrayList<>();
        for (MeasurementUnit unit : values()) {
            if (unit.type.equals(type)) {
                list.add(unit);
            }
        }
        return list;
    }
}
