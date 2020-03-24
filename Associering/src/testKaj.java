public class testKaj {

	public static void main(String[] args) {
		Bil e = new Bil("Audi", "blå");
		Bil e2 = new Bil("Mercedes", "Sort");
		Prisgruppe a = new Prisgruppe();
		a.AddBilA(e);
		a.AddBilA(e2);
		a.printBilera();
		System.out.println(" -**");
		
		a.printSpecifikBila(e2);
		

	}

}
