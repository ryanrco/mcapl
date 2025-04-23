package trainsim.objects;

import org.graphstream.graph.Node;
import trainsim.pathfinder.TrainRoute;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static trainsim.TrainSimUI.frame;
import static trainsim.TrainSimUI.railway;

public class TrainNode extends SimNode {

    int currentStep = 0;
    int totalSteps = 20;
    boolean moving = true;

    private final TrainRoute trainRoute;

    public TrainNode(TrainRoute trainRoute, Node node) {
        super(node);
        this.trainRoute = trainRoute;

    }


    public void step() {
        if (!moving) return;
        if (currentStep > totalSteps) {
            moving = false;
            return;
        }

        // interpolate and set position
        double t = currentStep / (double) totalSteps;

        Node source = trainRoute.source.getNode().node;
        Node target = trainRoute.target.getNode().node;;

        double x1 = source.getNumber("x"), x2 = target.getNumber("x");
        double y1 = source.getNumber("y"), y2 = target.getNumber("y");
        double x = x1 + t * (x2 - x1);
        double y = y1 + t * (y2 - y1);
        setPosition(new double[]{x, y});
        currentStep++;
    }



    private void setPosition(double[] pos){
        node.setAttribute("x", pos[0]);
        node.setAttribute("y", pos[1]);
    }

}
