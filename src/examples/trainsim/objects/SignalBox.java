package trainsim.objects;

import eass.mas.ev3.EASSEV3Environment;
import eass.mas.ev3.EASSSensor;
import org.graphstream.graph.Node;
import trainsim.objects.node.SimNode;

import java.io.PrintStream;

public class SignallingBox implements EASSSensor {

    private final SimNode node;

    private boolean accepting;

    public SignallingBox(Node node){
        this.node = new SimNode(node);
        toggle();
    }

    private void toggle(){
        this.accepting = !this.accepting;
        String className = accepting ? "accepting" : "blocking";
        node.setStyle(className);
    }

    public boolean isAccepting() {
        return accepting;
    }

    @Override
    public void addPercept(EASSEV3Environment env) {

    }

    @Override
    public void setPrintStream(PrintStream o) {

    }

    @Override
    public void close() {

    }
}
