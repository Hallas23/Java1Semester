package opgave3;

import java.util.ArrayList;

public abstract class Ansat extends Person {
	private boolean ansat;
	protected double timeløn;

	public Ansat(String navn, String adresse, boolean ansat, double timeløn) {
		super(navn, adresse);
		this.ansat = ansat;
		this.timeløn = timeløn;
	}

	public boolean isAnsat() {
		return ansat;
	}

	public void setAnsat(boolean ansat) {
		this.ansat = ansat;
	}

	public double getTimeløn() {
		return timeløn;
	}

	public void setTimeløn(int timeløn) {
		this.timeløn = timeløn;
	}

	public abstract double getUgeløn();



	public static int samletLoen(ArrayList<Ansat> list) {
		int værdi = 0;
		for (Ansat m : list) {
			værdi += m.getUgeløn();
		}
		return værdi;
	}
}
