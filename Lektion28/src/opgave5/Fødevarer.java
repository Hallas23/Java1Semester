package opgave5;

public class Fødevarer extends Vare {
	private int dato;
	

	public Fødevarer(String beskrivelse, String navn, double pris, int dato) {
		super(pris, navn, beskrivelse);
		this.dato = dato;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}
	
	public double beregnPrismedMoms() {
		return super.getPris() *1.05;
	}
}
