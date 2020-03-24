package opgave3;

public class Værkfører extends Ansat {
	
	private int årværkfører;
	private int tillæg;
	private int årsvendeprøve;

	
	
	public Værkfører(String navn, String adresse, double timeløn, int årsvendeprøve, boolean ansat, int årværkfører, int tillæg) {
		super(navn, adresse, ansat, timeløn);
		this.årsvendeprøve = årsvendeprøve;
		this.årværkfører = årværkfører;
		this.tillæg = tillæg;
	}

	public int getÅrsvendeprøve() {
		return årsvendeprøve;
	}

	public void setÅrsvendeprøve(int årsvendeprøve) {
		this.årsvendeprøve = årsvendeprøve;
	}

	public int getÅrværkfører() {
		return årværkfører;
	}

	public void setÅrværkfører(int årværkfører) {
		this.årværkfører = årværkfører;
	}

	public int getTillæg() {
		return tillæg;
	}

	public void setTillæg(int tillæg) {
		this.tillæg = tillæg;
	}
	
	
	public double getUgeløn() {
		double værdi = 0;
		værdi = super.getTimeløn()+ getTillæg() *37;
		return værdi;
	}
	
}
