package opgave4;

public class Elipse extends Cirkel {
	private double radius2;

	public Elipse(String name, int x, int y, double radius, double radius2) {
		super(name, x, y, radius);
		this.radius2 = radius2;
	}

	public double getRadius2() {
		return radius2;
	}

	public void setRadius2(double radius2) {
		this.radius2 = radius2;
	}
	
	public double udregnAreal() {
		return Math.PI * (super.getRadius() * getRadius2());
	}
	
	
}
