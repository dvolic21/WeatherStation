package edu.rit.croatia.swen383.g1.ws.observer;
import edu.rit.croatia.swen383.g1.ws.util.MeasurementUnit;

import java.util.EnumMap;
/**
 This is an interface called Observer. It defines the behavior of any class that implements it.
 The interface requires that all implementing classes have a update(EnumMap<MeasurementUnit, Double>) method.
 * @author: Michel Brassard
 * @author: Luka Kocovic
 * @author: Bruno Leka
 * @author: Dominik Volic
 * @author: Mislav Culjak
 * @author: Tarik Ceco
*/
public interface Observer {
    /**
     The update method is a required method that all implementing classes must have.
     @return void.
    */
    void update();
}
