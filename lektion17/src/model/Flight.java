package model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


/**
 * A flight with an airline between airports. 
 */
public class Flight {
    private String flightNumber;
    private String destination;
    private LocalDateTime departDate;
    private LocalDateTime arrivalDate;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    
    /**
     * Constructor that creates a flight for an airline.
     * @param flightNumber the number of the flight
     * @param destination the destination of the flight
     */
    // TODO: implement!
    
    public Flight(String flightNumber, String destination, LocalDateTime departDate, LocalDateTime arrivalDate) {
    	this.flightNumber = flightNumber;
    	this.destination = destination;
    	this.departDate = departDate;
    	this.arrivalDate = arrivalDate;
    }

    /**
     * Gets the destination.
     * @return the destination or null if not set
     */
    // TODO: implement!
    public String getDestination() {
  		return destination;
  	}
    
    /**
     * Gets the flight number.
     * @return the flight number
     */
    // TODO: implement!
    
    public String getFlightNumber() {
  		return flightNumber;
  	}
    
    /**
     * Gets the LocalDateTime when the flight will depart
     * @return departure date, can be null
     */
    // TODO: implement!
    
    public LocalDateTime  getDeparttime() {
    	return departDate;
    }

    /**
     * Sets the LocalDateTime when the flight will depart.
     * Precondition: cannot be later than the land time.
     * @param departDate
     */
    public void setDepartDate(LocalDateTime departDate) {
        this.departDate = departDate;
    }


	/**
     * Gets the LocalDateTime for when the flight will land.
     * @return arrival date, can be null
     */
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the LocalDateTime for when the flight will land.
     * Precondition: cannot be before the depart time.
     * @param landDate arrival date
     */
    // TODO: implement!
    
    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    
    /**
     * Creates a passenger with name and age
     * Precondition: name is not empty or null and age >= 0.
     * @param name name of the passenger
     * @param age the age of the passenger
     * @return the newly created passenger object
     */
    // TODO: implement!
    
    public void addPassenger(String name, int age) {
    	Passenger p = new Passenger(name, age);
    	passengers.add(p);
    	System.out.println(p.getAge() + " " + p.getName());
    }
    
    /**
     * Removes the passenger.
     * Precondition: the passenger must exists on this flight.
     * @param passenger
     */
    // TODO: implement!
    public void removePassenger(int p) {
    	passengers.remove(p);
    }
    
    
    /**
     * Gets the current list of passengers on this flight
     * @return list of passengers
     */
    // TODO: implement!
    public void displaylist() {
    	for(int i = 0; i < passengers.size(); i++) {
    		System.out.println(passengers.get(i).getAge() + " " + passengers.get(i).getName());
    	}		
    }
    
    
    /**
     * The duration of the flight measured in hours
     * Precondition: the depart and arrival dates must have been set
     * @return how many hours
     */
    public double flightDurationInHours() {
        Long timer = ChronoUnit.HOURS.between(arrivalDate, departDate);
        Long min =ChronoUnit.MINUTES.between(arrivalDate, departDate);
        Long tid = timer;
        
        // TODO: implement!
        // Hint: 
        // You can use the following to get hours between two LocalDates:
        //        ChronoUnit.HOURS.between(startDate, endDate)
        // ...and ChronoUnit.MINUTES for minutes...
        System.out.println("Min " + min);
        System.out.println("timer ");
        return tid;
    }
    
    /**
     * Returns true if the flight happens during midnight of the day of departure.
     * Precondition: depart and arrival dates must have been set
     * @return true if midnight is included in the flight period, otherwise false.
     */
    public boolean midnightFlight() {
       
        return false; // and don't just return false :)
    }
    
    /**
     * Gets the average age of all the passengers
     * Precondition: there must exists passengers on this flight
     * @return average age of passengers
     */
    // TODO: implement!
    
}
