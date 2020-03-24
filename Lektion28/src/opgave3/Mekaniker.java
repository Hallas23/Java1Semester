package opgave3;


public class Mekaniker extends Ansat {
	private int årsvendeprøve;

	
	public Mekaniker(String navn, String adresse, boolean ansat, int timeløn, int årsvendeprøve) {
		super(navn, adresse, ansat, timeløn);
		this.årsvendeprøve = årsvendeprøve;
	}
	
	public double getUgeløn() {
		return super.getTimeløn() * 37;
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

}
