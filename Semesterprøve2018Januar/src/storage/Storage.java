package storage;

import java.util.ArrayList;

import application.model.Arrangement;
import application.model.Tutor;
import application.model.Uddannelse;

public class Storage {
	
	private static ArrayList<Uddannelse> uddannelser = new ArrayList<>();
	private static ArrayList<Tutor> tutore = new ArrayList<>();
	private static ArrayList<Arrangement> arrangementer = new ArrayList<>();


	public static ArrayList<Uddannelse> getUddannelser() {
		return new ArrayList<>(uddannelser);
	}

	public static ArrayList<Tutor> getTutore() {
		return new ArrayList<>(tutore);
	}
	
	public static ArrayList<Arrangement> getArrangementer() {
		return new ArrayList<>(arrangementer);
	}

	public static void addUddannelse(Uddannelse uddannelse) {
		uddannelser.add(uddannelse);
	}

	public static void addTutor(Tutor tutor) {
		tutore.add(tutor);
	}
	
	public static void addArrangement(Arrangement Arrangement) {
		arrangementer.add(Arrangement);
	}
}
