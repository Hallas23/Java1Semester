package opgave1;

import java.util.ArrayList;

public class testApp {
	
	public static void main(String[] args) {
		
	Mekaniker p1 = new Mekaniker("Jens", "Vej 29", 150, 86);
	Mekaniker p2 = new Værkfører("Ole", "Vej 23", 150, 85, 90, 100);
	Mekaniker p3 = new Syn("Ole", "Vej 23", 150, 85, 4, 29);
	
	ArrayList<Mekaniker> mekanikere = new ArrayList<>();
	
	mekanikere.add(p1);
	mekanikere.add(p2);
	mekanikere.add(p3);
	
	for(Mekaniker m : mekanikere) {
		System.out.println(m.getUgeløn());
	}

	
	
	
	}
}