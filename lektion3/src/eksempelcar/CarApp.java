package eksempelcar;

import java.awt.Color;

public class CarApp {

	public static void main(String[] args) {
		Car myCar = new Car("VW UP", "White");
		System.out.println(myCar.getBrand());
		myCar.setRegistrationNumber("AB 11 123");
		System.out.println(myCar.getRegistrationNumber());
		System.out.println(""); //Blank
		
		// Nye bil
		System.out.println("***************");
		Car audi = new Car("*Audi r8", "Black" + "*"); 
		System.out.println(audi.getBrand() + " " + audi.getColor());
		audi.setRegistrationNumber("*  NK 68 420" + "  *");
		System.out.println(audi.getRegistrationNumber());
		audi.setKm(47000);
		System.out.print("*  " + audi.getKm());
		System.out.println(" Km   *");
		System.out.println("***************");	
	 }
	}
