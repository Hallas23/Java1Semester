package lektion5bug;

public class BugApp {

	public static void main(String[] args) {
		Bug b = new Bug(10, 1);
		b.move();
		b.move();
		b.move();
		b.addirection(0);
		b.move();
		b.getposition();
		b.printBug();

	}

}
