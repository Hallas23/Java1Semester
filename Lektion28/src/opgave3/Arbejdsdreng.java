package opgave3;

public class Arbejdsdreng extends Ansat {
	public Arbejdsdreng(String navn, String adresse, boolean ansat, double timeløn, int ole) {
		super(navn, adresse, ansat, timeløn);
	}
	
	public double getUgeløn() {
		return super.getTimeløn() * 25;
	}
}
