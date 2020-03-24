package dicegames;

import java.util.Scanner;

/**
 * This class models one pair of dices.
 *
 */
public class PlayPairOfDices {
	/**
	 * The first die in the pair.
	 */
	private Die die1;
	private int roll1;
	private int roll2;
	/**
	 * The second die in the pair.
	 */
	private Die die2;

	private Scanner scan;

	private int numberofrolls = 0;
	private int numberofsixes = 0;
	private int numberofones = 0;
	private int numberoftwos = 0;
	private int numberofthrees = 0;
	private int numberoffours = 0;
	private int numberoffives = 0;
	private int numberofdoubles = 0;
	private int sum = 0;
	private int highestsum = 0;

	/**
	 * Constructor for objects of class PairOfDices
	 */
	public PlayPairOfDices() {
		die1 = new Die(6);
		die2 = new Die(6);
		scan = new Scanner(System.in);
	}

	private void welcomeToGame() {
		System.out.println("Velkommen til spillet KAST 2 terninger");
	}

	private void gameOver() {
		System.out.println("Hvor mange gange blev der slået 2 ens " + numberofdoubles + " gange");
		System.out.println("Det største kast har været " + highestsum + " øjne");
		System.out.println("Hvor mange 1'ere er der blevet slået " + numberofones);
		System.out.println("Hvor mange 2'ere er der blevet slået " + numberoftwos);
		System.out.println("Hvor mange 3'ere er der blevet slået " + numberofthrees);
		System.out.println("Hvor mange 4'ere er der blevet slået " + numberoffours);
		System.out.println("Hvor mange 5'ere er der blevet slået " + numberoffives);
		System.out.println("Hvor mange 6'ere er der blevet slået " + numberofsixes);
		scan.close();
	}

	public void rollBothDices() {
		// Opgave 1(1).
		die1.roll();
		this.roll1 = die1.getFaceValue();
		die2.roll();
		this.roll2 = die2.getFaceValue();
		numberofrolls++;
		if (this.roll1 == 6 && this.roll2 == 6) {
			numberofsixes = numberofsixes + 2;
		} else if (this.roll1 == 6 || this.roll2 == 6) {
			numberofsixes = numberofsixes + 1;
		}
		if (this.roll1 == 1 && this.roll2 == 1) {
			numberofones = numberofones + 2;
		} else if (this.roll1 == 1 || this.roll2 == 1) {
			numberofones = numberofones + 1;
		}
		if (this.roll1 == 2 && this.roll2 == 2) {
			numberoftwos = numberoftwos + 2;
		} else if (this.roll1 == 2 || this.roll2 == 2) {
			numberoftwos = numberoftwos + 1;
		}
		if (this.roll1 == 3 && this.roll2 == 3) {
			numberofthrees = numberofthrees + 2;
		} else if (this.roll1 == 3 || this.roll2 == 3) {
			numberofthrees = numberofthrees + 1;
		}
		if (this.roll1 == 4 && this.roll2 == 4) {
			numberoffours = numberoffours + 2;
		} else if (this.roll1 == 4 || this.roll2 == 4) {
			numberoffours = numberoffours + 1;
		}
		if (this.roll1 == 5 && this.roll2 == 5) {
			numberoffives = numberoffives + 2;
		} else if (this.roll1 == 5 || this.roll2 == 5) {
			numberoffives = numberoffives + 1;
		}
		if (roll1 == roll2) {
			numberofdoubles++;
		}
		if (roll1 + roll2 > highestsum) {
			highestsum = roll1 + roll2;
		}
		System.out.println("Du har kastet: " + roll1 + " og " + roll2);
	}

	public int sumofdices() {
		// Opgave 1(2).
		sum = roll1 + roll2;
		return sum;
	}

	public void resetpairofdice() {
		roll1 = 0;
		roll2 = 0;
		numberofrolls = 0;
		numberofsixes = 0;
		numberofones = 0;
		numberoftwos = 0;
		numberofthrees = 0;
		numberoffours = 0;
		numberoffives = 0;
		numberofdoubles = 0;
		sum = 0;
		highestsum = 0;
	}

	public int highestsum() {
		return highestsum;
	}

	public int numberofrolls() {
		return numberofrolls;
	}

	public int numberofsixes() {
		return numberofsixes;
	}

	public int numberoffives() {
		return numberoffives;
	}

	public int numberoffours() {
		return numberoffours;
	}

	public int numberofthrees() {
		return numberofthrees;
	}

	public int numberoftwos() {
		return numberoftwos;
	}

	public int numberofones() {
		return numberofones;
	}

	public int numberofdoubles() {
		return numberofdoubles;
	}

	public void startGame() {
		welcomeToGame();

		boolean finished = false;

		while (!finished) {
			System.out.println("Vil du kaste en terning? Angiv Ja eller Nej: ");
			String goOn = scan.nextLine();
			if (goOn.equalsIgnoreCase("Nej")) {
				finished = true;
			}
			else if(goOn.equalsIgnoreCase("ja")) {
				rollBothDices();
				}
			}
			gameOver();
		}
	}

