package trainsim.objects;

import ail.semantics.AILAgent;
import ail.syntax.Predicate;
import eass.mas.vehicle.EASSVehicle;
import eass.mas.vehicle.EASSVehicleEnvironment;
import trainsim.RailwayEnvironment;
import trainsim.objects.sensors.LIDARDetectable;
import trainsim.objects.sensors.LIDARSensor;
import trainsim.objects.sensors.SimpleGPS;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public abstract class SmartVehicle extends EASSVehicle implements LIDARDetectable {

    public final SimpleGPS gps;
    public final LIDARSensor lidar;


    public SmartVehicle(AILAgent agent) {
        this.gps = new SimpleGPS();
        this.lidar = new LIDARSensor();
        addAgent(agent);
        agent.setEnv(this);
        addSensor(gps);
        addSensor(lidar);
    }

    public HashMap<LIDARDetectable, Double> scanAndPerceive(double angle, List<? extends LIDARDetectable> detectableList) {
        HashMap<LIDARDetectable, Double> scanned = lidar.scan(getPosition(), angle, detectableList);
        scanned.forEach((detectable, distance) -> {

            this.addPercept(detectable.getPredicate(distance));
        });
        return scanned;


    }

    @Override
    public String getID() {
        return this.getName();
    }

    @Override
    public String getType() {
        return "smart_vehicle";
    }
}
