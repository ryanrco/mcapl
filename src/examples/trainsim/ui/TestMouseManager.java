package trainsim.ui;

import org.graphstream.ui.swing_viewer.util.DefaultMouseManager;

import java.awt.event.MouseEvent;

public class TestMouseManager extends DefaultMouseManager {

    public MetricsPanel userInterface;

    public TestMouseManager(MetricsPanel ui){
        this.userInterface = ui;

    }

    @Override
    public void mouseReleased(MouseEvent event) {
        System.out.println(curElement);
        if(curElement == null) return;


        super.mouseReleased(event);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

    }
}
