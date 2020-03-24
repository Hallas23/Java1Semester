package storage;

import java.util.ArrayList;

import application.model.Arrangement;
import application.model.Kamp;
import application.model.Reservation;


public class Storage {
	
	private static ArrayList<Kamp> pladser = new ArrayList<>();
	private static ArrayList<Reservation> reservationer = new ArrayList<>();
	private static ArrayList<Arrangement> arrangementer = new ArrayList<>();


	public static ArrayList<Kamp> getPladser() {
		return new ArrayList<>(pladser);
	}

	public static ArrayList<Reservation> getReservationer() {
		return new ArrayList<>(reservationer);
	}
	
	public static ArrayList<Arrangement> getArrangementer() {
		return new ArrayList<>(arrangementer);
	}

	public static void addPladser(Kamp plads) {
		pladser.add(plads);
	}
	
	public static void addReservationer(Reservation reservation) {
		reservationer.add(reservation);
	}
	
	public static void addArrangement(Arrangement Arrangement) {
		arrangementer.add(Arrangement);
	}
}
