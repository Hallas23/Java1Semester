import java.util.ArrayList;

public class Testapp {

	public static void main(String[] args) {
			
		Hus b1 = new Hus("JernVænget", 150, 1200);
		
		Hus b2 = new Sommerhus("Ferie vej 44", 56,2000,true);
		
		ArrayList<Hus> huse = new ArrayList<>();
		
		huse.add(b1);
		huse.add(b2);
		
		for(Hus h : huse) {
			System.out.println(h.beregnEjendomsværdi());
		}
	}

}
