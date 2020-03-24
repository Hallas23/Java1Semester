package lektion5radiator;

public class Radiator {
	
	public int temperature;
	public int radiator1;
	public int radiator2;
	
	public Radiator() {
		radiator1 = 0;
	}
	
	public Radiator(int setradiator2) {
		radiator2 = setradiator2;
	}
	
	public double getradiator1() {
		return radiator1;
	}
	
	public double getradiator2() {
		return radiator2;
	}
	
	public void skruOp(int temperature) {
		this.radiator1 = radiator1 + temperature;
		this.radiator2 = radiator2 + temperature;
	}
	
	public void skruNed(int temperature) {
		this.radiator1 = radiator1 - temperature;
		this.radiator2 = radiator2 - temperature;
	}
	
	public void printRadiator() {
		System.out.println(radiator1);
		System.out.println(radiator2);
	}
}
