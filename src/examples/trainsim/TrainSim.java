package trainsim;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.util.AILConfig;
import ajpf.MCAPLcontroller;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import trainsim.config.RailwayConfig;
import trainsim.objects.Railway;
import trainsim.proto.NetworkSimClient;
import trainsim.ui.TrainSimUI;

import java.util.logging.Logger;

public class TrainSim {


    public static Logger simLogger = Logger.getLogger(TrainSim.class.getName());

    private static final String path = "/src/examples/trainsim/";
    private static final String ailConfig = "agents/railway.ail";

    public static TrainSimUI userInterface;
    public static Railway railway;
    private static RailwayConfig config;
    private static NetworkSimClient networkSim;

    public static void main(String[] args){

        if(args != null && args.length > 0){
            configure(args[0]);
        }else{
            configure("/src/examples/trainsim/config/config_automatic.txt");
        }


        initRailway();

        AILConfig config = getAilConfig();
        AIL.configureLogging(config);

        userInterface = new TrainSimUI(railway.getView());

        MCAPLcontroller mcControl = new MCAPLcontroller(config, "");
        MAS mas = AIL.AILSetup(config, mcControl);




        // Lastly we construct a controller.
        mcControl.setMAS(mas);
        // Start the system.
        mcControl.begin();
        mas.cleanup();


    }
    private static void connectToNetworkSimulator(String host){
        ManagedChannel channel = Grpc.newChannelBuilder(host, InsecureChannelCredentials.create()).build();
        try{
            networkSim = new NetworkSimClient(channel, host);
        }catch (Exception e){
            throw new RuntimeException("Failed to connect to network simulator");
        }
    }

    private static void initRailway(){
        railway = new Railway(config);
        railway.configure();
    }



    public static AILConfig getAilConfig(){
        return new AILConfig(path + ailConfig);
    }


    private static void configure(String fileName){
        config = new RailwayConfig(fileName);
    }
}
