package opgave5;

import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		ArrayList<Vare> v = new ArrayList<>();
		Indkøbsvogn v1 = new Indkøbsvogn(v, "ads");
		
		Fødevarer fisk = new Fødevarer("Fiskefisk", "Fisk", 16, 7);
		ElAritkel lampe = new ElAritkel(4, "LampePære", "Lampe", 4);
		ElAritkel lampe1 = new ElAritkel(12, "LampePære", "Lampe", 4);
		Spiritus vodka = new Spiritus(100, "Vodka", "Vodka", 45);
		Spiritus rom = new Spiritus(80, "Rom", "Rom", 45);
		
		
		v1.addVare(fisk);
		v1.addVare(lampe);
		v1.addVare(lampe1);
		v1.addVare(vodka);
		v1.addVare(rom);
		
		System.out.println(fisk.beregnPrismedMoms());
		System.out.println(lampe.beregnPrismedMoms());
		System.out.println(lampe1.beregnPrismedMoms());
		System.out.println(vodka.beregnPrismedMoms());
		System.out.println(rom.beregnPrismedMoms());
		
		
		System.out.println(v1.samletPris());
		
		
	}

}
