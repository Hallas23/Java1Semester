package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

import application.controller.Controller;

public class TestpApp {

	public static void main(String[] args) {
		Forestilling f1 = Controller.createForestilling("Evita", LocalDate.of(2019, 01, 10), LocalDate.of(2019, 01, 20));
		Forestilling f2 = Controller.createForestilling("Lykke Per", LocalDate.of(2019, 02, 01), LocalDate.of(2019, 02, 10));
		Forestilling f3 = Controller.createForestilling("Chess", LocalDate.of(2019, 01, 21), LocalDate.of(2019, 01, 30));

		Kunde k1 = new Kunde("Anders Hansen", "11223344");
	
		
	
		Plads p1 = Controller.createPlads(10, 10, 100);
		Plads p2 = Controller.createPlads(10, 11, 100);
	

		ArrayList<Plads> pladser = new ArrayList<>();
		pladser.add(p1);
		pladser.add(p2);
		Controller.oversigtOverForestillinger("C:/Users/Simon/Documents/ooo");
		
		Controller.opretBestillingMedPladser(f1, k1, LocalDate.of(2019, 01, 15), pladser);
		System.out.println(k1.getBestillinger().get(0).getForestilling().getNavn());
		
	}

}
