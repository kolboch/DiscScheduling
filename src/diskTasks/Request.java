package diskTasks;

public class Request {
	
	private int approachTime;
	private int cylinderToRead;
	
	public Request(int approachTime, int cylinderToRead){
		this.approachTime = approachTime;
		this.cylinderToRead = cylinderToRead;
	}
	
	public int getApproachTime(){
		return approachTime;
	}
	
	public int getCylinderToRead(){
		return cylinderToRead;
	}
}
