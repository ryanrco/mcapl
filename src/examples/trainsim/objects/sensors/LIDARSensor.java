package trainsim.objects.sensors;

import ail.mas.vehicle.Sensor;
import ail.syntax.Predicate;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LIDARSensor implements Sensor {

    public final static String LIDAR_FUNCTOR = "distance_from";
    private final static double MAX_LIDAR_RANGE = 0.25;
    private final static double LIDAR_FOV = 45 ;

    static final String logname = "trainsim.objects.sensors.LIDARSensor";

    List<Predicate> lidarDetect = new ArrayList<>();

    public HashMap<LIDARDetectable, Double> scan(double[] pos, double fromAngle, List<? extends LIDARDetectable> detectables){
        this.clearPercepts();
        HashMap<LIDARDetectable, Double> inRange = new HashMap<>();
        for(LIDARDetectable detectable: detectables){
            double distance = getDistance(pos, fromAngle, detectable);
            if(distance > 0) inRange.put(detectable, distance);
        }
        return inRange;
    }

    private double getDistance(double[] fromPos, double currentAngle, LIDARDetectable target){
        double[] targetPos = target.getPosition();

        double x1 = fromPos[0], y1 = fromPos[1], x2 = targetPos[0], y2 = targetPos[1];

        double toPointX = x2 - x1;
        double toPointY = y2 -y1;

        float distance = (float) Math.sqrt(toPointX * toPointX + toPointY * toPointY);

        if(distance > MAX_LIDAR_RANGE) return -1;

        float dirX = (float) Math.cos(Math.toRadians(currentAngle));
        float dirY = (float) Math.sin(Math.toRadians(currentAngle));

        double vecX = toPointX / distance;
        double vecY = toPointY / distance;

        double dotProduct = dirX * vecX + dirY * vecY;

        float angleToPoint = (float) Math.toDegrees(Math.acos(dotProduct));

        if(angleToPoint <= (LIDAR_FOV / 2)){
            return distance * 1000;
        }
        return -1;
    }

    public List<Predicate> getPercepts() {
        if (lidarDetect != null) {
            return lidarDetect;
        }
        return Collections.emptyList();
    }


    public void addPercept(Predicate l) {
        if(l.getFunctor().equals(LIDAR_FUNCTOR)){
            lidarDetect.add(l);
        }

    }


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
