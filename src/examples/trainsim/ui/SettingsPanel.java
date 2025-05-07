package trainsim.ui;

import org.eclipse.collections.api.set.SetIterable;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {

    private JButton start;

    public SettingsPanel(){
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.start = new JButton("Start");
        this.add(start);
        this.add(new JLabel("Simulation Controls"));
        this.add(new JLabel("Additional Options"));
        setBackground(Color.RED);
    }



}
