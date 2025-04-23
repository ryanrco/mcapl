package trainsim;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.util.AILConfig;
import ajpf.MCAPLcontroller;
import trainsim.config.RailwayConfig;
import trainsim.objects.Railway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrainSimUI extends JPanel implements ActionListener, PropertyChangeListener, WindowListener {

    // Not sure about setting this to one.
    private static final long serialVersionUID = 1;

    public static JFrame frame;
    public static ScheduledExecutorService trainAnimator = Executors.newScheduledThreadPool(25);

    private static final String path = "/src/examples/trainsim/";
    private static final String ailConfig = "agents/railway.ail";

    public static Railway railway;
    private static RailwayConfig config;

    public TrainSimUI(GridBagLayout layout){
        setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        add(railway.getView());
        createControlPanel(c);
    }

    private static void initRailway(){
        railway = new Railway(config);
        railway.configure();
    }

    private void createControlPanel(GridBagConstraints c){
        JPanel controls = new JPanel();
        controls.setBorder(BorderFactory.createTitledBorder("Controls"));
        controls.setLayout(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 1;
        add(controls, c);

        JLabel controlPanel = new JLabel("Control Panel");
        controls.add(controlPanel);

    }

    private static void createAndShowGUI(){
        frame = new JFrame("TrainSim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TrainSimUI ui = new TrainSimUI(new GridBagLayout());
        frame.addWindowListener(ui);
        frame.setContentPane(ui);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){

        //Handle loading of config
        if(args != null && args.length > 0){
            configure(args[0]);
        }else{
            configure("/src/examples/trainsim/config/config_automatic.txt");
        }

        initRailway();

        AILConfig config = getAilConfig();
        AIL.configureLogging(config);

        MCAPLcontroller mcControl = new MCAPLcontroller(config, "");
        MAS mas = AIL.AILSetup(config, mcControl);
        RailwayEnvironment env = (RailwayEnvironment) mas.getEnv();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }}
        );

        // Lastly we construct a controller.
        mcControl.setMAS(mas);
        // Start the system.
        mcControl.begin();
        mas.cleanup();


    }


    public static AILConfig getAilConfig(){
        return new AILConfig(path + ailConfig);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    private static void configure(String fileName){
        config = new RailwayConfig(fileName);
    }
}
