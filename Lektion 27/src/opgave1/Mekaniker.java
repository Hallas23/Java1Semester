package opgave1;

import java.util.ArrayList;

public class Mekaniker extends Person {
	private int timeløn;
	private int årsvendeprøve;

	
	public Mekaniker(String navn, String adresse, int timeløn, int årsvendeprøve) {
		super(navn, adresse);
		this.timeløn = timeløn;
		this.årsvendeprøve = årsvendeprøve;
	}

	
	public int getTimeløn() {
		return timeløn;
	}
	
	public int getUgeløn() {
		return timeløn * 37;
	}

	public void setTimeløn(int timeløn) {
		this.timeløn = timeløn;	
	}

	public int getÅrsvendeprøve() {
		return årsvendeprøve;
	}

	public void setÅrsvendeprøve(int årsvendeprøve) {
		this.årsvendeprøve = årsvendeprøve;
	}

	
	public static int samletLoen(ArrayList<Mekaniker> list) {
		int værdi = 0;
		for (Mekaniker m : list) {
			værdi +=  m.getUgeløn();
		}
		return værdi;
	}

}
