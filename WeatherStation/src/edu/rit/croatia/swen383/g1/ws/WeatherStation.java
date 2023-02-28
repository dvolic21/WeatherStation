package edu.rit.croatia.swen383.g1.ws;
import edu.rit.croatia.swen383.g1.ws.factory.SensorFactory;
import edu.rit.croatia.swen383.g1.ws.observer.Subject;
import edu.rit.croatia.swen383.g1.ws.sensor.PressureSensor;
import edu.rit.croatia.swen383.g1.ws.sensor.Sensor;
import edu.rit.croatia.swen383.g1.ws.sensor.TemperatureSensor;
import edu.rit.croatia.swen383.g1.ws.util.MeasurementUnit;
import edu.rit.croatia.swen383.g1.ws.util.SensorType;

import java.util.EnumMap;

/**
 * Class for a simple computer based weather station that reports the current
 * temperature (in Celsius) every second. The station is attached to a sensor
 * that reports the temperature as a 16-bit number (0 to 65535) representing the
 * Kelvin temperature to the nearest 1/100th of a degree.
 * <p>
 * This class is implements Runnable so that it can be embedded in a Thread
 * which runs the periodic sensing.
 *
 * @author Michael J. Lutz
 * @author Kristina Marasovic

 * @author: Michel Brassard
 * @author: Luka Kocovic
 * @author: Bruno Leka
 * @author: Dominik Volic
 * @author: Mislav Culjak
 * @author: Tarik Ceco
 * @version 1
 */
public class WeatherStation extends Subject implements Runnable {
    private final long PERIOD = 1000;
    private EnumMap<MeasurementUnit, Double> readingMap = new EnumMap<>(MeasurementUnit.class);
    private EnumMap<SensorType, Sensor> sensorMap = new EnumMap<>(SensorType.class);
    /**
     * Constructor for WeatherStation.
     * Initializes the temperature sensor and the gui.
     */
    public WeatherStation() {
        for (SensorType type : SensorType.values()) {
            sensorMap.put(type, SensorFactory.get(type));
        }
    }
  
    private void getSensorReadings(){
        int reading;
        Sensor sensor;
        for (SensorType type : SensorType.values()) {
            sensor = sensorMap.get(type);
            reading = sensor.read();
            for (MeasurementUnit unit : MeasurementUnit.valueOf(type) ) {
                readingMap.put(unit, unit.get(reading));
            }
        }

    }
    /* 
     * The getReading method
    */
    public double getReading(MeasurementUnit unit){
        return readingMap.get(unit);
    }


    /**
     * The run method continuously updates the temperature readings and updates the UI.
     */
    public void run() {
        while (true) {

            getSensorReadings();
            notifyObservers();

            try {
                Thread.sleep(PERIOD);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
