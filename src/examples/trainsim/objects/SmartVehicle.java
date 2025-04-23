package trainsim.objects;

import ail.semantics.AILAgent;
import ail.syntax.Predicate;
import eass.mas.vehicle.EASSVehicle;
import trainsim.objects.sensors.LIDARDetectable;
import trainsim.objects.sensors.LIDARSensor;
import trainsim.objects.sensors.SimpleGPS;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static trainsim.TrainSimUI.railway;


public abstract class SmartVehicle extends EASSVehicle implements LIDARDetectable {

    public final SimpleGPS gps;
    public final LIDARSensor lidar;


    public SmartVehicle(AILAgent agent){
        this.gps = new SimpleGPS();
        this.lidar = new LIDARSensor();
        addAgent(agent);
        agent.setEnv(this);
        addSensor(gps);
        addSensor(lidar);
    }

    public void scanAndPerceive(List<? extends LIDARDetectable> detectableList){
        HashMap<LIDARDetectable, Double> scanned = lidar.scan(getPosition(), detectableList);
        scanned.forEach((detectable, distance) -> {
            Predicate p = detectable.getPredicate(distance);
            System.out.println("Added predicate: " + p);
            this.addPercept(detectable.getPredicate(distance));

        });


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
