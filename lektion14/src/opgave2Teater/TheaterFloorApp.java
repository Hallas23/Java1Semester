package opgave2Teater;

import java.util.Scanner;

public class TheaterFloorApp {

	public static void main(String[] args) {
		TheaterFloor theater = new TheaterFloor();
		theater.buySeat(0, 0);
		theater.buySeat(0, 1);
		theater.buySeat(0, 2);
		theater.printTheaterFloor();
	}
}
