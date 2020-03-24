package application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import application.controller.Controller;

public class testApp {

	public static void main(String[] args) {
		Spiller s1 = new Spiller("Jane Hansen", 1999);
		Spiller s2 = Controller.createSpiller("Lene Hansen", 2000);
		Spiller s3 = Controller.createSpiller("Mette Petersen", 1999);
		
		Spiller s4 = Controller.createProfSpiller("Sofia Kjeldsen", 1999, 50);
		Spiller s5 = Controller.createProfSpiller("Maria Nielsen", 2000, 55);
		
		Kamp k1 = Controller.createKamp("1", LocalDate.of(2015, 1, 26), LocalTime.of(10, 30));
		Kamp k2 = Controller.createKamp("2", LocalDate.of(2015, 1, 26), LocalTime.of(11, 30));
		
		Kamp k3 = Controller.createKamp("3", LocalDate.of(2015, 1, 25), LocalTime.of(10, 30));
		Kamp k4 = Controller.createKamp("4", LocalDate.of(2015, 1, 27), LocalTime.of(10, 30));
		
		ArrayList<Kamp> kampe1 = new ArrayList<>();
		
		
		ArrayList<Kamp> kampe2 = new ArrayList<>();
		

		k1.createDeltagelse(true, "Fødselsdag", s1);
		k2.createDeltagelse(true, "Dårlig form", s4);
		
		k1.createDeltagelse(false, "", s2);
		k1.createDeltagelse(false, "", s3);
		k1.createDeltagelse(false, "", s4);
		k1.createDeltagelse(false, "", s5);
		
		k2.createDeltagelse(false, "", s1);
		k2.createDeltagelse(false, "", s2);
		k2.createDeltagelse(false, "", s3);
		k2.createDeltagelse(false, "", s5);
		
		
		String flettedekampe = (Controller.alleKampe(kampe1, kampe2).toString());
		System.out.println(flettedekampe);
		
		k1.spillerHonorar("C:/Users/Simon/Documents/kamp");
	}
}
