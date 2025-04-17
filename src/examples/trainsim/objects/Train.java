package trainsim.objects;

import ail.semantics.AILAgent;
import org.graphstream.graph.Node;

public class Train  {

    private final Node train;
    private final AILAgent agent;

    private Station source;
    private Station target;


    public Train(Railway railway, AILAgent agent){
        this.train = railway.network.addNode("train");
        train.setAttribute("ui.class", "train");
        this.agent = agent;
    }

    private void move(int steps){
        double x1 = source.node.getNumber("x"), x2 = target.node.getNumber("x");
        double y1 = source.node.getNumber("y"), y2 = target.node.getNumber("y");

        for (int i = 0; i <= steps; i++) {
            double t = i / (double) steps;
            double x = x1 + t * (x2 - x1);
            double y = y1 + t * (y2 - y1);
            train.setAttribute("xy", x, y);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private double[] getPosition(){
        Object[] position = train.getAttribute("xy", Object[].class);
        Object xRaw = position[0];
        Object yRaw = position[1];
        double x = 0, y = 0;
        if(xRaw instanceof Double){
            x = (Double) xRaw;
        }

        if(yRaw instanceof Double){
            y = (Double) yRaw;
        }

        return new double[]{x,y};
    }

    public double getX(){
        return getPosition()[0];
    }

    public double getY(){
        return getPosition()[1];
    }


    public void setSource(Station source) {
        this.source = source;
    }

    public void setTarget(Station target) {
        this.target = target;
    }

    public AILAgent getAgent() {
        return agent;
    }
}
