package opgave1;

public class Værkfører extends Mekaniker {
	
	public int årværkfører;
	public int tillæg;
	
	public Værkfører(String navn, String adresse, int timeløn, int årsvendeprøve, int årværkfører, int tillæg) {
		super(navn, adresse, timeløn, årsvendeprøve);
		this.årværkfører = årværkfører;
		this.tillæg = tillæg;
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
	
	@Override
	public int getUgeløn() {
		int værdi = 0;
		værdi = super.getUgeløn() + getTillæg() *37;
		return værdi;
	}
	
}
