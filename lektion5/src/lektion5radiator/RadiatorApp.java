package lektion5radiator;

public class RadiatorApp {

	public static void main(String[] args) {
		Radiator r = new Radiator(20);
		r.skruOp(20);
		r.skruNed(10);
		r.printRadiator();
	}

}
