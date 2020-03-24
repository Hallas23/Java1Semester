package opgave5;

public class ElAritkel extends Vare {
	private int energi;
	
	public ElAritkel(double pris, String navn, String beskrivelse, int energi) {
		super(pris, navn, beskrivelse);
		this.energi = energi;
	}

	public int getEnergi() {
		return energi;
	}

	public void setEnergi(int energi) {
		this.energi = energi;
	}

	public double beregnPrismedMoms() {
		double original = super.getPris();
		double pris = 0;
		pris = super.getPris() *1.30;
		double moms = pris - super.getPris();
		if (moms < 3) {
			return original + 3;
		}
		else {
			return pris;
		}
	}
	
}
