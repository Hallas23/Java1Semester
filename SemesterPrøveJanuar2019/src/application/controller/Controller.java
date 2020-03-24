package application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import java.util.ArrayList;

import application.model.Bestilling;
import application.model.Forestilling;
import application.model.Kunde;
import application.model.Plads;
import storage.Storage;

public class Controller {

	public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato) {
		Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
		Storage.addForestilling(forestilling);
		return forestilling;
	}

	public static Kunde createKunde(String navn, String mobil) {
		Kunde kunde = new Kunde(navn, mobil);
		Storage.addKunde(kunde);
		return kunde;
	}

	public static Plads createPlads(int række, int nr, int pris) {
		Plads plads = new Plads(række, nr, pris);
		return plads;
	}

	public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato,
			ArrayList<Plads> pladser) {
		try {
			boolean ledig = true;
			for (Bestilling b : forestilling.getBestillinger()) {

				if (b.getDato().equals(dato)) {	

					for (int i = 0; i < b.getPladser().size(); i++) {

						for (int j = 0; j < pladser.size(); j++) {

							if ((b.getPladser().get(i).getRække() == pladser.get(j).getRække())
									&& (b.getPladser().get(i).getNr() == pladser.get(j).getNr())) {
								ledig = false;
							}
						}
					}
				}
			}
			if (ledig) {
				Bestilling bestilling = forestilling.createBestilling(dato, kunde, forestilling);
				for (int i = 0; i < pladser.size(); i++) {
					bestilling.addPlads(pladser.get(i));
					kunde.addBestilling(bestilling);
				}
				return bestilling;
			}
		} catch (RuntimeException e) {
			System.out.println("Pladsen(erne) var optaget");
		}
		return null;
	}

	public static void oversigtOverForestillinger(String tekstFil) {
		try {
			String fileName = tekstFil;
			PrintWriter printWriter = new PrintWriter(fileName);

			for (int i = 0; i < Storage.getForestilling().size(); i++) {
				printWriter.println(Storage.getForestilling().get(i).getNavn());
			}

			// flush og skriv filen
			printWriter.flush();
			printWriter.close();
			System.out.println("Filen er lavet");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void initStorage() {
		Forestilling f1 = Controller.createForestilling("Evita", LocalDate.of(2019, 01, 10),
				LocalDate.of(2019, 01, 20));
		Forestilling f2 = Controller.createForestilling("Lykke Per", LocalDate.of(2019, 02, 01),
				LocalDate.of(2019, 02, 10));
		Forestilling f3 = Controller.createForestilling("Chess", LocalDate.of(2019, 01, 21),
				LocalDate.of(2019, 01, 30));

		Kunde k1 = Controller.createKunde("Anders Hansen", "11223344");
		Kunde k2 = Controller.createKunde("Peter Jensen", "12345678");
		Kunde k3 = Controller.createKunde("Niels Madsen", "12341234");

		Plads p1 = Controller.createPlads(10, 10, 100);
		Plads p2 = Controller.createPlads(10, 11, 100);

		ArrayList<Plads> pladser = new ArrayList<>();
		pladser.add(p1);
		pladser.add(p2);

		Controller.opretBestillingMedPladser(f1, k1, LocalDate.of(2019, 01, 15), pladser);

	}

}