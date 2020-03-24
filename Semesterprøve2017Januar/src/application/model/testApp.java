package application.model;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

import application.controller.Controller;

public class testApp {

	public static void main(String[] args) {
		Kamp p1 = Controller.createPlads(1);
		p1.setOmråde(Område.TURNERING);
		Kamp p2 = Controller.createPlads(2);
		p2.setOmråde(Område.TURNERING);
		Kamp p3 = Controller.createPlads(3);	
		p3.setOmråde(Område.BØRNE);
		Kamp p4 = Controller.createPlads(4);
		p4.setOmråde(Område.BØRNE);
		Kamp p5 = Controller.createPlads(5);
		p5.setOmråde(Område.BØRNE);
		
		Arrangement a1 = Controller.createArrangement("Dota 2", true);
		Arrangement a2 = Controller.createArrangement("CSGO", false);
		
		Reservation r1 = Controller.createReservation(LocalDateTime.of(2018, 8, 12, 20, 00), LocalDateTime.of(2018, 8, 14, 23, 00));
		Controller.addReservationTilPlads(p1, r1);
		Controller.addReservationTilPlads(p2, r1);	
		Controller.addReservationTilArrangement(a1, r1);
		Controller.addReservationTilPlads(p5, r1);
		
		Reservation r2 = Controller.createReservation(LocalDateTime.of(2018, 8, 13, 19, 00), LocalDateTime.of(2018, 8, 14, 06, 00));
		
		r2.addPlads(p3);
		r2.addPlads(p4);
		
		Reservation r3 = Controller.createReservation(LocalDateTime.of(2018, 8, 10, 10, 00), LocalDateTime.of(2018, 8, 14, 14, 00));
		Reservation r4 = Controller.createReservation(LocalDateTime.of(2017, 8, 10, 10, 00), LocalDateTime.of(2017, 8, 14, 14, 00));
		p5.addReservation(r3);
		p5.addReservation(r4);
		p4.addReservation(r3);
		p4.addReservation(r4);
		
		Kamp kp1 = Controller.createKonsolplads(1, "PS 4");
		Kamp kp2 = Controller.createKonsolplads(2, "XBOX ONE");
		
		LocalDateTime tid1 = LocalDateTime.of(2018, 8, 13, 10, 00);
		LocalDateTime tid2 = LocalDateTime.of(2018, 8, 14, 16, 00);
		
		System.out.println(Controller.reservationsTidPåOmråde(Område.TURNERING, tid1, tid2));
		System.out.println(p5.samletReservationstid(tid1, tid2));
		
		
		
	}

}
