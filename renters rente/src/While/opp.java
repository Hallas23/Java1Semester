package While;

public class opp {

	public static void main(String[] args) {
		
		int balance = 20000;
		double rente = 1.05;
		int year = 40;
		int year2 = 40;
		int Årsløn = 436000;
		int år = 12;
		
		
		while (year > 0) {
			System.out.println("Din balance er " + balance * Math.pow(rente, year) + " efter " + year2 + " år" );
			year--;
			year2--;
		}
		
		System.out.println("Årslønnen er " + Årsløn + " Måndeslønnen er " + Årsløn / år);
	}

}
