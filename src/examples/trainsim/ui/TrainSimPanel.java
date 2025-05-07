package trainsim.ui;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public abstract class TrainSimPanel extends JPanel {


    public TrainSimPanel(TrainSimUI ui){
        this.setBorder(getFormattedBorder());
        ui.panels.add(this);
    }

    private CompoundBorder getFormattedBorder(){
        return BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 1), BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public abstract void update();
}
