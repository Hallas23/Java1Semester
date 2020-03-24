package opgave4;

import java.util.ArrayList;

import opgave3.Ansat;

public class TestApp {

	public static void main(String[] args) {
		Figur f1 = new Elipse("e1", 5, 10, 5 ,10);
		Figur f2 = new Elipse("e1", 3, 10, 5 ,10);
		System.out.println(f1.udregnAreal());
		
		ArrayList<Figur> ansatte = new ArrayList<>();
		
		ansatte.add(f1);
		ansatte.add(f2);

		
		f1.AddX(ansatte, 200);
	}

}
