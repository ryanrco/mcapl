package trainsim.objects.node;

import org.graphstream.graph.Node;
import trainsim.objects.AutonomousTrain;
import trainsim.pathfinder.ATRoute;

public class TrainNode extends SimNode {

    int currentStep = 0;
    int totalSteps = 5000;

    private final ATRoute trainRoute;

    public TrainNode(ATRoute trainRoute, Node node) {
        super(node);
        this.trainRoute = trainRoute;
        this.setPosition(new double[]{0,0});

    }

    public void step(AutonomousTrain train) {
        if (currentStep > totalSteps) {
            currentStep = 0;
            return;
        }
        currentStep++;

        double t = currentStep / (double) totalSteps;
        Node source = trainRoute.getSource().node;
        Node target = trainRoute.getNextStop().getSimNode().node;


        double x1 = source.getNumber("x"), x2 = target.getNumber("x");
        double y1 = source.getNumber("y"), y2 = target.getNumber("y");
        double x = x1 + t * (x2 - x1);
        double y = y1 + t * (y2 - y1);

        setPosition(new double[]{x, y});

    }


    public void setPosition(double[] pos){
        node.setAttribute("x", pos[0]);
        node.setAttribute("y", pos[1]);
    }
}
