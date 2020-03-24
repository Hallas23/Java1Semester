package application.model;

/**
 * Mads, Ramsn og Simon
 */
import java.time.LocalDate;

public class Udflugt {
	private String beskrivelse;
	private String adresse;
	private LocalDate startTid;
	private int pris;
	private Konference konference;

	public Udflugt(String beskrivelse, String adresse, LocalDate startTid, int pris, Konference konference) {
		this.beskrivelse = beskrivelse;
		this.adresse = adresse;
		this.startTid = startTid;
		this.pris = pris;
		this.konference = konference;
		konference.addUdflugt(this);

	}
	
	public void setKonference(Konference konference) {
		this.konference = konference;
		konference.addUdflugt(this);
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public LocalDate getStartTid() {
		return startTid;
	}

	public void setStartTid(LocalDate startTid) {
		this.startTid = startTid;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public String getAdresse() {
		return adresse;
	}

	public LocalDate getFraDato() {
		return startTid;
	}

	
	public int getPris() {
		return pris;
	}
	
	public String toString() {
		return beskrivelse + " " + adresse + " " + startTid + " "  + " " + pris;
	}
	
	public Konference getKonference() {
		return konference;
	}

}