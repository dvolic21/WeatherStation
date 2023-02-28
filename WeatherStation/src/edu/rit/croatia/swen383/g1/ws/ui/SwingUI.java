package edu.rit.croatia.swen383.g1.ws.ui;

/**
 * Initial Author
 *      Michael J. Lutz
 *
 * Other Contributors
 *
 * Acknowledgements
 */

/**
 * Swing UI class used for displaying the information from the
 * associated weather station object.
 * This is an extension of JFrame, the outermost container in
 * a Swing application.
 * @author: Michel Brassard
 * @author: Luka Kocovic
 * @author: Bruno Leka
 * @author: Dominik Volic
 * @author: Mislav Culjak
 * @author: Tarik Ceco
 */

import edu.rit.croatia.swen383.g1.ws.util.MeasurementUnit;
import edu.rit.croatia.swen383.g1.ws.WeatherStation;
import edu.rit.croatia.swen383.g1.ws.observer.Observer;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.EnumMap;

public class SwingUI extends JFrame implements Observer {
    /** Map to store JLabels for each measurement unit. */
    private static final EnumMap<MeasurementUnit, JLabel> jLabelMap = new EnumMap<>(MeasurementUnit.class);

    /** Label font with SERIF, PLAIN, and font size 72. */
    private static final Font jLabelFont = new Font(Font.SERIF, Font.PLAIN, 72);

    private WeatherStation station;

    /** Constructor to initialize the GUI. */
    public SwingUI(WeatherStation station) {
        super("Weather Station - SwingUI");
        this.station = station;
        this.station.attach(this);
        setLayout(new GridLayout(1, 0));
        for (MeasurementUnit unit : MeasurementUnit.values()) {
            createJPanel(unit);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    /**
     * Creates a centered label with the given title.
     * 
     * @param title The title for the label
     * 
     * @return JLabel object with the given title and set to be centered
     */
    private JLabel createJLabel(String title) {
        JLabel label = new JLabel(title);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(jLabelFont);
        return label;
    }

    /**
     * 
     * Sets the value for a given measurement unit in the JLabel.
     * 
     * @param unit  The measurement unit.
     * 
     * @param value The measurement value to be set in the JLabel.
     */
    private void setJLabel(MeasurementUnit unit, double value) {
        jLabelMap.get(unit).setText(String.format("%.2f", value));
    }

    /**
     * 
     * Creates a JPanel for a given measurement unit.
     * 
     * @param unit The measurement unit for which the JPanel should be created.
     */
    private JPanel createJPanel(MeasurementUnit unit) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(createJLabel(unit.name()));
        JLabel label = createJLabel("");
        panel.add(label);
        jLabelMap.put(unit, label);
        add(panel);
        return panel;
    }

    /**
     * Method to update the readings displayed on the GUI.
     * 
     * @param reading The updated readings in the form of an EnumMap, where the keys
     *                * are the measurement units and the values are the
     *                corresponding * readings for that unit.
     */
    @Override
    public void update() {
        for (MeasurementUnit unit : MeasurementUnit.values()) {
            setJLabel(unit, station.getReading(unit));
        }
    }

}