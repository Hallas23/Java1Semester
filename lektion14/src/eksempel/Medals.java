package eksempel;

public class Medals {

	public void printMedals(String[] countries, int[][] counts) {
		System.out.println("        Country    Gold  Silver  Bronze   Total");

		// Print countries, counts, and row totals
		for (int i = 0; i < counts.length; i++) {
			// Process the ith row
			System.out.printf("%15s", countries[i]);

			int total = 0;

			// Print each row element and update the row total
			for (int j = 0; j < counts[i].length; j++) {
				System.out.printf("%8d", counts[i][j]);
				total = total + counts[i][j];
			}

			// Display the row total and print a new line
			System.out.printf("%8d\n", total);
		}

	}
}
