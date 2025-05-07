package trainsim;

import ail.mas.scheduling.RoundRobinScheduler;
import ail.mas.vehicle.VehicleInterface;
import ail.semantics.AILAgent;
import ail.syntax.*;

import ail.util.AILexception;

import ajpf.MCAPLJobber;
import eass.mas.vehicle.EASSVehicle;
import eass.mas.vehicle.EASSVehicleEnvironment;
import eass.semantics.EASSAgent;
import trainsim.objects.AutonomousTrain;
import trainsim.objects.ControlCentre;
import trainsim.objects.SignalBox;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import static trainsim.TrainSim.railway;
import static trainsim.TrainSim.userInterface;
import static trainsim.objects.ControlCentre.SIGNAL_CLEAR_REQ;

public class RailwayEnvironment extends EASSVehicleEnvironment {

    String name = "Railway Environment";
    RoundRobinScheduler scheduler;


    private boolean initialised = false;


    //NB. We assume the existence of only one controlCenter in this simulation
    private ControlCentre controlCenter;

    public RailwayEnvironment() {
        super();
        RoundRobinScheduler s = new RoundRobinScheduler();
        scheduler = s;
        setScheduler(s);
        s.addJobber(this);
        addPerceptListener(s);
    }

    public void addAgent(AILAgent a) {
        EASSAgent eass = (EASSAgent) a;
        String name = eass.getReasoningName();


        if (contains(name)) {
            this.addAgentToVehicle(eass);
        } else {
            EASSVehicle agent;
            if (name.startsWith("train")) {
                System.out.println("Created train");
                agent = new AutonomousTrain(a);
            } else if (name.startsWith("command")) {
                System.out.println("Created control");
                agent = new ControlCentre(a);
                controlCenter = (ControlCentre) agent;
            } else {
                return;
            }
            addVehicle(agent);
        }

    }


    public Unifier executeAction(String agName, Action act) throws AILexception {
        System.out.println(act.getFunctor());
        if (act.getFunctor().equals("request_departure_clearance")) {
            VehicleInterface vehicle = getVehicle(agName);
            if (vehicle instanceof AutonomousTrain) {
                controlCenter.requestDeparture((AutonomousTrain) vehicle);
            }
        }

        if (act.getFunctor().equals("clear_departure")) {
            VehicleInterface vehicle = getVehicle(agName);
            if (vehicle instanceof ControlCentre) {
                StringTerm trainName = (StringTerm) act.getTerm(0);
                AutonomousTrain at = (AutonomousTrain) getVehicle(trainName.getString());
                controlCenter.clearDeparture(at);
            }
        }

        if (act.getFunctor().equals("request_route_update")) {
            VehicleInterface vehicle = getVehicle(agName);
            if (vehicle instanceof AutonomousTrain) {
                controlCenter.generateRandomRoute((AutonomousTrain) vehicle);

            }
        }

        if (act.getFunctor().equals(SIGNAL_CLEAR_REQ)) {
            VehicleInterface vehicle = getVehicle(agName);
            System.out.println("Clearance check");
            if (vehicle instanceof AutonomousTrain) {
                String signalID = ((StringTerm) act.getTerm(0)).getString();
                Optional<SignalBox> sb = railway.getSignalBox(signalID);
                System.out.println("SB: " + signalID);
                sb.ifPresent(signalBox -> controlCenter.requestSignalCheck((AutonomousTrain) vehicle, signalBox));
            }
        }


        return super.executeAction(agName, act);
    }

    int trainCount = 0;

    long lastExecuted = 0;

    public void eachrun() {
        long now = System.currentTimeMillis();
        if (now >= lastExecuted + 16) {
            for (AutonomousTrain train : getTrains()) {
                train.update();
            }
            userInterface.update();
            lastExecuted = now;
        }
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(MCAPLJobber o) {
        return (getName().compareTo(o.getName()));
    }

    public String getName() {
        return name;
    }

    public boolean done() {
        return false;
    }


    public void init_after_adding_agents() {
        getTrains().forEach(train -> {
            userInterface.statusPanel.trackTrain(train);
        });

    }

    public ControlCentre getControlCenter() {
        return controlCenter;
    }

    public List<AutonomousTrain> getTrains() {
        return this.vehicles.values()
                .stream()
                .filter(vehicleInterface -> vehicleInterface instanceof AutonomousTrain)
                .map(vehicleInterface -> ((AutonomousTrain) vehicleInterface))
                .collect(Collectors.toList());
    }

}
