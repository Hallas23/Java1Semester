package storage;

import java.util.ArrayList;

import application.model.Bil;
import application.model.Parkeringshus;

public class Storage {
	private static ArrayList<Parkeringshus> huse = new ArrayList<>();
	private static ArrayList<Bil> biler = new ArrayList<>();

	public static ArrayList<Parkeringshus> getParkeringshuse() {
		return new ArrayList<>(huse);
	}

	public static ArrayList<Bil> getBiler() {
		return new ArrayList<>(biler);
	}

	public static void storeParkeringshus(Parkeringshus hus) {
		huse.add(hus);
	}

	public static void storeBil(Bil bil) {
		biler.add(bil);
	}
}
