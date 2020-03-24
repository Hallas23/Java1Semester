package ol;

public class Vareapp {

	public static void main(String[] args) {
		Vare slik = new Vare("Bolcher", 10.00);
		Vare.setMoms(0.25);
		System.out.println(slik.beregnPris());
		
		Vare slik2 = new Vare("Flødeboller", 15.00);
		System.out.println(slik2.beregnPris());
	}

}
