package opgave1;

public class Test {

	public static void main(String[] args) {
		Rental olll = new Rental(1, 26, "07-11-2018");
		Rental olll2 = new Rental(1, 24, "07-11-2018");
		
		Bil hurtig = new Bil("1", 2002);
		olll.AddBil(hurtig);
		
		hurtig.addRental(olll);
		
		hurtig.addRental(olll2);
		
		Bil hurtig22 = new Bil("1", 2002);
		
		olll2.AddBil(hurtig22);
		
		olll2.AddBil(hurtig);
		
		
		System.out.println(hurtig.getRentals().toString());
		System.out.println(olll2.getBiler().toString());
		System.out.println(hurtig.største());
		
	}
}
