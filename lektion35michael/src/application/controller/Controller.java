package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import application.model.Bil;
import application.model.Bilmærke;
import application.model.Invalideplads;
import application.model.Parkeringshus;
import application.model.Parkeringsplads;
import storage.Storage;

public class Controller {

	public static Parkeringshus createParkeringshus(String adresse) {
		Parkeringshus hus = new Parkeringshus(adresse);
		Storage.storeParkeringshus(hus);
		return hus;
	}

	public static Parkeringsplads createParkeringsplads(int nummer, Parkeringshus hus) {
		Parkeringsplads plads = new Parkeringsplads(nummer, hus);
		hus.addParkeringsplads(plads);
		return plads;
	}

	public static Invalideplads createInvalideplads(int nummer, Parkeringshus hus, double areal) {
		Invalideplads plads = new Invalideplads(nummer, hus, areal);
		hus.addParkeringsplads(plads);
		return plads;
	}

	public static Bil createBil(String regNr) {
		Bil bil = new Bil(regNr);
		Storage.storeBil(bil);
		return bil;
	}

	public static void addBilTilParkeringsplads(Parkeringsplads plads, Bil bil) {
		plads.setBil(bil);
	}

	public static void createSomeObjects() {
		Bil b1 = Controller.createBil("AB 11.222");
		b1.setBilMærke(Bilmærke.AUDI);
		Bil b2 = createBil("EF 33.444");
		b2.setBilMærke(Bilmærke.AUDI);
		Bil b3 = createBil("BD 55.666");
		b3.setBilMærke(Bilmærke.SKODA);

		Parkeringshus hus = createParkeringshus("Havnegade 12, 8000 Aahus C");

		for (int nr = 1; nr <= 100; nr++) {
			createParkeringsplads(nr, hus);
		}
		for (int nr = 101; nr <= 110; nr++) {
			createInvalideplads(nr, hus, 18);
		}

		addBilTilParkeringsplads(hus.getParkeringsPladser().get(0), b1);
		addBilTilParkeringsplads(hus.getParkeringsPladser().get(9), b2);
		addBilTilParkeringsplads(hus.getParkeringsPladser().get(100), b3);
	}

	//-------------------------------------------------------------------------

	// S10 (5 p)
	public void writeOptagnePladser(Parkeringshus hus, String filnavn) {
		File f = new File(filnavn);
		try (PrintWriter writer = new PrintWriter(f)) {
			for (String info : hus.optagnePladser()) {
				writer.println(info);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Error writing to file: " + filnavn);
			System.out.println(ex);
		}

	}
}
