package trainsim;

import ail.mas.MAS;
import ail.mas.scheduling.ActionScheduler;
import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.Unifier;

import ail.util.AILexception;
import ajpf.MCAPLJobber;
import eass.mas.vehicle.EASSVehicleEnvironment;
import eass.semantics.EASSAgent;

import eis.iilang.Percept;
import org.jetbrains.annotations.NotNull;

import trainsim.objects.AutonomousTrain;

import java.util.HashMap;
import java.util.Map;

import static trainsim.TrainSimUI.railway;


public class RailwayEnvironment extends EASSVehicleEnvironment implements MCAPLJobber {

    String logname = "trainsim.RailwayEnvironment";

    private String ATName;

    public final Map<String, AutonomousTrain> trains = new HashMap<>();

    public RailwayEnvironment(){
        super();
        ActionScheduler s = new ActionScheduler();
        scheduler = s;
        setScheduler(s);
        s.addJobber(this);
        addPerceptListener(s);

    }

    public Unifier executeAction(String agName, Action act) throws AILexception {
        if(act.getFunctor().equals("move")){
            AutonomousTrain train = (AutonomousTrain) getVehicle(agName);
            double x = train.node.getX();
            double y = train.node.getY();

            Predicate pos = new Predicate("position");
            pos.addTerm(new NumberTermImpl(x));
            pos.addTerm(new NumberTermImpl(y));

            train.addPercept(pos);
            train.scanAndPerceive(railway.stops);
            return super.executeAction(agName, act);
        }
        return super.executeAction(agName, act);
    }

    public void addAgent(AILAgent a) {
        EASSAgent agent = (EASSAgent) a;

        String name = agent.getReasoningName();

        if(contains(name)){
            this.addAgentToVehicle(agent);
        }else{
            AutonomousTrain train = new AutonomousTrain(agent);
            trains.put(name, train);
            addVehicle(train);
            this.ATName = name;
        }
    }

    @Override
    public void setMAS(MAS m) {
        super.setMAS(m);
        createFillerTrains();
    }



    private void createFillerTrains(){
        try{

//            EASSAgent agent = new EASSAgent(this.getMas(), "train_0");
//            addAgent(agent);
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public void do_job() {
        int activeJobbers = scheduler.getActiveJobbers().size();
        if (activeJobbers > 1 || activeJobbers < 1) {
            notifyListeners("scheduler");
        } else {
            done();
        }
    }


    @Override
    public String getName() {
        return "";
    }

    @Override
    public int compareTo(@NotNull MCAPLJobber o) {
        return 0;
    }
}
