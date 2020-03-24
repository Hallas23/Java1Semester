package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {
	private LocalDateTime start;
	private LocalDateTime slut;
	private final ArrayList<Kamp> pladser =new ArrayList<>();
	
	
	public Reservation(LocalDateTime start, LocalDateTime slut) {
		this.start = start;
		this.slut = slut;
	}


	public LocalDateTime getStart() {
		return start;
	}


	public LocalDateTime getSlut() {
		return slut;
	}
	
	public ArrayList<Kamp> getPladser() {
		return new ArrayList<>(pladser);
	}
	
	public void addPlads(Kamp plads) 
	{
		if (!pladser.contains(plads)) {
			pladser.add(plads);
			plads.addReservation(this);
		}
	}
	
	public void removePlads(Kamp plads) {
		if (pladser.contains(plads)) {
			pladser.remove(plads);
			plads.removeReservation(this);
		}
	}
	
	public String toString() {
		return " " + pladser + " " + start + " "+ slut;
	}
	
}
