package edu.rit.croatia.swen383.g1.ws.sensor;

import edu.rit.marasovic.swen383.thirdparty.sensor.HumidityReader;

/**
 * Adapter class that uses the HumidityReader library to display humidity data
 * */
public class HumiditySensor implements Sensor {
    private HumidityReader humidityReader;

    public HumiditySensor() {
        humidityReader = new HumidityReader();
    }
    @Override
    public int read() {
        return humidityReader.get();
    }
}
