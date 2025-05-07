package trainsim.objects.node;

import org.graphstream.graph.Node;
import trainsim.objects.AutonomousTrain;
import trainsim.objects.Station;
import trainsim.objects.Stop;
import trainsim.pathfinder.ATRoute;

import java.util.Optional;

import static trainsim.TrainSim.railway;


public class TrainNode extends SimNode {

    private double distanceTravelled;
    private double totalDistance = 0;
    private double angle = 0;
    private double startingPosition[];

    private long lastUpdatedTime = System.currentTimeMillis();

    private final AutonomousTrain train;

    public boolean shouldProgressRoute = false;
    public boolean progressedRoute = true;

    public TrainNode(AutonomousTrain train, Node node) {
        super(node);
        this.train = train;
        this.setPosition(new double[]{0, 0});

    }

    public boolean step(AutonomousTrain train) {
        Stop source = train.getRoute().getCurrentStation();
        Optional<Stop> nextOpt = train.getRoute().getNextPath();
        if(nextOpt.isEmpty()) return true;
        Stop next = nextOpt.get();
        double x1 = source.getPosition()[0], x2 = next.getPosition()[0];
        double y1 = source.getPosition()[1], y2 = next.getPosition()[1];
        if (totalDistance == 0) {
            totalDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }

        long currentTime = System.currentTimeMillis();
        double elapsedSeconds = (currentTime - lastUpdatedTime) / 1000.00;

        lastUpdatedTime = currentTime;

        if (elapsedSeconds <= 0) return false;

        double currentSpeed = train.getCurrentSpeed();
        double speedFactor = currentSpeed / 3600.0;
        double distanceToMove = (speedFactor / 3600) * 1000;


        distanceTravelled += distanceToMove;

        setAngle(x1, y1, x2, y2);

        if (distanceTravelled >= totalDistance) {
            distanceTravelled = 0;
            totalDistance = 0;
            train.getRoute().progressRoute();
            System.out.println(train.getRoute().getCurrentStation().getPosition()[0] + " " + train.getRoute().getCurrentStation().getPosition()[1]);

            this.shouldProgressRoute = false;
            return false;
        }

        double progress = distanceTravelled / totalDistance;
        double x = x1 + progress * (x2 - x1);
        double y = y1 + progress * (y2 - y1);
        // System.out.println("travelled:" + distanceTravelled + " total " + totalDistance);
        setPosition(new double[]{x, y});
        setAngle(x1, y1, x2, y2);
        return false;
    }

    /**
     * Calculates the current angle between 2 points (radians)
     * Credit: https://stackoverflow.com/questions/9970281/java-calculating-the-angle-between-two-points-in-degrees
     *
     * @param x1 from x-pos
     * @param y1 from y-pos
     * @param x2 to x-pos
     * @param y2 to y-pos
     */
    public void setAngle(double x1, double y1, double x2, double y2) {
        angle = Math.atan2(y2 - y1, x2 - x1);
    }

    /**
     * Converts the radians calculation of {@code setAngle} to degrees
     *
     * @return Current angle between two points in degrees
     */
    public double getAngle() {
        double degrees = Math.toDegrees(angle);
        if (degrees < 0) {
            degrees += 360;
        }
        return degrees;
    }


    public void setPosition(double[] pos) {
        node.setAttribute("x", pos[0]);
        node.setAttribute("y", pos[1]);
    }
}
