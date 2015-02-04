package ail.platoon;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;

import ail.util.AILSocketServer;

public class Vehicle {
	/* Base port numbers - vehicle ID will be added to these */
	private int INBOUND_PORT = 8005;
	private int OUTBOUND_PORT = 7005;
	
	/* Inbound and outbound sockets, both are needed as Simulink can't handle bidirectional communication on a single socket */
	private AILSocketServer inbound;
	private AILSocketServer outbound;
	
	/* Data containers for ego (own vehicle), leader (via V2V) and preceding (via V2V) */
	public VehicleData ego = new VehicleData();
	public VehicleData leader = new VehicleData();
	public VehicleData preceding = new VehicleData();
	
	/* Set up our sockets */
	public Vehicle() {
		/* 
		 * IMPORTANT: Because these calls block on 'accept', we need to force Simulink to connect to the sockets in the right order.
		 * Use an atomic (or function-call) sub-system to encapsulate TCP Send/Receive blocks then use block priorities to force
		 * sorted execution order
		 */
		inbound = new AILSocketServer(INBOUND_PORT);
		outbound = new AILSocketServer(OUTBOUND_PORT);
	}
	
	/* Update our data and send a command */
	public boolean update(int command) {
		
		/* Set up a receive buffer */
		ByteBuffer buf = ByteBuffer.allocate(33*8);
		buf.order(ByteOrder.LITTLE_ENDIAN);
		
		/* Read from the inbound socket, if there's no data then we fail out */
		if (inbound.read(buf) <= 0) {
			return false;
		}
		
		/* Decode the data on the buffer */
		/* Ego data */
		ego.timestamp = buf.getDouble();
		ego.distance = buf.getDouble();
		ego.speed = buf.getDouble();
		ego.acceleration = buf.getDouble();
		ego.lateralAcceleration = buf.getDouble();
		ego.yawRate = buf.getDouble();
		ego.heading = buf.getDouble();
		
		ego.range = buf.getDouble();
		ego.azimuth = buf.getDouble();
		ego.lateralPosition = buf.getDouble();
		ego.headingError = buf.getDouble();
		ego.roadCurvature = buf.getDouble();
		
		/* Leader data */
		leader.timestamp = buf.getDouble();
		leader.distance = buf.getDouble();
		leader.speed = buf.getDouble();
		leader.acceleration = buf.getDouble();
		leader.lateralAcceleration = buf.getDouble();
		leader.yawRate = buf.getDouble();
		leader.heading = buf.getDouble();
		
		leader.lateralPosition = buf.getDouble();
		leader.headingError = buf.getDouble();
		leader.roadCurvature = buf.getDouble();
		
		/* Preceding data */
		preceding.platoonID = (int)buf.getDouble();
		preceding.timestamp = buf.getDouble();
		preceding.distance = buf.getDouble();
		preceding.speed = buf.getDouble();
		preceding.acceleration = buf.getDouble();
		preceding.lateralAcceleration = buf.getDouble();
		preceding.yawRate = buf.getDouble();
		preceding.heading = buf.getDouble();
		
		preceding.range = buf.getDouble();
		preceding.azimuth = buf.getDouble();
		preceding.lateralPosition = buf.getDouble();
		
		/* Create buffer to transmit our command */
		ByteBuffer buf2 = ByteBuffer.allocate(4);
		buf2.order(ByteOrder.LITTLE_ENDIAN);
		buf2.putInt(command);
		
		/* Write to outbound socket */
		outbound.write(buf2);
		return true;
	}
	
	/* Quick example usage */
	public static void main(String [] args) {
		Vehicle v = new Vehicle();
		
		/* Loop forever and update from Simulink, read will block so the processes naturally sync */
		while (true) {
			/* Call update with a random integer (as we have no commands to send yet!) */
			if (v.update((new Random()).nextInt(10))) {
				/* Print out some information */
				System.out.println(String.format("%.1f",v.ego.timestamp) + 
						"s: Vehicle is travelling at " +
						String.format("%.1f", v.ego.speed) + "m/s and is " +
						String.format("%.2f", v.ego.range) + "m behind another vehicle");
			}
		}
	}
		
}
