package application.model;

import java.util.ArrayList;

public class Arrangement {
	private String navn;
	private boolean offentling;
	private final ArrayList<Reservation> reservationer = new ArrayList<>();

	public Arrangement(String navn, boolean offentling) {
		this.navn = navn;
		this.offentling = offentling;
	}

	public String getNavn() {
		return navn;
	}

	public boolean isOffentling() {
		return offentling;
	}

	public ArrayList<Reservation> getReservationer() {
		return new ArrayList<>(reservationer);
	}

	public void addReservation(Reservation reservation) {
		if (!reservationer.contains(reservation)) {
			reservationer.add(reservation);
		}
	}
	
	public void removeReservation(Reservation reservation) {
		if (reservationer.contains(reservation)) {
			reservationer.remove(reservation);
		}
	}
	
	public int AntalReserveredePladser() {
		int pladser = 0;
		
		for (Reservation plads: reservationer) {
			pladser += plads.getPladser().size();
		}
		return pladser;
	}

}
