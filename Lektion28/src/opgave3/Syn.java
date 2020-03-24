package opgave3;

public class Syn extends Mekaniker {
	private int syn;
	private int tillæg;
	
	public Syn(String navn, String adresse, boolean ansat, int årsvendeprøve, int syn, int tillæg) {
		super(navn, adresse, ansat, årsvendeprøve, tillæg);
		this.syn = syn;
		this.tillæg = tillæg;
	}

	public int getSyn() {
		return syn;
	}

	public void setSyn(int syn) {
		this.syn = syn;
	}

	public int getTillæg() {
		return tillæg;
	}

	public void setTillæg(int tillæg) {
		this.tillæg = tillæg;
	}
	
	public double getUgeløn() {
		double værdi = 0;
		værdi = super.getUgeløn() + getSyn() * getTillæg();
		return værdi;
	}
}
