package opgave5;

public class Spiritus extends Vare {
	private int alkohol;

	public Spiritus(double pris, String navn, String beskrivelse, int alkohol) {
		super(pris, navn, beskrivelse);
		this.alkohol = alkohol;
	}	

	public int getAlkohol() {
		return alkohol;
	}

	public void setAlkohol(int alkohol) {
		this.alkohol = alkohol;
	}
	
	public double beregnPrismedMoms() {
		double pris = 0;
		if (super.getPris() > 90) {
			return pris + super.getPris() * 2.20;
		}
		else {
			return pris + super.getPris() * 1.80;
		}
	}
	
}
