package lektion14;

public class TwodimArray {

	public static void main(String[] args) {

		int[][] antal = new int[5][3];

		for (int i = 0; i < antal.length; i++) {
			for (int j = 0; j < antal[i].length; j++) {
				antal[i][j] = j + 1;
				System.out.print(antal[i][j]);
			}
			System.out.println();
		}
	}
}