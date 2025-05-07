package trainsim.objects;

import io.grpc.netty.shaded.io.netty.util.Signal;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static trainsim.TrainSim.railway;
import static trainsim.TrainSim.simLogger;

public class Track {

    private final Edge edge;

    private final Stop from;
    private final Stop to;

    private boolean congested = true;
    private int speed_limit = 50;

    private List<SignalBox> controls;


    public Track(Railway railway, Edge edge) throws Exception {
        this.edge = edge;

        Optional<Stop> fromOpt = railway.getStop(edge.getSourceNode());
        Optional<Stop> toOpt = railway.getStop(edge.getTargetNode());

        if (fromOpt.isEmpty() || toOpt.isEmpty()) {
            throw new Exception("Error when creating a track. Track must have be connect two stops");
        }
        this.from = fromOpt.get();
        this.to = toOpt.get();
        init(railway);

    }

    private void init(Railway railway) {
        this.controls = new ArrayList<>();
        Optional<SignalBox> from = railway.getSignalBox(edge.getSourceNode());
        Optional<SignalBox> to = railway.getSignalBox(edge.getTargetNode());
        from.ifPresent(signalBox -> controls.add(signalBox));
        to.ifPresent(signalBox -> controls.add(signalBox));

        initAttributes();
    }


    private void initAttributes() {
        if (edge.hasAttribute("speed_limit")) {
            try {
                this.speed_limit = ((Integer) edge.getAttribute("speed_limit"));
            } catch (Exception e) {
                simLogger.warning("Failed to parse speed_limit for " + edge.getId() + "! Defaulting to: " + speed_limit);
            }
        }
    }

    public Edge getEdge() {
        return edge;
    }

    public boolean isCongested() {
        return congested;
    }

    public void setStyle(String style) {
        edge.setAttribute("ui.class", style);
    }

    public void resetStyle() {
        if (!congested) edge.removeAttribute("ui.class");
    }

    public void setCongested(boolean congested) {
        this.congested = congested;
        if (congested) {
            setStyle("congested");
            this.edge.setAttribute("congested", 150);
            return;
        }
        resetStyle();
    }

    public void toggleSignalBoxes() {
        controls.forEach(SignalBox::toggle);

    }

    @Override
    public String toString() {
        return "Track{" +
                "edge=" + edge.getId() +
                ", from=" + from.getID() +
                ", to=" + to.getID() +
                '}';
    }
}
