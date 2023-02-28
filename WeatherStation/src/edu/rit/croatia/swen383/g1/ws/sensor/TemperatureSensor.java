package edu.rit.croatia.swen383.g1.ws.sensor;

/**
 * Class for a (simulated) sensor of the temperature. We assume the "real"
 * sensor returns a number in the range 0 .. 65535 which is calibrated to
 * be a Kelvin temperature to the nearest 100th of a degree. That is:
 * <p>
 * 0 = 0 degrees Kelvin = -273.15 degrees Celsius
 * 27315 = 273.15 degrees Kelvin =   0.00 degrees Celsius
 * 29315 = 293.15 degrees Kelvin =  20.00 degrees Celsius
 * 65535 = 655.35 degrees Kelvin = 382.20 degrees Celsius
 *
 * @author Michael J. Lutz
 * @author Kristina Marasovic
 * @author: Michel Brassard
 * @author: Luka Kocovic
 * @author: Bruno Leka
 * @author: Dominik Volic
 * @author: Mislav Culjak
 * @author: Tarik Ceco
 */
import java.util.Random;

/**
 * This class simulates a temperature sensor that reads temperature values within a specified range.
 * It generates a random temperature change, and updates the current temperature accordingly.
 * The current temperature will never exceed the maximum temperature or go below the minimum temperature.
 */
public class TemperatureSensor implements Sensor{
    /**
     * The minimum temperature that can be read by the sensor.
     */
    private static final int MIN_TEMPERATURE = 23315;

    /**
     * The maximum temperature that can be read by the sensor.
     */
    private static final int MAX_TEMPERATURE = 38315;

    /**
     * The default temperature when the sensor is initialized.
     */
    private static final int DEFAULT_TEMPERATURE = 29315;

    /**
     * The minimum temperature change that can be generated.
     */
    private static final int MIN_CHANGE = 100;

    /**
     * The maximum temperature change that can be generated.
     */
    private static final int MAX_CHANGE = 200;

    /**
     * The probability that the temperature change will reverse direction (i.e., go from increasing to decreasing).
     */
    private static final double CUTOFF = 0.8;

    /**
     * The current temperature as read by the sensor.
     */
    private int currentTemperature;

    /**
     * A flag indicating whether the temperature is currently increasing or decreasing.
     */
    private boolean increasing;

    /**
     * A random number generator used to generate temperature changes.
     */
    private Random random;

    /**
     * Constructs a new TemperatureSensor with default temperature and random number generator.
     * The temperature is set to the default temperature, and the initial direction of temperature change is set to increasing.
     */
    public TemperatureSensor() {
        currentTemperature = DEFAULT_TEMPERATURE;
        random = new Random();
        increasing = true;
    }

    /**
     * Reads the current temperature from the sensor.
     * This method generates a random temperature change, updates the current temperature, and returns the updated value.
     * @return the current temperature as read by the sensor
     */
    public int read() {
        int temperatureChange = random.nextInt(MAX_CHANGE - MIN_CHANGE) + MIN_CHANGE;
        if (random.nextDouble() > CUTOFF) {
            increasing = !increasing;
        }

        currentTemperature = currentTemperature + temperatureChange * (increasing ? 1 : -1);

        if (currentTemperature >= MAX_TEMPERATURE) {
            currentTemperature = MAX_TEMPERATURE;
            increasing = false;
        } else if (currentTemperature <= MIN_TEMPERATURE) {
            currentTemperature = MIN_TEMPERATURE;
            increasing = true;
        }

        return currentTemperature;
    }
}
