package application.model;


import java.time.LocalDateTime;

public class Udflugt {
	private String beskrivelse;
	private String adresse;
	private LocalDateTime startTid;
	private LocalDateTime slutTid;
	private int pris;

	public Udflugt(String beskrivelse, String adresse, LocalDateTime startTid, LocalDateTime slutTid, int pris) {
		this.beskrivelse = beskrivelse;
		this.adresse = adresse;
		this.startTid = startTid;
		this.slutTid = slutTid;

	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public String getAdresse() {
		return adresse;
	}

	public LocalDateTime getFraDato() {
		return startTid;
	}

	public void setFraDato(LocalDateTime startTid) {
		this.startTid = startTid;
	}

	public LocalDateTime getTilDato() {
		return slutTid;
	}

	public void setTilDato(LocalDateTime slutTid) {
		this.slutTid = slutTid;
	}
	
	public int getPris() {
		return pris;
	}
	
	public String toString() {
		return beskrivelse + " " + adresse + " " + startTid + " " + slutTid + " " + pris;
	}

}