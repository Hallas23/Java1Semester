package lektion13;
import java.util.*;

public class Opgave1 {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Hans");
		names.add("Viggo");
		names.add("Jens");
		names.add("Bente");
		names.add("Bent");
		
	//	System.out.println(names.size());
		names.add(2, "Jane");
		//	System.out.println(names);
		names.remove(1);
		names.add(0, "Pia");
		names.add(names.size(), "Ib");
		System.out.println(names);
		
		
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i).length());
		}
	
		System.out.println("");
	
		for(String s: names) {
			System.out.println(s.length());
		}

	}
}