package trainsim.objects.sensors;

import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.StringTermImpl;

import static trainsim.objects.sensors.LIDARSensor.LIDAR_FUNCTOR;

public interface LIDARDetectable {

    String getID();

    String getType();

    double[] getPosition();

    default Predicate getPredicate(double distance){
        Predicate predicate = new Predicate(LIDAR_FUNCTOR);
        predicate.addTerm(new StringTermImpl(getType()));
        predicate.addTerm(new StringTermImpl(getID()));
        predicate.addTerm(new NumberTermImpl(distance));
        return predicate;
    }
}
