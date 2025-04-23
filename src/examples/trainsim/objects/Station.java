package trainsim.objects;

import ail.syntax.Predicate;
import org.graphstream.graph.Node;
import trainsim.objects.node.SimNode;

import java.util.List;

public class Station extends Stop {

    public Station(Node node){
        super(node);
    }



    @Override
    public String getType() {
        return "station";
    }
}
