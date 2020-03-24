package opgave4;

import java.util.ArrayList;



public abstract class Figur {
	private String name;
	private int x;
	private int y;

	public Figur(String name, int x, int y) {
		this.name = name;
		this.y = y;
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract double udregnAreal();

	public static void AddX(ArrayList<Figur> list, int xp) {
		for (Figur m : list) {
			m.setX(m.getX() + xp);
			System.out.println(m.getX());
		}
	
	}
}
