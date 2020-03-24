package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import application.model.Hold;
import application.model.Uddannelse;
import application.model.Tutor;
import application.model.Arrangement;
import storage.Storage;

public class Controller {

	public static Uddannelse createUddannelse(String navn) {
		Uddannelse uddannelse = new Uddannelse(navn);
		Storage.addUddannelse(uddannelse);
		return uddannelse;
	}

	public static Hold createHold(String betegnelse, String holdleder, Uddannelse uddannelse) {
		Hold hold = new Hold(betegnelse, holdleder, uddannelse);
		uddannelse.addHold(hold);
		return hold;
	}

	public static Tutor createTutor(String name, String email) {
		Tutor tutor = new Tutor(name, email);
		Storage.addTutor(tutor);
		return tutor;
	}

	public static Arrangement createArrangement(String titel, LocalDate date, LocalTime startTid, LocalTime slutTid,
			double pris) {
		Arrangement arrangement = new Arrangement(titel, date, startTid, slutTid, pris);
		Storage.addArrangement(arrangement);
		return arrangement;
	}

	public static void addTutortilHold(Tutor tutor, Hold hold) {
		hold.addTutor(tutor);
	}
	
	public static void addArrangementilTutor(Tutor tutor, Arrangement arrangement) {
		
		boolean overlap = false;
			for (int i = 0; i < tutor.getArrangementer().size(); i++) {
				if (
						!(
							tutor.getArrangementer().get(i).getSlutTid().isBefore(arrangement.getStartTid())
							|| tutor.getArrangementer().get(i).getStartTid().isAfter(arrangement.getSlutTid())
						) 
						&& tutor.getArrangementer().get(i).getDate().equals(arrangement.getDate())
					) 
					{
						overlap = true;
					}
				}
		if (!overlap) {
			tutor.addArrangement(arrangement);
		}
		
		if (overlap) {
			System.out.println("Tutoren har allerede et arrangement planlagt");
		}
	}
	
	public static ArrayList<Hold> holdUdenTutorer() {
		
		ArrayList<Uddannelse> uddannelser = Storage.getUddannelser();
		ArrayList<Hold> holdUdenTutore = new ArrayList<>();
		
		for (int i = 0; i < uddannelser.size(); i++) 
		{
			for (int j = 0; j < uddannelser.get(i).getHold().size(); j++)
			{
				if (uddannelser.get(i).getHold().get(j).getTutore().isEmpty())
				{
					holdUdenTutore.add(uddannelser.get(i).getHold().get(j));
				}
			}
		}
		return holdUdenTutore;
		
	}

	public static void initStorage() {
		Uddannelse Datamatiker = Controller.createUddannelse("DMU");
		Uddannelse FINØ = Controller.createUddannelse("FINØ");

		Hold d1 = Controller.createHold("1dmE17S", "Margrethe Dybdahl", Datamatiker);
		Hold d2 = Controller.createHold("1dmE17T", "Kristian Dorland", Datamatiker);
		Hold d3 = Controller.createHold("1dmE17U", "Kell Ørhøj", Datamatiker);
		Hold f1 = Controller.createHold("1fiE17B", "Karen Jensen", FINØ);

		Tutor t1 = Controller.createTutor("Anders Hansen", "aaa@students.eaaa.dk");
		Tutor t2 = Controller.createTutor("Peter Jensen", "ppp@students.eaaa.dk");
		Tutor t3 = Controller.createTutor("Niels Madsen", "nnn@students.eaaa.dk");
		Tutor t4 = Controller.createTutor("Lone Andersen", "lll@students.eaaa.dk");
		Tutor t5 = Controller.createTutor("Mads Miller", "mmm@students.eaaa.dk");

		Arrangement a1 = Controller.createArrangement("Rusfest", LocalDate.of(2017, 8, 31), LocalTime.of(18, 00),LocalTime.of(23, 30), 250);
		Arrangement a2 = Controller.createArrangement("Fodbold", LocalDate.of(2017, 8, 30), LocalTime.of(14, 00),LocalTime.of(17, 00), 100);
		Arrangement a3 = Controller.createArrangement("Brætspil", LocalDate.of(2017, 8, 29), LocalTime.of(18, 00),LocalTime.of(22, 00), 25);
		Arrangement a4 = Controller.createArrangement("Mindeparken", LocalDate.of(2017, 8, 30), LocalTime.of(18, 00),LocalTime.of(22, 00), 25);

		Controller.addTutortilHold(t1, d1);
		Controller.addTutortilHold(t4, d1);
		Controller.addTutortilHold(t2, d3);
		Controller.addTutortilHold(t3, d3);
		Controller.addTutortilHold(t5, f1);

		Controller.addArrangementilTutor(t1, a1);
		Controller.addArrangementilTutor(t2, a1);
		Controller.addArrangementilTutor(t5, a1);
		Controller.addArrangementilTutor(t3, a2);
		Controller.addArrangementilTutor(t3, a3);
		Controller.addArrangementilTutor(t4, a3);
		Controller.addArrangementilTutor(t1, a4);
		Controller.addArrangementilTutor(t5, a4);

	}

	// -------------------------------------------------------------------------

}
