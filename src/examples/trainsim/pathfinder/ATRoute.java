package trainsim.pathfinder;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import trainsim.objects.Stop;
import trainsim.objects.node.SimNode;

import java.util.Collection;
import java.util.Optional;

import static trainsim.TrainSimUI.railway;

public class ATRoute {

    public SimNode source;
    public SimNode target;

    private Collection<Node> shortest;
    private int reroutes = 0;


    public ATRoute(SimNode source, SimNode target){
        this.source = source;
        this.target = target;
        if(source == null || target == null){
            return;
        }
        calculateBestRoute();
    }

    private boolean calculateBestRoute() {
        Node sourceNode = this.source.node;
        Node targetNode = this.target.node;

        Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, "weight", null);
        dijkstra.init(railway.network);
        dijkstra.setSource(sourceNode);
        dijkstra.compute();

        Path result = dijkstra.getPath(targetNode);
        if (result == null || result.empty()) {
            return false;
        }

        if(!result.equals(shortest)){
            reroutes += 1;
        }

        this.shortest = result.getNodeSet();
        shortest.remove(sourceNode);
        return true;
    }

    public Stop getNextStop(){
        Node nextNode = shortest.iterator().next();
        Optional<Stop> nextStop = railway.getStop(nextNode);
        return nextStop.orElse(null);
    }


    public void setSource(SimNode source) throws Exception {
        this.source = source;
        if(!calculateBestRoute()){
            throw new Exception("An invalid source has been set!");
        }
        calculateBestRoute();
    }

    public SimNode getSource() {
        return source;
    }

    public void setTarget(SimNode target) throws Exception {
        this.target = target;
        if(!calculateBestRoute()){
            throw new Exception("An invalid target has been set!");
        }
        calculateBestRoute();
    }

    public SimNode getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "ATRoute{" +
                "source=" + source +
                ", target=" + target +
                ", shortest=" + shortest +
                ", reroutes=" + reroutes +
                '}';
    }
}