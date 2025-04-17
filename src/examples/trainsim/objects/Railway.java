package trainsim.objects;

import ail.semantics.AILAgent;
import ail.util.AILSocketServer;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;

import org.graphstream.ui.swing_viewer.DefaultView;
import org.graphstream.ui.swing_viewer.SwingViewer;

import org.graphstream.ui.view.Viewer;
import trainsim.TrainSim;
import trainsim.config.RailwayConfig;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Railway extends JPanel implements Runnable{

    protected Graph network;
    private final RailwayConfig config;

    private List<Train> trains;
    private List<Station> stations;
    private List<Track> tracks;

    protected AILSocketServer socketServer;


    public Railway(RailwayConfig config, TrainSim sim) {
        this.config = config;
        init(sim);

    }


    @Override
    public void run() {

    }


    private void init(TrainSim sim) {
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        this.network = new MultiGraph("embedded");
        network.setAttribute("ui.stylesheet", "url('" + this.getNetworkCSS() + "')");
        System.setProperty("org.graphstream.ui", "swing");
        SwingViewer viewer = new SwingViewer(network, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.disableAutoLayout();
        DefaultView view = (DefaultView) viewer.addDefaultView(false);
        view.setPreferredSize(new Dimension(400, 400));
        sim.add(view);

        setupGraph();
    }


    private void setupGraph(){
        String networkFile = getNetworkDGS();
        FileSource fileSource = null;
        try{
            fileSource = FileSourceFactory.sourceFor(networkFile);
            fileSource.addSink(network);
            fileSource.readAll(networkFile);
        }catch (Exception e){
            throw new RuntimeException("Invalid train network provided. Please ensure a valid .dgs file has been provided.");
        }finally{
            if(fileSource != null) {
                fileSource.removeSink(network);
                createComponents();
            }
        }
    }



    private void createComponents() {
        this.stations = new ArrayList<>();
        this.tracks = new ArrayList<>();

        for(int i = 0; i < network.getNodeCount(); i++){
            createStation(network.getNode(i));
        }

        for(int i = 0; i < network.getEdgeCount(); i++){
            createTrack(network.getEdge(i));
        }
    }

    public void createTrain(AILAgent ailAgent){
        this.trains.add(new Train(this, ailAgent));
    }

    private void createTrack(Edge edge){
        try{
            Track track = new Track(this, edge);
            this.tracks.add(track);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    private void createStation(Node node){
        this.stations.add(new Station(node));
    }


    public Optional<Station> getStation(Node node){
        for(Station station: stations){
            if(station.equals(node)){
                return Optional.of(station);
            }
        }
        return Optional.empty();
    }

    public Optional<Station> getStation(String ID){
        for(Station station: stations){
            if(station.getID().equals(ID)){
                return Optional.of(station);
            }
        }
        return Optional.empty();
    }

    public String getNetworkDGS(){
        return config.getProperty("train_network");
    }

    public String getNetworkCSS(){
        return config.getProperty("train_network_style");
    }


    public void configure() {

    }
}
