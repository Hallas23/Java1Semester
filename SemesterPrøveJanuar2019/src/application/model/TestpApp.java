package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

import application.controller.Controller;

public class TestpApp {

	public static void main(String[] args) {
		Forestilling f1 = Controller.createForestilling("Evita", LocalDate.of(2019, 01, 10),
				LocalDate.of(2019, 01, 20));
		Forestilling f2 = Controller.createForestilling("Lykke Per", LocalDate.of(2019, 02, 01),
				LocalDate.of(2019, 02, 10));
		Forestilling f3 = Controller.createForestilling("Chess", LocalDate.of(2019, 01, 21),
				LocalDate.of(2019, 01, 30));

		Kunde k1 = Controller.createKunde("Anders Hansen", "11223344");
		Kunde k2 = Controller.createKunde("Andrea Andreasen", "12345678");
		Kunde k3 = Controller.createKunde("Niels Madsen", "12341234");

		Plads p1 = Controller.createPlads(10, 10, 100);
		Plads p2 = Controller.createPlads(10, 11, 100);

		ArrayList<Plads> pladser = new ArrayList<>();
		
		ArrayList<Plads> pladser2 = new ArrayList<>();
		
		Plads p3 = Controller.createPlads(10, 12, 100);
		Plads p4 = Controller.createPlads(10, 13, 100);
		

		pladser.add(p1);
		pladser.add(p2);
		
		pladser2.add(p3);
		pladser2.add(p4);

		Bestilling b1  = Controller.opretBestillingMedPladser(f1, k1, LocalDate.of(2019, 01, 15), pladser);
		System.out.println(b1.getPladser());
		Bestilling b2 = Controller.opretBestillingMedPladser(f1, k2, LocalDate.of(2019, 01, 15), pladser2);
		System.out.println(b2.getPladser());
		
	}

}
