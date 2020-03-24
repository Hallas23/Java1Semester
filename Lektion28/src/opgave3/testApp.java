package opgave3;

import java.util.ArrayList;

public class testApp {
	
	public static void main(String[] args) {
	
	
	Ansat p1 = new Mekaniker("Jens", "Vej 29", true, 150, 86);
	Ansat p2 = new Værkfører("Ole", "Vej 23", 150, 85, true, 90, 100);
	Mekaniker p3 = new Syn("Ole", "Vej 23", true,  150, 85, 4);
	Ansat p4 = new Arbejdsdreng("Ole", "Vej 23", true,  150, 85);
	
	ArrayList<Ansat> ansatte = new ArrayList<>();
	
	ansatte.add(p1);
	ansatte.add(p2);
	ansatte.add(p3);
	ansatte.add(p4);
	
	for(Ansat m : ansatte) {
		System.out.println(m.getUgeløn() * 4);
	}

	
	
	
	}
}