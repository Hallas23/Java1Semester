package opgave4;

import java.util.ArrayList;

/**
 * Models a training plan for a Swimmer
 */
public class TrainingPlan {
	private char level;
	private int weeklyWaterHours;
	private int weeklyStrengthHours;
	private final ArrayList<Swimmer> swimmers = new ArrayList<>();

	public TrainingPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
		this.level = level;
		this.weeklyWaterHours = weeklyWaterHours;
		this.weeklyStrengthHours = weeklyStrengthHours;
	}
	
	public Swimmer createSwimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
		Swimmer swimmer = new Swimmer (name	, yearGroup, lapTimes,  club);
		swimmers.add(swimmer);
		return swimmer;
	}

	public ArrayList<Swimmer> getSwimmers() {
		return new ArrayList<>(swimmers);
	}

	public void AddSwimmer(Swimmer swimmer) {
			swimmers.add(swimmer);
		
	}

	public void removePerson(Swimmer swimmer) {
		if (swimmers.contains(swimmer)) {
			swimmers.remove(swimmer);
		}
	}
	
	public char getLevel() {
		return level;
	}

	public void setLevel(char niveau) {
		this.level = niveau;
	}

	public int getWeeklyStrengthHours() {
		return weeklyStrengthHours;
	}

	public void setWeeklyStrengthHours(int weeklyStrengthHours) {
		this.weeklyStrengthHours = weeklyStrengthHours;
	}

	public int getWeeklyWaterHours() {
		return weeklyWaterHours;
	}

	public void setWeeklyWaterHours(int weeklyWaterHours) {
		this.weeklyWaterHours = weeklyWaterHours;
	}
	
	public void printTrainningsPlan() {
		for (int i = 0; i < swimmers.size(); i++) {
			System.out.println(swimmers.get(i).getName());
			System.out.println(swimmers.get(i).bestLapTime());
			System.out.println(swimmers.get(i).getYearGroup());
			System.out.println("************************");
		}
	}

}
