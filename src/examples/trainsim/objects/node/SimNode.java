package trainsim.objects.node;

import org.graphstream.graph.Node;

public class SimNode {

    public final Node node;

    public SimNode(Node node) {
        this.node = node;
    }

    private double[] getPosition(){
        return new double[]{node.getNumber("x"),node.getNumber("y")};
    }


    public void setStyle(String style){
        node.setAttribute("ui.class", style);
    }



    public double getX(){
        return getPosition()[0];
    }

    public double getY(){
        return getPosition()[1];
    }

    public double calcDistanceTo(SimNode to){
        double dx = this.getX() - to.getX();
        double dy = this.getY() - to.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public String getID(){
        return node.getId();
    }

    @Override
    public String toString() {
        return "TrainSimNode{" +
                "x=" + getX() +
                ", y=" + getY() +
                '}';
    }
}
