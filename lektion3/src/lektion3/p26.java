package lektion3;

import java.util.Random;

public class p26 {

	public static void main(String[] args) {

		Random r = new Random();
		int q = r.nextInt(49) + 1;
		int w = r.nextInt(49) + 1;
		int e = r.nextInt(49) + 1;
		int u = r.nextInt(49) + 1;
		int t = r.nextInt(49) + 1;
		int y = r.nextInt(49) + 1;
		System.out.println("Dine lottotal er " + q + " " + w + " " + e + " " + u +  " " + t + " " + y);
	}

}
