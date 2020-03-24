package opgave4;

public class Rektangel extends Kvadrat {
	private double sidelængde2;

	public Rektangel(String name, int x, int y, double sidelængde, double sidelængde2) {
		super(name, x, y, sidelængde);
		this.sidelængde2 = sidelængde2;
	}

	public double getSidelængde2() {
		return sidelængde2;
	}

	public void setSidelængde2(double sidelængde2) {
		this.sidelængde2 = sidelængde2;
	}
	
	public double udregnAreal() {
		return super.getSidelængde() * getSidelængde2();
	}
	
	
}