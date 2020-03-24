package storage;

import java.util.ArrayList;


import application.model.Forestilling;
import application.model.Kunde;



public class Storage {
	
	private static ArrayList<Forestilling> forestillinger = new ArrayList<>();
	private static ArrayList<Kunde> kunder = new ArrayList<>();


	public static ArrayList<Forestilling> getForestilling() {
		return new ArrayList<>(forestillinger);
	}

	public static ArrayList<Kunde> getKunde() {
		return new ArrayList<>(kunder);
	}
	
	

	public static void addForestilling(Forestilling forestilling) {
		forestillinger.add(forestilling);
	}
	
	public static void addKunde(Kunde kunde) {
		kunder.add(kunde);
	}
	
}
