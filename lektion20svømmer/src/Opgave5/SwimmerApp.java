package Opgave5;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {

        
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Micheal");
        cast.add("Jim");
        cast.add("Dwight");
        cast.add("Pam");
        ArrayList<String> guestActors = new ArrayList<>();
        guestActors.add("Andy");
        
        
        Series office = new Series("The Office", cast);
        office.createEpisode(1, guestActors, 22);
        office.createEpisode(2, guestActors, 22);
        office.createEpisode(3, guestActors, 22);
        office.addGuestActors(0);
        office.addGuestActors(1);
        office.addGuestActors(2);
        office.addGuestActors(0);
        System.out.println(office.totalLength());
        
        
      
      
        
    }
    
}
