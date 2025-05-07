package trainsim.ui;

import org.graphstream.ui.swing_viewer.DefaultView;
import trainsim.RailwayEnvironment;
import trainsim.objects.AutonomousTrain;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrainSimUI extends JPanel implements ActionListener, PropertyChangeListener, WindowListener {

    private JFrame frame;
    protected final List<TrainSimPanel> panels;

    public static AutonomousTrain SELECTED_TRAIN;

    private RailwayEnvironment railwayEnvironment;
    public TrainStatusPanel statusPanel;
    private MetricsPanel metricsPanel;
    private DefaultView visualiserPanel;
    private AgentLogPanel agentLogPanel;

    public TrainSimUI(DefaultView simVisual){
        this.panels = new ArrayList<>();
        init(simVisual);

    }

    private void init(DefaultView simVisual) {
        this.setLayout(new BorderLayout(10, 10)); // ← Make sure this panel has a layout

        this.visualiserPanel = simVisual;

        this.statusPanel = new TrainStatusPanel(this);
        this.metricsPanel = new MetricsPanel(this);
        this.agentLogPanel = new AgentLogPanel(this);


        this.add(setupLeftPanel(), BorderLayout.WEST);
        this.add(visualiserPanel, BorderLayout.CENTER);
        simVisual.setMouseManager(new TestMouseManager(metricsPanel));

        setupFrame();
    }
    private JPanel setupLeftPanel(){
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        statusPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        metricsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        agentLogPanel.setAlignmentX(Component.LEFT_ALIGNMENT);


        centerPanel.add(statusPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(metricsPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(agentLogPanel);



        return centerPanel;
    }



    private void setupFrame() {
        frame = new JFrame("TrainSim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        frame.setResizable(false);
        frame.addWindowListener(this);

        frame.setContentPane(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void update(){
        statusPanel.updateView();
        panels.forEach(TrainSimPanel::update);
    }

    public Optional<RailwayEnvironment> getRailwayEnvironment(){
        return railwayEnvironment != null ? Optional.of(railwayEnvironment) : Optional.empty();

    }

    public void setRailwayEnvironment(RailwayEnvironment railwayEnvironment) {
        this.railwayEnvironment = railwayEnvironment;
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
}
