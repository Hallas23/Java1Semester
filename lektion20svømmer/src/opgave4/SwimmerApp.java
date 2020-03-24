package opgave4;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {

        
        ArrayList<Double> lapTimes2 = new ArrayList<>();
       
        
        TrainingPlan t1 = new TrainingPlan('A', 16, 10);
        
        
        lapTimes2 = new ArrayList<>();
        lapTimes2.add(1.03);
        lapTimes2.add(1.01);
        lapTimes2.add(1.02);
        lapTimes2.add(1.05);
        lapTimes2.add(1.03);
        lapTimes2.add(1.06);
        lapTimes2.add(1.03);
        t1.createSwimmer("Mikkel", 1993, lapTimes2, "AIA-Tranbjerg");
        t1.createSwimmer("Mikkel", 1993, lapTimes2, "AIA-Tranbjerg");
        
        t1.printTrainningsPlan();
        
        
    }
    
}
