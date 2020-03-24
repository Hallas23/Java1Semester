
public class Data {
	
	public static Measurable max(Measurable[] objects) {
		Measurable max = objects[0];
		for (Measurable obj : objects) {
			if (max.getMeasure() < obj.getMeasure()) {
				max = obj;
			}
		}
		return max;
	}
	
	public static double avg (Measurable[] objects) {
		double sum = 0;
		for (Measurable obj : objects) {
			sum += obj.getMeasure();
		}
		return sum / objects.length;
	}

}