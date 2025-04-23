package trainsim.objects;

import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.StringTerm;
import ail.syntax.StringTermImpl;
import ail.syntax.Unifier;
import ail.util.AILexception;
import trainsim.objects.node.TrainNode;
import trainsim.pathfinder.ATRoute;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static trainsim.TrainSimUI.railway;
import static trainsim.TrainSimUI.trainAnimator;

public class AutonomousTrain extends SmartVehicle {

    public TrainNode node;
    private final ATRoute route;


    public AutonomousTrain(AILAgent agent){
        super(agent);
        this.route = new ATRoute(null, null);
        initNode(agent);
    }

    private void initNode(AILAgent agent){
        this.node = new TrainNode(route, railway.network.addNode(agent.getAgName()));
        node.setStyle("train");
    }

    public Unifier executeAction(String agName, Action act) throws AILexception {
        if(act.getFunctor().equals("move")){
            trainAnimator.schedule(() -> {
                node.step(this);
            }, 0, TimeUnit.MILLISECONDS);
            return super.executeAction(agName, act);
        }

        if(act.getFunctor().equals("lidar_scan")){
            System.out.println("Did scan");
            this.scanAndPerceive(railway.stops);
            return super.executeAction(agName, act);
        }

        if(act.getFunctor().equals("set_current")){
            String stopString = ((StringTerm) act.getTerm(0)).getString();
            Optional<Stop> optStop = railway.getStop(stopString);
            try {
                if (optStop.isPresent()) {
                    Stop stop = optStop.get();
                    this.route.setSource(stop.getSimNode());
                    node.setPosition(stop.getPosition());
                }
            }catch (Exception ignored){}; //TODO: Make this cleaner
            return super.executeAction(agName, act);
        }

        if(act.getFunctor().equals("set_target")){
            String stopString = ((StringTerm) act.getTerm(0)).getString();
            Optional<Stop> station = railway.getStop(stopString);
            try {
                if (station.isPresent()) {
                    this.route.setTarget(station.get().getSimNode());
                }
            }catch (Exception e){};
            return super.executeAction(agName, act);
        }

        if(act.getFunctor().equals("get_next_stop")){
            Stop next = route.getNextStop();
            Unifier u = new Unifier();
            u.unifies(act.getTerm(0), new StringTermImpl(next.getID()));
            return u;
        }
        return super.executeAction(agName, act);
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
