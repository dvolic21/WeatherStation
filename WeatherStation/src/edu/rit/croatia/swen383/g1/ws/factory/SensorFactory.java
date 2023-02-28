package edu.rit.croatia.swen383.g1.ws.factory;

import edu.rit.croatia.swen383.g1.ws.sensor.PressureSensor;
import edu.rit.croatia.swen383.g1.ws.sensor.Sensor;
import edu.rit.croatia.swen383.g1.ws.sensor.TemperatureSensor;
import edu.rit.croatia.swen383.g1.ws.sensor.HumiditySensor;
import edu.rit.croatia.swen383.g1.ws.util.SensorType;

/**
 * @author: Michel Brassard
 * @author: Luka Kocovic
 * @author: Bruno Leka
 * @author: Dominik Volic
 * @author: Mislav Culjak
 * @author: Tarik Ceco
 * @version 1
 */
public class SensorFactory {
    public static Sensor get(SensorType type) {
        switch (type) {
            case PRESSURE:
                return new PressureSensor();
            case TEMPERATURE:
                return new TemperatureSensor();
            case HUMIDITY:
                return new HumiditySensor();
            default:
                return null;
        }
    }
}
