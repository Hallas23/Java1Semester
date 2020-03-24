package application.model;

public class testApp {

	public static void main(String[] args) {
		Patient p1 = new Patient("jens Jensen", 98, 26);
		Patient p2 = new Patient("jens Hansen", 56.5, 38);

		
		Bestilling pm1 = new Bestilling("morgen", "Kat", p1);
		Bestilling pm2 = new Bestilling("middag", "Karen", p1);
		Bestilling pm3 = new Bestilling("aftens", "aimon", p1);
		
		pm1.createIndtag(290, 0, "Cornflakes", 850);
		pm1.createIndtag(100, 0, "Juice", 250);
		
		pm2.createIndtag(350, 100, "Leverpostej", 1250);
		pm2.createIndtag(150, 0, "Bacon", 600);
		
		
		
		System.out.println(pm3.compareTo(pm1));
		
		Patient.bubbleSort(p1.getMåltider());
		
		System.out.println(p1.getMåltider());

	
	}

}
