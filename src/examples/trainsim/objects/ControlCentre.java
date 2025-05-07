package trainsim.objects;

import ail.semantics.AILAgent;
import ail.syntax.*;
import ail.util.AILexception;
import eass.mas.vehicle.EASSVehicle;
import org.graphstream.algorithm.Dijkstra;
import trainsim.TrainSim;
import trainsim.pathfinder.ATRoute;

import java.util.Optional;

import static trainsim.TrainSim.railway;


public class ControlCentre extends EASSVehicle {

    public final static String DEPARTURE_REQ = "departure_request";
    public final static String DEPARTURE_CLEARED = "departure_cleared";
    public final static String ROUTE_UPDATED = "route_updated";

    public final static String SIGNAL_CLEAR_REQ = "signal_check";
    public final static String SIGNAL_CLEAR = "signal_clear";

    public final static String JUNCTION_CLEAR = "junction_clear";

    public ControlCentre(AILAgent agent){
        addAgent(agent);
        agent.setEnv(this);
    }


    public void generateRandomRoute(AutonomousTrain train){
        Optional<Station> fromOpt = railway.getRandomStation();
        Optional<Station> toOpt = railway.getRandomStation();

        if(fromOpt.isEmpty() || toOpt.isEmpty()) return;

        Station from = fromOpt.get();
        Station to = toOpt.get();

        train.setRoute(new ATRoute(train, from, to));

        Predicate routeRequest = new Predicate(ROUTE_UPDATED);
        train.addSharedBelief(train.getName(), new Literal(routeRequest));

    }


    public Unifier executeAction(String agName, Action act) throws AILexception {
        return super.executeAction(agName, act);
    }


    public void requestSignalCheck(AutonomousTrain train, SignalBox signalBox){
        Predicate clearReq = new Predicate(SIGNAL_CLEAR_REQ);
        clearReq.addTerm(new StringTermImpl(train.getName()));
        clearReq.addTerm(new StringTermImpl(signalBox.getID()));
        this.addSharedBelief(this.getName(), new Literal(clearReq));


    }

    public void requestDeparture(AutonomousTrain train){
        Predicate departRequest = new Predicate(DEPARTURE_REQ);
        departRequest.addTerm(new StringTermImpl(train.getName()));
        this.addSharedBelief(this.getName(), new Literal(departRequest));
    }

    private void sendSignalClearAuth(AutonomousTrain train){
        Predicate clearAuth = new Predicate(SIGNAL_CLEAR);
        train.addSharedBelief(train.getName(), new Literal(clearAuth));
    }

    public void clearDeparture(AutonomousTrain train){
        Predicate departCleared = new Predicate(DEPARTURE_CLEARED);
        train.addSharedBelief(train.getName(), new Literal(departCleared));
    }




}


