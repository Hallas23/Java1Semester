package opgave4;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Modeling a Swimmer
 */
public class Swimmer {
    private String name;
    private String club;
    private int yearGroup;
    private ArrayList<Double> lapTimes;
    private TrainingPlan plan;
    
    /**
     * Initialize a new swimmer with name, club, yearGroup, and lap times.
     */ 

   Swimmer (String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
       this.name = name;
       this.yearGroup = yearGroup;
       this.lapTimes = lapTimes;
       this.club = club;
   }
    /**
     * Return the name of the swimmer
     */
    public String getName() {
        return this.name;
    }
    
    public int allTraininghours() {
    	int str = plan.getWeeklyStrengthHours();
    	int water = plan.getWeeklyWaterHours();
    	
    	return str + water;
    		
    	
    }

    /**
     * Return the yearGroup of the swimmer
     */
    public int getYearGroup() {
        return this.yearGroup;
    }
    
    public TrainingPlan getPlan() {
    	return plan;
    }
    
    public void setTrainingPlan(TrainingPlan plan) {
    	if(this.plan != plan) {
    		this.plan = plan;
    	}
    }

    /**
     * Return the club of the swimmer
     */
    public String getClub() {
        return this.club;
    }

    /**
     * Register the club of the swimmer
     * @param club
     */
    public void setClub(String club) {
        this.club = club;
    }
  
    
    /**
     * Return the fastest lap time
     */
    public double bestLapTime() {
    	double time = 1000;
        for (int i = 0; i < lapTimes.size(); i++) {
        	if (lapTimes.get(i) < time) {
        		time = lapTimes.get(i);
        	}
        }
        return time;
    }
}
