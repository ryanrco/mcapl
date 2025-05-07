package trainsim.ui;

import org.json.simple.ItemList;
import trainsim.objects.Track;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.function.Consumer;

import static trainsim.TrainSim.railway;
import static trainsim.ui.TrainSimUI.SELECTED_TRAIN;

public class MetricsPanel extends TrainSimPanel {


    private final JLabel clickedId;
    private final JLabel route;

    public boolean viewingLidarReadings;
    public boolean viewingCurrentRoute;

    public MetricsPanel(TrainSimUI ui) {
        super(ui);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(300, 50);

        this.clickedId = new JLabel("Currently Viewing: N/A");
        this.route = new JLabel("Route: N/A");
        this.add(clickedId);
        this.add(route);
        this.add(Box.createVerticalStrut(10));


        loadToggles();

    }

    @Override
    public void update() {
        if (SELECTED_TRAIN == null) return;
        this.clickedId.setText("Currently Viewing: " + SELECTED_TRAIN.getName());
        this.route.setText("Current Route: " + SELECTED_TRAIN.getRoute().toString());

        if(viewingCurrentRoute){
            SELECTED_TRAIN.getRoute().highlightTracks();
        }


    }


    private void loadToggles() {
        createCheckBox("View current route", selected -> {
            railway.tracks.forEach(Track::resetStyle);
            viewingCurrentRoute = selected;


        });
        createCheckBox("View LiDAR Readings", selected -> viewingLidarReadings = selected);

    }

    private void createCheckBox(String label, Consumer<Boolean> setter) {
        JCheckBox cb = new JCheckBox(label);
        cb.addItemListener(e -> setter.accept(e.getStateChange() == ItemEvent.SELECTED));
        add(cb);
    }

}


