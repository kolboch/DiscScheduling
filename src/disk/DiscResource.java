package disk;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import diskTasks.Request;

public class DiscResource {
	
	private static int numberOfCylinders;
	private int distanceCovered;
	Queue<Request> requestQueue;
	private Comparator<Request> approachComparator;
	private Comparator<Request> diskDistanceComparator;
	
	public DiscResource(int numberOfCylinders){
		this.numberOfCylinders = numberOfCylinders;
		this.requestQueue = new PriorityQueue<>();
	}
	
	
	
	
	public int getDistanceCovered(){
		return this.distanceCovered;
	}
	
	private static int getNumberOfCylinders(){
		return numberOfCylinders;
	}
	
	private void enqueueRequest(Request req){
		requestQueue.offer(req);
	}
	
	private Request getNextRequest(){
		//TODO
		return null;
		
	}
}
