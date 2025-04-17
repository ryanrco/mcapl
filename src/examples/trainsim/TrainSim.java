package trainsim;

import ail.util.AILSocketServer;
import trainsim.config.RailwayConfig;
import trainsim.objects.Railway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainSim extends JFrame implements ActionListener {


    static final long serialVersionUID = 0;
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;

    private Railway railway;
    static RailwayConfig config;

    protected AILSocketServer socketServer;


    public TrainSim() {
        establishAILConnection();
        init();
    }


    private void init(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        railway = new Railway(config, this);
        railway.configure();
        add(railway, c);

        this.setPreferredSize(new Dimension(800, 800));
        this.pack();
        this.setVisible(true);
    }

    private void establishAILConnection(){
        System.err.println("TrainSim awaiting Socket Connection");
        socketServer = new AILSocketServer();
        System.err.println("Got Socket Connection");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            configure(args[0]);
        } else {
            configure("/src/examples/trainsim/config/config_automatic.txt");
        }

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame trainSim = new TrainSim();
                trainSim.setVisible(true);
            }
        });
    }



    private static void configure(String filename) {
        config = new RailwayConfig(filename);
    }
}
