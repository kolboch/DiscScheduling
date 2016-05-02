package diskTasks;

import java.util.Comparator;

public class ApproachRequestComparator implements Comparator<Request> {

	@Override
	public int compare(Request o1, Request o2) {
		if(o1 == null && o2 == null){
			return 0;
		}
		else if(o1 == null && o2 != null){
			return -1;
		}
		else if(o1 != null && o2 == null){
			return 1;
		}
		else{
		return o1.getApproachTime() == o2.getApproachTime() ? 0 : (o1.getApproachTime() > o2.getApproachTime() ? 1 : -1);
		}
	}

}
