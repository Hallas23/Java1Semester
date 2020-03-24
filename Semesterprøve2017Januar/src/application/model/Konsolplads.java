package application.model;

public class Konsolplads extends Kamp {
	private String type;

	public Konsolplads(int nr, String type) {
		super(nr);
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	public String toString() {
		return "Konsolplads " + this.getNr() + " "+ type;
	}
	
}
