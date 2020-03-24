package opgave2Teater;

import opgave1dobbelArray.DobbelArray;
import java.util.Scanner;

public class TheaterFloor {
	int[][] seats = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, 
					{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
					{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, 
					{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
					{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 }, 
					{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
					{ 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 }, 
					{ 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
					{ 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };
	String[] rækker = { "Række 1", "Række 2", "Række 3", "Række 4", "Række 5", "Række 6", "Række 7", "Række 8",
			"Række 9" };
	Scanner scan = new Scanner(System.in);

	/**
	 * Hvis plads seat på række row er ledig reserveres pladsen og prisen på pladsen
	 * returneres. Der returneres 0 hvis pladsen er optaget.
	 *
	 * @param row
	 * @param seat
	 * @return
	 */

	public int buySeat(int row, int seat) {
		int pris = 0;
		
		if(seats[row][seat] == 0) {
			return 0;
		} else {
			pris = seats[row][seat];
			seats[row][seat] = 0;
			return pris;
		}
		
	}

	/**
	 * Hvis der er en plads ledig med den pågældende pris, reserveres pladsen og
	 * prisen returneres. Der returneres 0, hvis der ikke er nogen pladser ledige
	 * til den pågældende pris.
	 *
	 * @param row
	 * @param seat
	 * @return
	 */
	public int buySeat(int price) {
		int pris;
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (price == seats[i][j]) {
					pris = seats[i][j];
					seats[i][j] = 0;
					return pris;
				}
			}
		}
		return 0;

	}

	public void printTheaterFloor() {
		
		
		
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats.length; j++) {
				System.out.print(" ");
				System.out.printf("%8d", seats[i][j]);
			}
			System.out.println();
		}
	}
	
}
