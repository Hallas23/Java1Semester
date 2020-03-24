package eksempel;

public class MedalsApp {

	public static void main(String[] args) {
		
		Medals medals = new Medals();		

		String[] countries = { "Canada", "Italy", "Germany", "Japan", "Kazakhstan", "Russia", "South Korea",
				"United States" };

		int[][] counts = { { 0, 3, 0 }, { 0, 0, 1 }, { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 1 }, { 3, 1, 1 }, { 0, 1, 0 },
				{ 1, 0, 1 } };
		
		medals.printMedals(countries, counts);

	}

}
