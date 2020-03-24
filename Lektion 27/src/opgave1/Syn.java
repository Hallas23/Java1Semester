package opgave1;

public class Syn extends Mekaniker {
	private int syn;
	private int tillæg;
	
	public Syn(String navn, String adresse, int timeløn, int årsvendeprøve, int syn, int tillæg) {
		super(navn, adresse, timeløn, årsvendeprøve);
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
	
	public int getUgeløn() {
		int værdi = 0;
		værdi = super.getUgeløn() + getSyn() * getTillæg();
		return værdi;
	}
}
