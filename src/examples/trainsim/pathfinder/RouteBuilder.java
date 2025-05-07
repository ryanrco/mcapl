package trainsim.pathfinder;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import trainsim.objects.Station;
import trainsim.objects.Stop;
import trainsim.objects.Track;

import java.util.*;
import java.util.stream.Collectors;

import static trainsim.TrainSim.railway;

public class RouteBuilder {

    private Stop src;
    private Stop trg;
    private List<Stop> shortest;
    private List<Track> joiningTracks;

    public RouteBuilder(Stop src, Stop trg){
        this.src = src;
        this.trg = trg;
    }

    public RouteBuilder setSrc(Station src) {
        this.src = src;
        return this;
    }

    public RouteBuilder setTarget(Station trg) {
        this.trg = trg;
        return this;
    }


    public boolean calculateBestRoute(){
        if(src == null || trg == null) return false;

        System.out.println("Here");
        Node from = src.getSimNode().node;
        Node to = trg.getSimNode().node;

        Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, "congested", null);
        dijkstra.init(railway.network);
        dijkstra.setSource(from);
        dijkstra.compute();
        Path result = dijkstra.getPath(to);
        if(result == null || result.empty()) return false;
        List<Node> path = new ArrayList<>(result.getNodeSet());
        List<Edge> edges = new ArrayList<>(result.getEdgeSet());
        path.remove(src.getSimNode().node);

        this.shortest = path.stream()
                .map(railway::getStop)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        this.joiningTracks = edges.stream()
                .map(railway::getTrack)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        return true;
    }

    public List<Stop> getStops() throws Exception {
        if(!calculateBestRoute()){
            throw new Exception("Could not find a valid route!");
        }
        return shortest;
    }

    public List<Track> getTracks() throws Exception {
        if(!calculateBestRoute()){
            throw new Exception("Could not find a valid route!");
        }
        return joiningTracks;
    }
}