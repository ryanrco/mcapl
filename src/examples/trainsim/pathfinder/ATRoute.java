package trainsim.pathfinder;

import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.StringTermImpl;

import trainsim.objects.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static trainsim.TrainSim.railway;


public class ATRoute {

    private final AutonomousTrain train;

    private Stop currentStation;
    private Station nextStation;
    private Station targetStation;
    private SignalBox nextJunction;

    private List<Stop> shortest;
    private List<Track> tracks;

    private Track currentTrack;

    private int reroutes = 0;


    public ATRoute(AutonomousTrain train, Station from, Station to) {
        this.train = train;
        setCurrentStation(from);
        setTargetStation(to);
        generateShortest();
    }

    private void generateShortest(){
        RouteBuilder routeBuilder = new RouteBuilder(this.currentStation, this.targetStation);
        try{
            shortest = routeBuilder.getStops();
            tracks = routeBuilder.getTracks();
            setupRoute();
        }catch (Exception e){
            e.printStackTrace();
        };
    }

    public void progressRoute(){
        Optional<Track> currentTrack = getCurrentTrack();
        currentTrack.ifPresent(track -> {
            track.setCongested(false);
            track.toggleSignalBoxes();
        });

        Optional<Stop> optNext = getNextPath();
        optNext.ifPresent(stop -> {
            this.setCurrentStation(stop);
            this.shortest.remove(stop);
        });

        setupRoute();
        this.train.node.progressedRoute = true;
    }

    private void setupRoute(){
        Optional<SignalBox> signalBox = shortest.stream().filter(stop -> stop instanceof SignalBox)
                .map(stop -> (SignalBox) stop).findFirst();

        signalBox.ifPresent(this::setNextJunction);

        Optional<Station> nextStation = shortest.stream().filter(station -> station instanceof Station)
                .map(station -> (Station) station).findFirst();



        nextStation.ifPresent(this::setNextStation);
        Optional<Track> currentTrack = getCurrentTrack();
        currentTrack.ifPresent(track -> track.setCongested(true));

    }

    public Optional<Stop> getNextPath(){
        try {
            return Optional.of(shortest.stream().findFirst().get());
        }catch (Exception ignored){};
        return Optional.empty();
    }



    private void setCurrentStation(Stop stop){
        this.currentStation = stop;
        Predicate current = new Predicate("current_station");
        current.addTerm(new StringTermImpl(stop.getID()));
        train.addSharedBelief(train.getName(), new Literal(current));
    }

    public void notifyArrival(Stop stop){
        Predicate current = new Predicate("arrived_at");
        current.addTerm(new StringTermImpl(stop.getID()));
        train.addSharedBelief(train.getName(), new Literal(current));
        System.out.println("Arrived: " + current);
    }

    public Stop getCurrentStation() {
        return currentStation;
    }

    private void setNextStation(Station station){
        this.nextStation = station;
        Predicate next = new Predicate("next_station");
        if(nextStation != null) {
            next.addTerm(new StringTermImpl(station.getID()));
            train.addSharedBelief(train.getName(), new Literal(next));
        }else{
            train.removeSharedBelief(train.getName(), new Literal(next));
        }
    }

    private void setTargetStation(Station station){
        this.targetStation = station;
        Predicate next = new Predicate("target_station");
        if(nextStation != null) {
            next.addTerm(new StringTermImpl(station.getID()));
            train.addSharedBelief(train.getName(), new Literal(next));
        }else{
            train.removeSharedBelief(train.getName(), new Literal(next));
        }
    }



    private void setNextSignallingBox(Station station){
        this.nextStation = station;
        Predicate next = new Predicate("next_station");
        if(nextStation != null) {

            next.addTerm(new StringTermImpl(station.getID()));
            train.addSharedBelief(train.getName(), new Literal(next));
        }else{
            train.removeSharedBelief(train.getName(), new Literal(next));
        }
    }


    private void setNextJunction(SignalBox signalBox){
        this.nextJunction = signalBox;
        Predicate next = new Predicate("next_junction");
        if(nextJunction != null) {
            next.addTerm(new StringTermImpl(signalBox.getID()));
            train.addSharedBelief(train.getName(), new Literal(next));
        }else{
            train.removeSharedBelief(train.getName(), new Literal(next));
        }
    }

    public Optional<Track> getCurrentTrack(){
        Optional<Stop> nextPath = getNextPath();
        if(nextPath.isPresent()){
            return railway.getTrackBetween(currentStation.getSimNode().node, nextPath.get().getSimNode().node);
        }
        return Optional.empty();
    }

    public Station getTargetStation() {
        return targetStation;
    }

    public Station getNextStation() {
        return nextStation;
    }

    public void highlightTracks(){
        tracks.forEach(track -> {
            track.setStyle("highlighted");
        });
    }

    @Override
    public String toString() {
        return shortest.stream()
                .map(Stop::getID)  // Get the ID of each Stop
                .collect(Collectors.joining(" -> "));  // Join them with " -> "
    }
}
