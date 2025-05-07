package trainsim.objects;

import eass.mas.ev3.EASSEV3Environment;
import eass.mas.ev3.EASSSensor;
import org.graphstream.graph.Node;
import trainsim.objects.node.SimNode;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SignalBox extends Stop {


    private boolean accepting;


    public SignalBox(Node node) {
        super(node);
        toggle();
    }

    public void toggle(){
        this.accepting = !this.accepting;
        String className = accepting ? "accepting" : "blocking";
        this.getSimNode().setStyle(className);
    }

    public boolean isAccepting() {
        return accepting;
    }

    @Override
    public String getType() {
        return "signal_box";
    }
}
