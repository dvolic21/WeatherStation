package edu.rit.croatia.swen383.g1.ws;
import edu.rit.croatia.swen383.g1.ws.factory.UIFactory;
import edu.rit.croatia.swen383.g1.ws.util.UIType;

import java.util.Scanner;

/**
 * WeatherStationRunner class to run the application.
 * @author: Michel Brassard
 * @author: Luka Kocovic
 * @author: Bruno Leka
 * @author: Dominik Volic
 * @author: Mislav Culjak
 * @author: Tarik Ceco
 */

public class WeatherStationRunner {
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        for (UIType type: UIType.values()) {
            UIFactory.get(type, ws);
        }
        Thread thread = new Thread(ws);
        thread.start();
    }
}