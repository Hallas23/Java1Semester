package model;

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

	public ArrayList<Swimmer> getSwimmers() {
		return new ArrayList<>(swimmers);
	}

	public void AddSwimmer(Swimmer swimmer) {
		if (!swimmers.contains(swimmer)) {
			swimmers.add(swimmer);
			swimmer.setTrainingPlan(this);
		}
	}

	public void removePerson(Swimmer swimmer) {
		if (swimmers.contains(swimmer)) {
			swimmers.remove(swimmer);
			swimmer.removeTrainingPlan();
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
