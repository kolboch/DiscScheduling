package disk;

import java.util.PriorityQueue;
import java.util.Queue;

import diskTasks.ApproachRequestComparator;
import diskTasks.Request;

public class DiscResource {
	
	private int numberOfCylinders;
	private int distanceCovered;
	private int currentTime;
	private int currentCylinder;
	
	private Queue<Request> requestQueue;
	private Queue<Request> realTimeRequestQueue;
	
	public DiscResource(int numberOfCylinders){
		this.numberOfCylinders = numberOfCylinders;
		this.requestQueue = new PriorityQueue<>(new ApproachRequestComparator());
		this.realTimeRequestQueue = new PriorityQueue<>(new ApproachRequestComparator());
		this.currentCylinder = 0;
	}
	
	public int FCFS_algorithm(){
		//TODO
		
		return 0;
	}
	
	public int SSTF_algorithm(){
		//TODO
		return 0;
	}
	
	public int SCAN_Algorithm(){
		//TODO
		return 0;
	}
	
	public int CSCAN_Algorithm(){
		//TODO
		return 0;
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
	
	private void addDistanceCovered(Request lastRequest){
		addDistanceCovered(distanceCovered(lastRequest));
	}
	
	private int distanceCovered(Request req){
		return Math.abs(req.getCylinderToRead() - this.currentCylinder);
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
}
