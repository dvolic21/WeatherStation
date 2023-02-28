package edu.rit.croatia.swen383.g1.ws.sensor;

/**
 * Class for a (simulated) barometer. We assume the "real" barometer returns an
 * atmospheric read, as an integer number, which is calibrated to be a pressure
 * measure to the nearest 100th of the inches of mercury (average read = 29.92
 * inHg):
 *
 * 2700 = 27.0 inHg
 * 3200 = 32.0 inHg
 *
 * NOTE: Outside the U.S. and Canada atmospheric read is given in millibars,
 * where average read = 1013.25 mbar. The conversion factor is 1 inch = 33.864
 * mbar.
 *
 * @author Michael J. Lutz, Kristina Marasovic <kristina.marasovic@rit.edu>
 *
 */
import java.util.Random;

public class PressureSensor implements Sensor {

    /** The minimum pressure value that the sensor can return. */
    private final int MIN = 2700;

    /** The maximum pressure value that the sensor can return. */
    private final int MAX = 3200;

    /** The default pressure value that the sensor will return if it is not increasing or decreasing.  */
    private final int DEFAULT = 2992;

    /** The current pressure value. */
    private int currentPressure;

    /** A flag to determine if the pressure is increasing or decreasing. */
    private boolean isIncreasing = true;

    /** A Random object to generate random numbers. */
    private final Random random = new Random();

    /** Constructs a PressureSensor object and sets the current pressure to the default value. */
    public PressureSensor() {
        currentPressure = DEFAULT;
    }

    /**
     * {@inheritDoc}
     *
     * Generates a random pressure value within the specified range and returns it.
     * The pressure value may either increase or decrease based on the value of the "isIncreasing" flag.
     */
    @Override
    public int read() {
        final double CUT_OFF = 0.75;
        final int MAX_DELTA = 20;
        int pressureChange;

        if (random.nextDouble() > CUT_OFF) {
            isIncreasing = !isIncreasing;
        }

        pressureChange = random.nextInt(MAX_DELTA);
        currentPressure = currentPressure + pressureChange * (isIncreasing ? 1 : -1);

        if (currentPressure >= MAX) {
            currentPressure = MAX;
            isIncreasing = false;
        } else if (currentPressure <= MIN) {
            currentPressure = MIN;
            isIncreasing = true;
        }

        return currentPressure;
    }
}