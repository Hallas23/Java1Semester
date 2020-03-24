package opgave5;

import java.util.ArrayList;


public class Indkøbsvogn {
	public static ArrayList<Vare> indkøbsvogn = new ArrayList<>();
	private String navn;
	
	public Indkøbsvogn(ArrayList<Vare> indkøbsvogn, String navn) {
		super();
		this.navn = navn;
	}

	public ArrayList<Vare> getIndkøbsvogn() {
		return new ArrayList<>(indkøbsvogn);
	}

	public void addVare(Vare vare) {
		indkøbsvogn.add(vare);
	}
	
	public void removeVare(Vare vare) {
		if(indkøbsvogn.contains(vare)) {
			indkøbsvogn.remove(vare);
		}
	}
	
	public double samletPris() {
		ArrayList<Vare> list = indkøbsvogn;
		double pris = 0;
		for (Vare m : list) {
			System.out.println(m.getNavn());
			pris += m.beregnPrismedMoms();
		}
		return pris;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	
}
