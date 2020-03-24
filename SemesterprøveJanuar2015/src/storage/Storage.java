package storage;

import java.util.ArrayList;

import application.model.Kamp;
import application.model.Spiller;


public class Storage {
	
	private static ArrayList<Kamp> kampe = new ArrayList<>();
	private static ArrayList<Spiller> spillere = new ArrayList<>();


	public static ArrayList<Kamp> getKampe() {
		return new ArrayList<>(kampe);
	}

	public static ArrayList<Spiller> getSpillere() {
		return new ArrayList<>(spillere);
	}

	public static void addKamp(Kamp kamp) {
		kampe.add(kamp);
	}
	
	public static void addSpiller(Spiller spiller) {
		spillere.add(spiller);
	}
}
