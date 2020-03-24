package opgave2;

public class Data {
	
	public static Compareble max(Compareble[] objects) {
		Compareble max = objects[0];
		for (Compareble obj : objects) {
			
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