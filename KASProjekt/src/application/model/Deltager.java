package application.model;

/**
 * Mads, Ramsn og Simon
 */


public class Deltager {
	private String navn;
	private String adresse;
	private String by;
	private int alder;
	private String firmanavn;
	private boolean foredragsholder;
	private int telefonNr;
	private int firmatelefonNr;


	public Deltager(String navn, int alder, String adresse, String by, String firmanavn,
			 int telefonNr, int firmatelefonNr) {

		this.navn = navn;
		this.alder = alder;
		this.adresse = adresse;
		this.by = by;;
		this.firmanavn = firmanavn;
		this.telefonNr = telefonNr;
		this.firmatelefonNr = firmatelefonNr;
	}

	public void setAlder(int alder) {
		this.alder = alder;
	}

	public int getAlder() {
		return alder;
	}
	
	public String toString() {
		return navn + " " + adresse;
	}
	

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}


	public String getFirmanavn() {
		return firmanavn;
	}

	public void setFirmanavn(String firmanavn) {
		this.firmanavn = firmanavn;
	}

	public boolean isForedragsholder() {
		return foredragsholder;
	}

	public void setForedragsholder(boolean foredragsholder) {
		this.foredragsholder = foredragsholder;
	}

	public int getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(int telefonNr) {
		this.telefonNr = telefonNr;
	}

	public int getFirmatelefonNr() {
		return firmatelefonNr;
	}

	public void setFirmatelefonNr(int firmatelefonNr) {
		this.firmatelefonNr = firmatelefonNr;
	}
}
