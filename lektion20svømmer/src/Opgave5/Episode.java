package Opgave5;

import java.util.ArrayList;

/**
 * Models a training plan for a Swimmer
 */
public class Episode {
	private int number;
	private ArrayList<String> guestActors;
	private int length;

	Episode(int number,ArrayList<String> guestActors, int length) {
		this.number = number;
		this.guestActors = guestActors;
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ArrayList<String> getGuestActors() {
		return new ArrayList<>(guestActors);
	}

	public void setGuestActors(ArrayList<String> guestActors) {
		this.guestActors = guestActors;
	}
	
	public void addGuestActors(String guestActor) {
		guestActors.add(guestActor);
	}
	
	public ArrayList<String> getGuest() {
		return new ArrayList<>(guestActors);
	}


}
