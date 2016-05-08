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
		this.currentTime = 0;
		this.distanceCovered = 0;
	}
	
	public int FCFS_algorithm(){
		
		reset();
		
		while(!hasFinished()){
			Request currentRequest = getNextRequest();
			
			if(currentRequest == null){
				addElapsedTime(3);
			}
			else
			{
				addDistanceCovered(currentRequest);
				addElapsedTime(1);
				setCurrentCylinder(currentRequest.getCylinderToRead());
			}
		}
		return getDistanceCovered();
	}
	
	public int SSTF_algorithm(){
		
		reset();
		
		while(!hasFinished()){
			
			Request current = getClosestAvailable();
			if(current == null){
				addElapsedTime(3);
			}
			else{
				addDistanceCovered(current);
				addElapsedTime(1);
				setCurrentCylinder(current.getCylinderToRead());
			}
		}
		return getDistanceCovered();
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
			if(realTimeRequestQueue.peek().getApproachTime() <= getCurrentTime()){
				return realTimeRequestQueue.poll();
			}
		}
		if(!requestQueue.isEmpty()){
			
			Request nextRequest = null;
			
			for(Request r : requestQueue){
				
				// for not FCFS algorithm we will change comparator 
				// so we will get valid request but sorted according to actual comparator
				if(r.getApproachTime() <= getCurrentTime()){ 
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
	
	private Request getClosestAvailable(){
		
		Request closest = null;
		int minDistance = this.numberOfCylinders;
		
		if(!realTimeRequestQueue.isEmpty()){
			
			for(Request req : realTimeRequestQueue){
				if(req.getApproachTime() <= getCurrentTime()){
					if(distanceFromCurrent(req) < minDistance){
						closest = req;
						minDistance = distanceFromCurrent(req);
					}
				}
			}
			if(closest != null){
				realTimeRequestQueue.remove(closest);
				return closest;
			}
		}
		
		if(!requestQueue.isEmpty()){
			
			for(Request req : requestQueue){
				if(req.getApproachTime() <= getCurrentTime()){
					if(distanceFromCurrent(req) < minDistance){
						closest = req;
						minDistance = distanceFromCurrent(req);
					}
				}
			}
			if(closest != null){
				requestQueue.remove(closest);
				return closest;
			}
		}
		
		return closest;
	}
	
	private boolean hasFinished(){
		if(requestQueue.isEmpty() && realTimeRequestQueue.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	
	private int distanceFromCurrent(Request r){
		return Math.abs(r.getCylinderToRead() - currentCylinder);
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
	
	private void setCurrentCylinder(int cylinder){
		this.currentCylinder = cylinder;
	}
	
	public int getDistanceCovered(){
		return this.distanceCovered;
	}
	
	private int getNumberOfCylinders(){
		return numberOfCylinders;
	}
	
	public void enqueueRequest(Request req){
		requestQueue.offer(req);
	}
	
	public void enqueueRequests(Request[]requestArray){
		for(int i = 0; i < requestArray.length; i++){
			enqueueRequest(requestArray[i]);
		}
	}
	
	public void enqueueRealTimeRequest(Request req){
		realTimeRequestQueue.offer(req);
	}
	
	public void enqueueRealTimeRequests(Request[]requestArray){
		for(int i = 0; i < requestArray.length; i++){
			enqueueRealTimeRequest(requestArray[i]);
		}
	}
	
	private void reset(){
		this.distanceCovered = 0;
		this.currentTime = 0;
		this.currentCylinder = 0;
	}
	
	public void printRequestQueue(){
		Object[]array = requestQueue.toArray();
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i].toString());
		}
	}
}
