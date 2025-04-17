package trainsim;

import ail.mas.scheduling.NActionScheduler;
import ail.syntax.Action;
import ail.syntax.Unifier;
import ail.util.AILSocketClient;
import ail.util.AILexception;
import ajpf.MCAPLScheduler;
import ajpf.util.AJPFLogger;
import eass.mas.DefaultEASSEnvironment;

import java.io.IOException;

public class RailwayEnvironment extends DefaultEASSEnvironment {

    String logname = "trainsim.RailwayEnvironment";

    protected AILSocketClient socket;

    public RailwayEnvironment(){
        super();
        MCAPLScheduler s = new NActionScheduler(100);
        s.addJobber(this);
        setScheduler(s);
        addPerceptListener(s);
        connectToSocket();
    }

    private void connectToSocket(){
        try {
            socket = new AILSocketClient();
        } catch (IOException e) {
            AJPFLogger.severe(logname, e.getMessage());
            System.exit(0);
        }
        AJPFLogger.info(logname, "Connected to Socket");
    }

    @Override
    public boolean done() {
        return false;
    }

    @Override
    public Unifier executeAction(String agName, Action act) throws AILexception {
        if(act.getFunctor().equals("accelerate")){
            AJPFLogger.info(logname, agName + " is accelerating.");
        }

        return super.executeAction(agName, act);
    }
}
