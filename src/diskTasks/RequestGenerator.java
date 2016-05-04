package diskTasks;

import java.util.Random;

public class RequestGenerator {
	
	public static Request[] generateRequest(int maxCylinder, int maxApproachTime, int numberOfRequests){
		Random r = new Random();
		Request[]array = new Request[numberOfRequests];
		for(int i = 0; i < array.length; i++){
			array[i] = new Request(r.nextInt(maxApproachTime), r.nextInt(maxCylinder));
		}
		
		return array;
	}
}
