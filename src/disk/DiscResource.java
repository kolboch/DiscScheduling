package disk;

import java.util.PriorityQueue;
import java.util.Queue;

import diskTasks.ApproachRequestComparator;
import diskTasks.Request;

public class DiscResource {
	
	private int numberOfCylinders;
	private int distanceCovered;
	private int currentTime;
	
	private Queue<Request> requestQueue;
	private Queue<Request> realTimeRequestQueue;
	
	public DiscResource(int numberOfCylinders){
		this.numberOfCylinders = numberOfCylinders;
		this.requestQueue = new PriorityQueue<>(new ApproachRequestComparator());
		this.realTimeRequestQueue = new PriorityQueue<>(new ApproachRequestComparator());
	}
	
	public int getDistanceCovered(){
		return this.distanceCovered;
	}
	
	private int getNumberOfCylinders(){
		return numberOfCylinders;
	}
	
	private void enqueueRequest(Request req){
		requestQueue.offer(req);
	}
	
	private Request getNextRequest(){
		
		if(!realTimeRequestQueue.isEmpty()){
			if(realTimeRequestQueue.peek().getApproachTime() > getCurrentTime()){
				return realTimeRequestQueue.poll();
			}
		}
		if(!requestQueue.isEmpty()){
			
			Request nextRequest = null;
			
			for(Request r : requestQueue){
				
				// for not FCFS algorithm we will change comparator 
				// so we will get valid request but sorted according to actual comparator
				if(r.getApproachTime() > getCurrentTime()){ 
					nextRequest = r;
					break;
				}
				
			}
			requestQueue.remove(nextRequest);
			return nextRequest;
		}
		else{
			return null;
		}
	}
	
	private boolean hasNextRequest(){
		
		if(!realTimeRequestQueue.isEmpty()){
			return true;
		}
		else if(!requestQueue.isEmpty()){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	private int getCurrentTime(){
		return this.currentTime;
	}
	
	private void addElapsedTime(int timeElapsed){
		this.currentTime += timeElapsed;
	}
	
	private void addDistanceCovered(int distanceCovered){
		this.distanceCovered += distanceCovered;
	}
}
