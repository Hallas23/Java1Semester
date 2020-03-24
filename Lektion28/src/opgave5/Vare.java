package opgave5;

public abstract class Vare {
private double pris;
private String navn;
private String beskrivelse;
	public Vare(double pris, String navn, String beskrivelse) {
		super();
		this.pris = pris;
		this.navn = navn;
		this.beskrivelse = beskrivelse;
	}
	public double getPris() {
		return pris;
	}
	public void setPris(double pris) {
		this.pris = pris;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public String getBeskrivelse() {
		return beskrivelse;
	}
	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
	public abstract double beregnPrismedMoms();
	
}