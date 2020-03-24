package opgave4;

public class Cirkel extends Figur {
	private double radius;

	public Cirkel(String name,int x, int y, double radius) {
		super(name, x, y);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double udregnAreal() {
		return Math.PI * (getRadius() * getRadius());
	}
	
	
}
