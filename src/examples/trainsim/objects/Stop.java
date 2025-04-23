package trainsim.objects;

import org.graphstream.graph.Node;
import trainsim.objects.node.SimNode;
import trainsim.objects.sensors.LIDARDetectable;

public abstract class Stop implements LIDARDetectable {

    private final SimNode node;

    public Stop(Node node){
        this.node = new SimNode(node);
    }

    public SimNode getSimNode() {
        return node;
    }

    @Override
    public String getID() {
        return node.getID();
    }

    @Override
    public double[] getPosition() {
        return new double[]{node.getX(), node.getY()};
    }
}
