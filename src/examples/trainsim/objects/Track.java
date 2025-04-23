package trainsim.objects;

import org.graphstream.graph.Edge;

import java.util.Optional;

/*public class Track {

    private final Edge edge;

    private final Station from;
    private final Station to;

    private boolean occupied = true;

    public Track(Railway railway, Edge edge) throws Exception {
        this.edge = edge;
        Optional<Station> from = railway.getStation(edge.getNode0());
        Optional<Station> to = railway.getStation(edge.getNode1());

        if (from.isEmpty() || to.isEmpty()) throw new Exception("Invalid track configuration");

        this.from = from.get();
        this.to = to.get();

    }

    public boolean isOccupied() {
        return occupied;
    }

    @Override
    public String toString() {
        return "Track{" +
                "edge=" + edge.getId() +
                ", from=" + from.getID() +
                ", to=" + to.getID() +
                '}';
    }
}*/
