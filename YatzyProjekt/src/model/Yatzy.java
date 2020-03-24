package model;

import java.util.Random;

public class Yatzy {
	// Face values of the 5 dice.
	// 1 <= values[i] <= 6.
	private int[] values = new int[5];

	// Number of times the 5 dice have been thrown.
	// 0 <= throwCount <= 3.
	private int throwCount = 0;

	// Random number generator.
	private Random random = new Random();

	public Yatzy() {
		//
	}

	/**
	 * Returns the 5 face values of the dice.
	 */
	public int[] getValues() {
		return values;
	}

	/**
	 * Sets the 5 face values of the dice. Req: values contains 5 face values in
	 * [1..6]. Note: This method is only meant to be used for test, and therefore
	 * has package visibility.
	 */
	void setValues(int[] values) {
		this.values = values;
	}

	/**
	 * Returns the number of times the 5 dice has been thrown.
	 */
	public int getThrowCount() {
		return throwCount;
	}

	/**
	 * Resets the throw count.
	 */
	public void resetThrowCount() {
		throwCount = 0;
	}

	/**
	 * Rolls the 5 dice. Only roll dice that are not hold. Req: holds contain 5
	 * boolean values.
	 */
	public void throwDice(boolean[] holds) {
		throwCount++;
		for (int i = 0; i < values.length; i++) {
			if (!holds[i])
				values[i] = random.nextInt(6) + 1;
		}
	}

	// -------------------------------------------------------------------------

	/**
	 * Returns all results possible with the current face values. The order of the
	 * results is the same as on the score board. Note: This is an optional method.
	 * Comment this method out, if you don't want use it.
	 */
	public int[] getResults() {
		int[] results = new int[15];
		for (int i = 0; i <= 5; i++) {
			results[i] = this.sameValuePoints(i + 1);
		}
		results[6] = this.onePairPoints();
		results[7] = this.twoPairPoints();
		results[8] = this.threeSamePoints();
		results[9] = this.fourSamePoints();
		results[10] = this.fullHousePoints();
		results[11] = this.smallStraightPoints();
		results[12] = this.largeStraightPoints();
		results[13] = this.chancePoints();
		results[14] = this.yatzyPoints();

		return results;
	}

	// -------------------------------------------------------------------------

	// Returns an int[7] containing the frequency of face values.
	// Frequency at index v is the number of dice with the face value v, 1 <= v
	// <= 6.
	// Index 0 is not used.
	private int[] calcCounts() {
		int[] calc = new int[7];
		for (int i = 0; i < values.length; i++) {
			calc[values[i]]++;
		}
		return calc;
	}

	/**
	 * Returns same-value points for the given face value. Returns 0, if no dice has
	 * the given face value. Requires: 1 <= value <= 6;
	 */
	public int sameValuePoints(int value) {
		int point= 0;
		for (int i = 0; i < values.length; i++) {
			if(values[i] == value) {
				point = point + value;
			}
		}
		return point;
	}

	/**
	 * Returns points for one pair (for the face value giving highest points).
	 * Returns 0, if there aren't 2 dice with the same face value.
	 */
	public int onePairPoints() {
		int[] o = calcCounts();
		for (int i = 6; i > 0; i--) {
			if (o[i] >= 2) {
				return 2 * i;
			}
		}
		return 0;
	}

	/**
	 * Returns points for two pairs (for the 2 face values giving highest points).
	 * Returns 0, if there aren't 2 dice with one face value and 2 dice with a
	 * different face value.
	 */
	public int twoPairPoints() {
		int points = 0;
		int tæller = 0;
		int[] o = calcCounts();
		for (int i = 6; i > 0; i--) {
			if (o[i] >= 2) {
				tæller++;
				points = points + 2 * i;
				if (tæller == 2) {
					return points;
				}
			}
		}
		return 0;
	}

	/**
	 * Returns points for 3 of a kind. Returns 0, if there aren't 3 dice with the
	 * same face value.
	 */
	public int threeSamePoints() {
		int[] o = calcCounts();
		for (int i = 6; i > 0; i--) {
			if (o[i] >= 3) {
				return 3 * i;
			}
		}
		return 0;
	}

	/**
	 * Returns points for 4 of a kind. Returns 0, if there aren't 4 dice with the
	 * same face value.
	 */
	public int fourSamePoints() {
		int[] o = calcCounts();
		for (int i = 6; i > 0; i--) {
			if (o[i] >= 4) {
				return 4 * i;
			}
		}
		return 0;
	}

	/**
	 * Returns points for full house. Returns 0, if there aren't 3 dice with one
	 * face value and 2 dice a different face value.
	 */
	public int fullHousePoints() {
		int points1 = 0;
		boolean f = false;
		int[] o = calcCounts();
		for (int i = 6; i > 0; i--) {
			if (o[i] == 3) {
				points1 = 3 * i;
				f = true;
				break;
			}
		}
		if(f)
			for (int j = 6; j > 0; j--) {
				if (o[j] == 2) {
					return 2 * j + points1;
			}
		}
		return 0;
}

	/**
	 * Returns points for small straight. Returns 0, if the dice are not showing
	 * 1,2,3,4,5.
	 */
	public int smallStraightPoints() {
		int[] o = calcCounts();	
		if (o[1] == 1 && o[2] == 1 && o[3] == 1 && o[4] == 1 && o[5] == 1) {
				return 15;
		}
		return 0;
	}

	/**
	 * Returns points for large straight. Returns 0, if the dice is not showing
	 * 2,3,4,5,6.
	 */
	public int largeStraightPoints() {
		int[] o = calcCounts();	
		if (o[2] == 1 && o[3] == 1 && o[4] == 1 && o[5] == 1 && o[6] == 1) {
				return 20;
		}
		return 0;
	}

	/**
	 * Returns points for chance.
	 */
	public int chancePoints() {
		int points = 0;
		for (int i = 0; i < values.length; i++) {
			points = points +values[i];
		}
		return points;
	}

	/**
	 * Returns points for yatzy. Returns 0, if there aren't 5 dice with the same
	 * face value.
	 */
	public int yatzyPoints() {
		int points = 50;
		int[] o = calcCounts();
		for (int i = 6; i > 0; i--) {
			if (o[i] == 5) {
				return points;
			}
		}
		return 0;
	}

}
