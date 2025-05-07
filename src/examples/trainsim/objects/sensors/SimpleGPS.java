package trainsim.objects.sensors;

import ail.mas.vehicle.Sensor;
import ail.syntax.NumberTerm;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SimpleGPS implements Sensor {

    Predicate position;

    public final static String GPS_FUNCTOR = "gps";
    static final String logname = "trainsim.objects.sensors.SimpleGPS";

    @Override
    public List<Predicate> getPercepts() {
        ArrayList<Predicate> percepts = new ArrayList<Predicate>();
        if (position != null) {
            percepts.add(position);
        }
        return percepts;
    }

    @Override
    public void addPercept(Predicate l) {
        if(l.getFunctor().equals("gps")){
            position = l;
        }
    }

    @Override
    public void removePercept(Predicate l) {
        AJPFLogger.warning(logname, "TrainGPS does not remove predicates");
    }

    public void clearPercepts() {
        AJPFLogger.warning(logname, "SimpleGPS does not remove predicates");
    }

    public double getX() {
        return ((NumberTerm) position.getTerm(0)).solve();
    }

    public double getY() {
        return ((NumberTerm) position.getTerm(1)).solve();
    }


    public double getSpeed() {
        return ((NumberTerm) position.getTerm(2)).solve();
    }


    @Override
    public int compareTo(@NotNull Sensor o) {
        if(o instanceof SimpleGPS){
            return 0;
        }
        return 1;
    }
}
