package trainsim.objects;

import io.grpc.netty.shaded.io.netty.util.Signal;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;

import org.graphstream.ui.swing_viewer.DefaultView;
import org.graphstream.ui.swing_viewer.SwingViewer;

import org.graphstream.ui.view.Viewer;
import trainsim.config.RailwayConfig;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static trainsim.TrainSim.simLogger;

public class Railway extends JPanel implements Runnable {

    public Graph network;
    private final RailwayConfig config;

    public List<Stop> stops;
    public List<Track> tracks;

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

        viewer.disableAutoLayout();
        setupGraph();
    }

    public DefaultView getView() {
        SwingViewer viewer = new SwingViewer(network, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.disableAutoLayout();
        DefaultView view = (DefaultView) viewer.addDefaultView(false);
        view.setPreferredSize(new Dimension(800, 800));
        return view;

    }


    private void setupGraph() {
        String networkFile = getNetworkDGS();
        FileSource fileSource = null;
        try {
            fileSource = FileSourceFactory.sourceFor(networkFile);
            fileSource.addSink(network);
            fileSource.readAll(networkFile);
        } catch (Exception e) {
            simLogger.log(Level.SEVERE, "Invalid rail graph has been provided. Exiting.");
            System.exit(1);

        } finally {
            if (fileSource != null) {
                fileSource.removeSink(network);
                createComponents();
            }
        }
    }


    private void createComponents()  {
        this.stops = new ArrayList<>();
        this.tracks = new ArrayList<>();
        for (int i = 0; i < network.getNodeCount(); i++) {
            Node node = network.getNode(i);
            try {
                createStop(node);
            }catch (Exception e){
                simLogger.log(Level.SEVERE, e.getMessage() +
                        "\n This could cause unforeseen behaviour in the network.");
            }
        }
        for (int i = 0; i < network.getEdgeCount(); i++) {
            Edge edge = network.getEdge(i);
            try {
                createTrack(edge);
            }catch (Exception e){
                e.printStackTrace();
                simLogger.log(Level.SEVERE, e.getMessage() +
                        "\n This could cause unforeseen behaviour in the network.");
            }

        }
    }

    public Stop createStop(Node node) throws Exception {
        String type = ((String) node.getAttribute("type"));
        Stop createdStop = null;
        switch (type) {
            case "station":
                createdStop = new Station(node);
                break;
            case "signalling_junction":
                createdStop = new SignalBox(node);
                break;
            default:
                break;
        }
        if (createdStop == null) {
            throw new Exception("Attempted to create an invalid stop at ID " + node.getId());
        }
        this.stops.add(createdStop);
        return createdStop;
    }

    public Track createTrack(Edge edge) throws Exception{
        Track track = new Track(this, edge);
        this.tracks.add(track);
        return track;
    }





    public Optional<Stop> getStop(String id) {
        List<Stop> matching = stops.stream()
                .filter(stop -> stop.getID().equals(id)).collect(Collectors.toList());

        if (matching.isEmpty()) return Optional.empty();
        return Optional.of(matching.get(0));
    }

    public Optional<Stop> getStop(Node node) {
        List<Stop> matching = stops.stream()
                .filter(stop -> stop.getSimNode().node == node).collect(Collectors.toList());

        if (matching.isEmpty()) return Optional.empty();
        return Optional.of(matching.get(0));
    }


    public Optional<Station> getStation(String id) {
        return stops.stream()
                .filter(stop -> stop instanceof Station && stop.getID().equals(id))
                .map(stop -> (Station) stop)
                .findFirst();
    }

    public Optional<Station> getStation(Node node) {
        return stops.stream()
                .filter(stop -> stop instanceof Station && stop.getSimNode().node == node)
                .map(stop -> (Station) stop)
                .findFirst();
    }

    public Optional<SignalBox> getSignalBox(String id) {
        return stops.stream()
                .filter(stop -> stop instanceof SignalBox && stop.getID().equals(id))
                .map(stop -> (SignalBox) stop)
                .findFirst();
    }

    public Optional<SignalBox> getSignalBox(Node node) {
        return stops.stream()
                .filter(stop -> stop instanceof SignalBox && stop.getSimNode().node == node)
                .map(stop -> (SignalBox) stop)
                .findFirst();
    }


    public Optional<Station> getRandomStation() {
        List<Station> stationList = new ArrayList<>();
        for (Stop stop : stops) {
            if (stop instanceof Station) {
                stationList.add((Station) stop);
            }
        }

        if (stationList.isEmpty()) {
            return Optional.empty();
        }

        Random rand = new Random();
        return Optional.of(stationList.get(rand.nextInt(stationList.size())));
    }


    public Optional<Track> getTrack(String id) {
        List<Track> matching = tracks.stream()
                .filter(stop -> stop.getEdge().getId().equals(id)).collect(Collectors.toList());

        if (matching.isEmpty()) return Optional.empty();
        return Optional.of(matching.get(0));
    }

    public Optional<Track> getTrack(Edge edge) {
        List<Track> matching = tracks.stream()
                .filter(track -> track.getEdge() == edge).collect(Collectors.toList());

        if (matching.isEmpty()) return Optional.empty();
        return Optional.of(matching.get(0));
    }

    public Optional<Track> getTrackBetween(Node from, Node to){
        Edge edge = from.getEdgeBetween(to);
        if(edge != null){
            return getTrack(edge);
        }
        return Optional.empty();
    }




    public String getNetworkDGS() {
        return config.getProperty("train_network");
    }

    public String getNetworkCSS() {
        return config.getProperty("train_network_style");
    }

    public void configure() {

    }
}
