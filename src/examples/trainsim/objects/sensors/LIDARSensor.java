package trainsim.objects.sensors;

import ail.mas.vehicle.Sensor;
import ail.syntax.NumberTerm;
import ail.syntax.Predicate;
import ail.syntax.StringTerm;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LIDARSensor implements Sensor {

    public final static String LIDAR_FUNCTOR = "lidar_detect";
    private final static double MAX_LIDAR_RANGE = 200; //Represented in meters

    static final String logname = "trainsim.objects.sensors.LIDARSensor";

    List<Predicate> lidarDetect = new ArrayList<>();

    public HashMap<LIDARDetectable, Double> scan(double[] from, List<? extends LIDARDetectable> detectables){
        this.clearPercepts();
        HashMap<LIDARDetectable, Double> inRange = new HashMap<>();
        for(LIDARDetectable detectable: detectables){
            double[] to = detectable.getPosition();
            double distance = getDistance(from, to);
            if(distance <= MAX_LIDAR_RANGE){
                inRange.put(detectable, distance);
            }
        }
        return inRange;

    }

    private double getDistance(double[] from, double[] to) {
        if (from.length != to.length) {
            throw new IllegalArgumentException("Point arrays must have the same dimensions");
        }
        double sum = 0.0;
        for (int i = 0; i < from.length; i++) {
            double diff = to[i] - from[i];
            sum += diff * diff;
        }
        return Math.sqrt(sum) * 1000;
    }

    @Override
    public List<Predicate> getPercepts() {
        if (lidarDetect != null) {
            return lidarDetect;
        }
        return Collections.emptyList();
    }

    @Override
    public void addPercept(Predicate l) {
        if(l.getFunctor().equals(LIDAR_FUNCTOR)){
            lidarDetect.add(l);
        }
    }

    @Override
    public void removePercept(Predicate l) {
        this.getPercepts().remove(l);
    }

    public void clearPercepts() {
        this.getPercepts().clear();

    }



    @Override
    public int compareTo(@NotNull Sensor o) {
        return 0;
    }
}
