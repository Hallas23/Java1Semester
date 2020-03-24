package application.model;

public class Indtag {
	private double vejetFørindtaglse;
	private double vejetEfterindtaglse;
	private String beskrivelse;
	private double anslåetAntalKalorier;
	
	Indtag(double vejetFørindtaglse, double vejetEfterindtaglse, String beskrivelse, double anslåetAntalKalorier) {
		this.vejetFørindtaglse = vejetFørindtaglse;
		this.vejetEfterindtaglse = vejetEfterindtaglse;
		this.beskrivelse = beskrivelse;
		this.anslåetAntalKalorier = anslåetAntalKalorier;
	}

	public double getVejetFørindtaglse() {
		return vejetFørindtaglse;
	}

	public void setVejetFørindtaglse(int vejetFørindtaglse) {
		this.vejetFørindtaglse = vejetFørindtaglse;
	}

	public double getVejetEfterindtaglse() {
		return vejetEfterindtaglse;
	}

	public void setVejetEfterindtaglse(int vejetEfterindtaglse) {
		this.vejetEfterindtaglse = vejetEfterindtaglse;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public double getAnslåetAntalKalorier() {
		return anslåetAntalKalorier;
	}

	public void setAnslåetAntalKalorier(int anslåetAntalKalorier) {
		this.anslåetAntalKalorier = anslåetAntalKalorier;
	}
	
	
	

}
