package edu.rit.croatia.swen383.g1.ws.sensor;

/**
 This is an interface called Sensor. It defines the behavior of any class that implements it.
 The interface requires that all implementing classes have a read() method.
 @author Tarik Ceco
*/
public interface Sensor {
    /**
     The read method is a required method that all implementing classes must have.
     It returns an integer value.
     @return int value representing the sensor reading.
    */
    int read();
}