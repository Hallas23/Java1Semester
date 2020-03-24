package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

import controller.Controller;

public class TestApp {

	public static void main(String[] args) {
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
		Controller.addArrangementilTutor(t1, a2);
		Controller.addArrangementilTutor(t1, a3);
		Controller.addArrangementilTutor(t1, a4);
		
		System.out.println(Datamatiker.tutorOversigt());
		System.out.println(FINØ.tutorOversigt());

		
		
		
	}

}
