package trainsim.objects;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;

import org.graphstream.ui.swing_viewer.DefaultView;
import org.graphstream.ui.swing_viewer.SwingViewer;

import org.graphstream.ui.view.Viewer;
import sun.misc.Signal;
import trainsim.config.RailwayConfig;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Railway extends JPanel implements Runnable {

    public Graph network;
    private final RailwayConfig config;

    public List<Stop> stops;

    public List<Station> stations;
    public List<SignalBox> signallingBoxes;
    //private List<Track> tracks;



    public Railway(RailwayConfig config) {
        this.config = config;
        init();

    }


    @Override
    public void run() {

    }


    private void init() {
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        this.network = new MultiGraph("embedded");
        network.setAttribute("ui.stylesheet", "url('" + this.getNetworkCSS() + "')");
        System.setProperty("org.graphstream.ui", "swing");
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        SwingViewer viewer = new SwingViewer(network, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);

        DefaultView view = (DefaultView) viewer.addDefaultView(false);
        view.setPreferredSize(new Dimension(800, 800));
        viewer.disableAutoLayout();
        setupGraph();
    }

    public DefaultView getView(){
        SwingViewer viewer = new SwingViewer(network, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.disableAutoLayout();
        DefaultView view = (DefaultView) viewer.addDefaultView(false);
        view.setPreferredSize(new Dimension(800, 800));
        return view;

    }


    private void setupGraph(){
        String networkFile = getNetworkDGS();
        FileSource fileSource = null;
        try{
            fileSource = FileSourceFactory.sourceFor(networkFile);
            fileSource.addSink(network);
            fileSource.readAll(networkFile);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Invalid train network provided. Please ensure a valid .dgs file has been provided.");
        }finally{
            if(fileSource != null) {
                fileSource.removeSink(network);
                createComponents();
            }
        }
    }



    private void createComponents() {
        this.stops = new ArrayList<>();
        //this.tracks = new ArrayList<>();


        for(int i = 0; i < network.getNodeCount(); i++){
            createStop(network.getNode(i));
        }

        for(int i = 0; i < network.getEdgeCount(); i++){
       //     createTrack(network.getEdge(i));
        }
    }

    private void createTrack(Edge edge){
//        try{
//            Track track = new Track(this, edge);
//            this.tracks.add(track);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
    }

    public List<Station> getStations(){
        return stops.stream().filter(stop -> stop instanceof Station)
                .map(stop -> (Station) stop)
                .collect(Collectors.toList());
    }

    public List<SignalBox> getSignallingBoxes(){
        return stops.stream().filter(stop -> stop instanceof SignalBox)
                .map(stop -> (SignalBox) stop)
                .collect(Collectors.toList());
    }

    public Optional<Stop> getStop(String id){
        List<Stop> matching = stops.stream()
                .filter(stop -> stop.getID().equals(id)).collect(Collectors.toList());

        if(matching.isEmpty()) return Optional.empty();
        return Optional.of(matching.get(0));
    }

    public Optional<Stop> getStop(Node node){
        List<Stop> matching = stops.stream()
                .filter(stop -> stop.getSimNode().node == node).collect(Collectors.toList());

        if(matching.isEmpty()) return Optional.empty();
        return Optional.of(matching.get(0));
    }

    private void createStop(Node node){
        String id = node.getId();
        Stop stop;
        if(id.contains("SB")){
            stop = new SignalBox(node);
        }else{
            stop = new Station(node);
        }
        this.stops.add(stop);

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
