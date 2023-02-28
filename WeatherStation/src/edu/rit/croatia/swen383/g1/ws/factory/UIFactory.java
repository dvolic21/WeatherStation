package edu.rit.croatia.swen383.g1.ws.factory;

import edu.rit.croatia.swen383.g1.ws.WeatherStation;
import edu.rit.croatia.swen383.g1.ws.observer.Observer;
import edu.rit.croatia.swen383.g1.ws.ui.SwingUI;
import edu.rit.croatia.swen383.g1.ws.ui.TextUI;
import edu.rit.croatia.swen383.g1.ws.util.UIType;

/**
 * @author: Michel Brassard
 * @author: Luka Kocovic
 * @author: Bruno Leka
 * @author: Dominik Volic
 * @author: Mislav Culjak
 * @author: Tarik Ceco
 * @version 1
 */
public class UIFactory {

    public static Observer get(UIType type, WeatherStation station){
        switch (type) {
            case TEXTUI:
                return new TextUI(station);
            case SWINGUI:
                return new SwingUI(station);
        }
        return null;
    }

}
