package trainsim.objects;

import ail.semantics.AILAgent;
import ail.syntax.*;
import ail.util.AILexception;
import trainsim.objects.node.TrainNode;
import trainsim.objects.sensors.LIDARDetectable;
import trainsim.pathfinder.ATRoute;

import java.util.HashMap;
import java.util.List;

import static trainsim.TrainSim.railway;
import static trainsim.objects.sensors.SimpleGPS.GPS_FUNCTOR;


public class AutonomousTrain extends SmartVehicle {

    public enum TrainStatus {
        STOPPED,
        ACCELERATING,
        DECELERATING,
        MAINTAIN_SPEED;
    }

    private static final double MAX_BRAKING_DECELERATION = 0.5;

    public TrainNode node;
    private ATRoute route;

    private double acceleration = 0;
    public double currentSpeed = 0;
    private final int maxSpeed = 80;
    private double distanceUntilNextStop = Integer.MAX_VALUE;
    private double distanceUntilNextJunction = Integer.MAX_VALUE;

    public TrainStatus status = TrainStatus.STOPPED;


    public AutonomousTrain(AILAgent agent) {
        super(agent);
        initNode(agent);

    }


    private void initNode(AILAgent agent) {
        this.node = new TrainNode(this, railway.network.addNode(agent.getAgName()));
        node.setStyle("train");
    }

    @Override
    public HashMap<LIDARDetectable, Double> scanAndPerceive(double angle, List<? extends LIDARDetectable> detectableList) {
        return super.scanAndPerceive(angle, detectableList);
    }


    public Unifier executeAction(String agName, Action act) throws AILexception {
        if (act.getFunctor().equals("accelerate")) {
            this.status = TrainStatus.ACCELERATING;
            return super.executeAction(agName, act);
        }

        if (act.getFunctor().equals("calc_braking_distance")) {
            NumberTerm distance = (NumberTerm) act.getTerm(0);
            distanceUntilNextStop = distance.solve();
            Unifier U = new Unifier();
            U.unifies(act.getTerm(1), new NumberTermImpl(calculateBrakingDistance()));
            return U;
        }

        if (act.getFunctor().equals("stop_train")) {
            this.status = TrainStatus.STOPPED;
            return super.executeAction(agName, act);
        }

        if (act.getFunctor().equals("brake")) {
            this.status = TrainStatus.DECELERATING;
            return super.executeAction(agName, act);
        }

        if (act.getFunctor().equals("maintain_speed")) {
            this.status = TrainStatus.MAINTAIN_SPEED;


            return super.executeAction(agName, act);
        }

        if (act.getFunctor().equals("progress_route")) {
            return super.executeAction(agName, act);

        }

        return super.executeAction(agName, act);
    }

    public void moveTrain() {
        double accelerationFactor = 0;
        if (status == TrainStatus.ACCELERATING) {
            accelerationFactor = 0.05;
        } else if (status == TrainStatus.DECELERATING) {
            if (currentSpeed > 0.05) {
                double idealDeceleration = (currentSpeed * currentSpeed) / (2 * distanceUntilNextStop);
                accelerationFactor = -Math.min(0.05, idealDeceleration);
            } else {
                accelerationFactor = -0.025;
            }
        } else if (status == TrainStatus.STOPPED) {
            currentSpeed = 0;
            accelerationFactor = 0;
        } else {
            status = TrainStatus.MAINTAIN_SPEED;
        }

        currentSpeed += accelerationFactor;

        if (currentSpeed > maxSpeed) {
            currentSpeed = maxSpeed;
            this.status = TrainStatus.MAINTAIN_SPEED;
        }

        if (currentSpeed < 0) {
            currentSpeed = 0;
            this.status = TrainStatus.STOPPED;
        }

        if (currentSpeed > 0){
            if(node.step(this)){

            }

        }
    }

    private double calculateBrakingDistance() {
        double brakingDistance = (currentSpeed * currentSpeed);
        if (brakingDistance > distanceUntilNextStop) {
            brakingDistance = distanceUntilNextStop + 1;
        }
        return brakingDistance;
    }

    public void update() {
        this.moveTrain();
        this.scanAndPerceive(this.node.getAngle(), railway.stops);
        this.updateGps();
    }


    private void updateGps() {
        Predicate gps = new Predicate(GPS_FUNCTOR);
        gps.addTerm(new NumberTermImpl(getPosition()[0]));
        gps.addTerm(new NumberTermImpl(getPosition()[1]));
        gps.addTerm(new NumberTermImpl(getCurrentSpeed()));
        this.addPercept(gps);
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }


    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = Math.min(Math.max(0, currentSpeed), 100);
    }

    public ATRoute getRoute() {
        return route;
    }

    public void setRoute(ATRoute route) {
        this.route = route;
    }

    @Override
    public String getType() {
        return "AT";
    }

    @Override
    public double[] getPosition() {
        return new double[]{node.getX(), node.getY()};
    }
}
