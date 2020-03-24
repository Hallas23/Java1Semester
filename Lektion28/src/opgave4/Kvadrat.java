package opgave4;

public class Kvadrat extends Figur {
	private double sidelængde;

	public Kvadrat(String name, int x , int y, double sidelængde) {
		super(name, x, y);
		this.sidelængde = sidelængde;
	}

	public double getSidelængde() {
		return sidelængde;
	}

	public void setSidelængde(double sidelængde) {
		this.sidelængde = sidelængde;
	}
	
	public double udregnAreal() {
		return getSidelængde() * getSidelængde();
	}
	
	
}
