package trainsim.objects;

import org.graphstream.graph.Node;

public class Station {

    protected final Node node;

    public Station(Node node){
        this.node = node;
    }

    public String getID(){
        return this.node.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node){
            Node node = (Node) obj;
            return this.node == node;
        }
        return false;
    }
}
