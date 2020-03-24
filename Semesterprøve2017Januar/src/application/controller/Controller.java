package application.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;

import application.model.Arrangement;
import application.model.Konsolplads;
import application.model.Område;
import application.model.Kamp;
import application.model.Reservation;
import storage.Storage;


public class Controller {

	public static Kamp createPlads(int nr) {
		Kamp plads = new Kamp(nr);
		Storage.addPladser(plads);
		return plads;
	}

	public static Kamp createKonsolplads(int nr, String type) {
		Kamp plads = new Konsolplads(nr, type);
		Storage.addPladser(plads);
		return plads;
	}

	public static Reservation createReservation(LocalDateTime start, LocalDateTime slut) {
		Reservation reservation = new Reservation(start, slut);
		Storage.addReservationer(reservation);
		return reservation;
	}

	public static Arrangement createArrangement(String navn, boolean offentling) {
		Arrangement arrangement = new Arrangement(navn, offentling);
		Storage.addArrangement(arrangement);
		return arrangement;
	}

	public static void addReservationTilPlads(Kamp plads, Reservation reservation) {
		plads.addReservation(reservation);
	}

	public static void addReservationTilArrangement(Arrangement arrangement, Reservation reservation) {
		arrangement.addReservation(reservation);
	}

	public static Kamp findPlads(Område område, int nummer) {
		ArrayList<Kamp> pladser = Storage.getPladser();
		ArrayList<Kamp> områdepladser = new ArrayList<>();
		
		for (Kamp p: pladser) {
			if (p.getOmråde() == område) {
				områdepladser.add(p);
			}
		}
		
		boolean found = false;
		int left = 0;
		int right = områdepladser.size() -1;
		Kamp plads = null;
		while(!found && left <= right) {
			int middle = (left+right) / 2;
			int nr = områdepladser.get(middle).getNr();
			
			if (nr == nummer) {
				found = true;
				plads =områdepladser.get(middle);
				
			}
			else if (nr > nummer) {
				right = middle -1;
			}
			else {
				left = middle + 1;
			}
		
		}
		if (found) {
			return plads;
		}
		
		else 
			return null;
	}
	
	public static int reservationsTidPåOmråde(Område område, LocalDateTime fra, LocalDateTime til) {
		
		ArrayList<Kamp> pladser = Storage.getPladser();
		ArrayList<Kamp> områdepladser = new ArrayList<>();
		
		int reserveretTid = 0;
		
		for (Kamp p: pladser) {
			if (p.getOmråde() == område) {
				områdepladser.add(p);
			}
		}
		
		for (int i = 0; i < områdepladser.size(); i++) 
		{
			reserveretTid += områdepladser.get(i).samletReservationstid(fra, til);
		}
		return reserveretTid;
	}

	public static void initStorage() {
		Kamp p1 = Controller.createPlads(1);
		p1.setOmråde(Område.TURNERING);
		Kamp p2 = Controller.createPlads(2);
		p2.setOmråde(Område.TURNERING);
		Kamp p3 = Controller.createPlads(3);
		p3.setOmråde(Område.STANDARD);
		Kamp p4 = Controller.createPlads(4);
		p4.setOmråde(Område.STANDARD);
		Kamp p5 = Controller.createPlads(5);
		p5.setOmråde(Område.BØRNE);

		Arrangement a1 = Controller.createArrangement("Dota 2", true);
		Arrangement a2 = Controller.createArrangement("CSGO", false);

		Reservation r1 = Controller.createReservation(LocalDateTime.of(2018, 8, 12, 20, 00),
				LocalDateTime.of(2018, 8, 12, 23, 00));
		Controller.addReservationTilPlads(p1, r1);
		Controller.addReservationTilPlads(p2, r1);
		Controller.addReservationTilArrangement(a1, r1);

		Reservation r2 = Controller.createReservation(LocalDateTime.of(2018, 8, 13, 19, 00),
				LocalDateTime.of(2018, 8, 14, 06, 00));

		r2.addPlads(p3);
		r2.addPlads(p4);

		Reservation r3 = Controller.createReservation(LocalDateTime.of(2018, 8, 14, 19, 00),
				LocalDateTime.of(2018, 8, 15, 06, 00));

		Kamp kp1 = Controller.createKonsolplads(1, "PS 4");
		Kamp kp2 = Controller.createKonsolplads(2, "XBOX ONE");

	}
}