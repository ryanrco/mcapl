package trainsim;

import trainsim.config.RailwayConfig;

import javax.swing.*;
import java.awt.*;

public class Railway extends JPanel implements Runnable{

    public Railway(String control) {
        init(control);
    }

    private void init(String control) {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(500, 500));
        setDoubleBuffered(true);

//        if (control.equals("agent")) {
//            ail_control = true;
//        }
//
//        if (ail_control) {
//            System.err.println("Motorway Sim waiting Socket Connection");
//            socketserver = new AILSocketServer();
//            System.err.println("Got Socket Connection");
//        }
    }


    @Override
    public void run() {

    }



    public void configure(RailwayConfig config) {

    }
}
