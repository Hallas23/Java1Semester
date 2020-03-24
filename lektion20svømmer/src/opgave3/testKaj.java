package opgave3;
public class testKaj {

	public static void main(String[] args) {
		Bil b1 = new Bil("license", 1000);
		Bil b2 = new Bil("license22", 2000);
		Bil b3 = new Bil("license22", 3000);
		Bil b4 = new Bil("license22", 4000);
		Bil b5 = new Bil("license22", 5000);
		
		b1.setPricePerDay(1000);
		b2.setPricePerDay(2000);
		b3.setPricePerDay(3000);
		b4.setPricePerDay(4000);
		b5.setPricePerDay(5000);
		
		
		Rental r1 = new Rental(1, 22, "02-11-2018");
		Rental r2 = new Rental(2, 100, "31-11-2018");
		Prisgruppe a = new Prisgruppe();
		
		
		
		r1.AddBil(b1);
		r1.AddBil(b2);
		
		r2.AddBil(b5);
		
		System.out.println(r1.getPrice(b2));
		System.out.println(r2.getPrice(b5));
		b1.createBesøg("Kørt i grøften", 23456, "05-11-2018");
		b1.createBesøg("Kørt i grøften", 6666, "05-11-2018");
		b1.createBesøg("Kørt i grøften", 99999, "05-11-2018");
		b1.createBesøg("Kørt ind i et hegn", 10000, "13-11-2018");
		b1.printBesøg(3);
		
		a.AddBilA(b1);
		a.AddBilA(b2);
		a.AddBilA(b3);
		a.AddBilA(b4);
		a.printBilera();
		
		System.out.println(r1.getPrice(b3));



		
		
		
		
		
		

	}

}
