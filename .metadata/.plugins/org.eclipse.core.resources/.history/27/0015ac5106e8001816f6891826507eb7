package application.model;

import java.util.ArrayList;

public class Tilmelding {
	private String navn;
	private String ledsagernavn;
	private Hotel hotel;

	private final ArrayList<Deltager> deltagere = new ArrayList<>();
	private final ArrayList<Konference> konferencer = new ArrayList<>();


	public Tilmelding(String navn, String ledsagernavn) {
		this.navn = navn;
		this.ledsagernavn = ledsagernavn;
	}


	public ArrayList<Deltager> getDeltagere() {
		return new ArrayList<>(deltagere);
	}

	public void AddDeltager(Deltager deltager) {
		if (!deltagere.contains(deltager)) {
			deltagere.add(deltager);
			deltager.addTilmelding(this);
		}
	}

	public void removeDeltager(Deltager deltager) {
		if (deltagere.contains(deltager)) {
			deltagere.remove(deltager);
			deltager.removeTilmelding(this);
		}
	}

	public String getNavn() {
		return navn;
	}

	public void printDeltagere() {
		int i = 0;
		for (Deltager a : deltagere) {
			i++;
			System.out.print("Deltager " + i + " ");
			System.out.println(a);
		}
	}
	
	public String getLedsagernavn() {
		return ledsagernavn;
	}

	public void setLedsagernavn(String ledsagernavn) {
		this.ledsagernavn = ledsagernavn;
	}
	
	public String toString() {
		System.out.print(" || " + navn + " ledsager: ");
		return ledsagernavn;
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	
	public void setHotel(Hotel hotel) {
		if(this.hotel != hotel) {
			this.hotel = hotel;
		}
	}
}
