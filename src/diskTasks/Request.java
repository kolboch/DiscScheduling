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
	
	public String toString(){
		return String.format("%6d %6d", cylinderToRead, approachTime);
	}
}
