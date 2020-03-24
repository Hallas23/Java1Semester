package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class FlightTest {

    public static void main(String[] args) {
    	LocalDateTime egon = LocalDateTime.of(2018, 11,3,9,15);
    	LocalDateTime egon2 = LocalDateTime.of(2018, 11,3,12,49);
        Flight flight = new Flight("AY025", "Seoul", egon, egon2);
        flight.addPassenger("Arnold", 31);
        flight.addPassenger("Bruce", 59);
        flight.addPassenger("Dolph", 24);
        flight.addPassenger("Linda", 59);
        
        flight.displaylist();
        flight.removePassenger(1);
        System.out.println("     ");
        flight.displaylist();
        System.out.println(flight.flightDurationInHours());
        //flight.createPassenger("Jennifer", 65);
    }

}
