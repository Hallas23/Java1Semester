package konto;

public class Konto {
	
	private int	nr;
	private int saldo;
	private String kontotype;
	
	public Konto(String kontotype, int nr) {
		this.kontotype = kontotype;
		this.nr = nr;
	}
	
	public int getnr() {
		return nr;
	}
	
	public String getkontotype() {
		return kontotype;
	}
	
	public void indsætbeløb(int beløb) {
		saldo = saldo + beløb;
	}
	
	public int getbeløb() {
		return saldo;
	}
}
