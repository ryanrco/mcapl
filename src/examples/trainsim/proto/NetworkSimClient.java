package trainsim.proto;


import com.google.protobuf.Empty;
import io.grpc.*;
import trainsim.objects.SmartVehicle;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NetworkSimClient {

    private static final Logger logger = Logger.getLogger(NetworkSimClient.class.getName());

    private final VehicleLTEControlServiceGrpc.VehicleLTEControlServiceBlockingStub blockingStub;

    public NetworkSimClient(Channel channel, String host){
        blockingStub = VehicleLTEControlServiceGrpc.newBlockingStub(channel);
        init(host);
        startNetworkSimulation();
    }


    private void init(String host){
        ManagedChannel channel = Grpc.newChannelBuilder(host, InsecureChannelCredentials.create()).build();


    }


    public void startNetworkSimulation(){
        DataStatus response;

        try{
            response = blockingStub.startSimulation(Empty.newBuilder().build());
        }catch (StatusRuntimeException e){
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Successfully connected to network simulator!");
    }

    public void createTrainNode(SmartVehicle smartVehicle){
        LTENode.Position position = LTENode.Position.newBuilder()
                .setX(((float) smartVehicle.getPosition()[0]))
                .setY(((float) smartVehicle.getPosition()[1]))
                .build();

        LTENode train = LTENode.newBuilder()
                .setId(smartVehicle.getID())
                .setPosition(position)
                .build();


        DataStatus response;

        try{
            response = blockingStub.initTrainNode(train);
        }catch (StatusRuntimeException e){
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Success! " + response.getMessage());
    }
}
