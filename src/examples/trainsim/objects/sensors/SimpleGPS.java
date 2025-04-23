package trainsim.objects.sensors;

import ail.mas.vehicle.Sensor;
import ail.syntax.NumberTerm;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TrainGPS implements Sensor {

    Predicate position;

    static final String logname = "trainsim.objects.sensors.TrainGPS";

    @Override
    public List<Predicate> getPercepts() {
        ArrayList<Predicate> percepts = new ArrayList<Predicate>();
        // The sensor returns (X, Y) coordinates
        if (position != null) {
            percepts.add(position);
        }
        return percepts;
    }

    @Override
    public void addPercept(Predicate l) {
        if(l.getFunctor().equals("position")){
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

    /**
     * Return the x coordinate.
     * @return
     */
    public double getX() {
        return ((NumberTerm) position.getTerm(0)).solve();
    }

    /**
     * Return the y coordinate.
     * @return
     */
    public double getY() {
        return ((NumberTerm) position.getTerm(1)).solve();
    }


    @Override
    public int compareTo(@NotNull Sensor o) {
        if(o instanceof TrainGPS){
            return 0;
        }
        return 1;
    }
}
