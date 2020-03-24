package ol;

public class Vare {
	
	private double pris;
	private String navn;
	private static double moms;
	
	public Vare (String navn, double pris) {
		this.navn = navn;
		this.pris = pris;
	}
	
	public static void setMoms(double moms2) {
		moms = moms2;
	}
	
	public double beregnPris() {
		double prisMoms;
		prisMoms = pris*(1 + moms);
		return prisMoms;
	}
}