package dicegames;

import java.util.Scanner;

/**
 * This class models one pair of dices.
 *
 */
public class CrapsPlay {
	/**
	 * The first die in the pair.
	 */
	private Die die1;
	private int roll1;
	private int roll2;
	private int sum;
	private boolean lose = false;
	private boolean win = false;
	private int point;
	private int kast;
	private boolean play = true;
	private int wins = 0;
	private int loss = 0;

	/**
	 * The second die in the pair.
	 */
	private Die die2;

	private Scanner scan;

	/**
	 * Constructor for objects of class PairOfDices
	 */
	public CrapsPlay() {
		die1 = new Die(6);
		die2 = new Die(6);
		scan = new Scanner(System.in);
	}

	private void welcomeToGame() {
		System.out.println("");
		System.out.println("Velkommen til spillet Craps");
	}

	private void gameOver() {
		kast = 0;
		if (lose == true) {
			loss++;
			System.out.println("Du har tabt");
			System.out.println("");
			System.out.println("Vil du spille igen?, indtast Ja eller Nej");
			String goOn = scan.nextLine();
			if (goOn.equalsIgnoreCase("ja")) {
				play = true;
				lose = false;
				win = false;
				startGame();
			} else {
				play = false;
				System.out.println("Du har vundet " + wins + " spil");
				System.out.println("Du har tabt " + loss + " spil");
			}
			lose = false;
			win = false;
		}

		else if (win == true) {
			wins++;
			System.out.println("Du har vundet");
			System.out.println("");
			System.out.println("Vil du spille igen?, indtast Ja eller Nej");
			String goOn = scan.nextLine();
			if (goOn.equalsIgnoreCase("ja")) {
				play = true;
				lose = false;
				win = false;
				startGame();
			} else {
				play = false;
				System.out.println("Du har vundet " + wins + " spil");
				System.out.println("Du har tabt " + loss + " spil");
			}

		}
	}

	public void rollBothDices() {
		// Opgave 1(1).
		die1.roll();
		this.roll1 = die1.getFaceValue();
		die2.roll();
		this.roll2 = die2.getFaceValue();
		sum = roll1 + roll2;
		System.out.println("Du har kastet: " + roll1 + " og " + roll2);
		kast++;
	}

	public void startGame() {
		welcomeToGame();

		while (play == true) {
			System.out.println("Tryk enter for at kaste terningerne");
			String goOn = scan.nextLine();
			rollBothDices();
			if (sum == 7 || sum == 11) {
				win = true;
				gameOver();
			} else if (sum == 2 || sum == 3 || sum == 12) {
				lose = true;
				gameOver();
			} else if (sum == 4 || sum == 5 || sum == 6 || sum == 8 || sum == 9 || sum == 10) {
				if (kast == 1) {
					point = sum;
					System.out.println("Dit point er " + point);
				}
				while (play == true) {
					System.out.println("Tryk enter for at kaste terningerne igen");
					String gonn = scan.nextLine();
					rollBothDices();
					if (kast > 1 && point == sum) {
						win = true;
						gameOver();
					}
					if (kast > 1 && sum == 7) {
						lose = true;
						gameOver();

					}

				}
			}
		}
	}
}