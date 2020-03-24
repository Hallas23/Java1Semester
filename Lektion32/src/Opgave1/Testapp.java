package Opgave1;

import java.util.ArrayList;


public class Testapp {

	public static void main(String[] args) {
		Customer c1 = new Customer("b", "Olsen", 23);
		Customer c2 = new Customer("c", "Jensen", 23);
		Customer c3 = new Customer("d", "JAbe", 22);
		
		Customer c4 = new Customer("a", "ol", 22);
		
		Customer[] theArray = new Customer[10];
		theArray[0] = c4;
		theArray[1] = c2;
		theArray[2] = c3;
		
		
		InsertionSortering.indsætKundeArray(theArray, c1);
		
		for (Customer m: theArray) {
			System.out.println(m);
		}
	}

}
