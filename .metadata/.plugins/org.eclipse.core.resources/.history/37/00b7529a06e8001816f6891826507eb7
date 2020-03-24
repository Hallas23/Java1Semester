package application.model;

public class Hotel {
	private String navn;
	private String adresse;
	private int antalværelser;
	private boolean bad;
	private boolean mad;
	private	boolean wifi;
	private double pris;
	private double badpris;
	private double madpris;
	private double wifipris;



	
	public Hotel(String navn, String adresse, int antalværelser, boolean bad, boolean mad, boolean wifi) {
		this.navn = navn;
		this.adresse = adresse;
		this.antalværelser = antalværelser;
		this.bad = bad;
		this.mad = mad;
		this.wifi = wifi;
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

	public int getAntalværelser() {
		return antalværelser;
	}

	public void setAntalværelser(int antalværelser) {
		this.antalværelser = antalværelser;
	}

	public boolean getBad() {
		return bad;
	}

	public void setBad(boolean bad) {
		this.bad = bad;
	}

	public boolean getMad() {
		return mad;
	}

	public void setMad(boolean mad) {
		this.mad = mad;
	}

	public boolean getWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	
	public double getBadPris() {
		return badpris;
	}

	public void setBadPris(double badpris) {
		if(bad) {
		this.badpris = badpris;
		}
	}

	public double getMadPris() {
		return madpris;
	}

	public void setMadPris(double madpris) {
		if (mad) {
		this.madpris = madpris;
		}
	}

	public double getWifiPris() {
		return wifipris;
	}

	public void setWifiPris(double wifipris) {
		if (wifi) {
		this.wifipris = wifipris;
		}
	}
	
	public double getHotelPrice() {
		pris = getBadPris() + getWifiPris() + getMadPris();
		return pris;
	}
	
	public String toString() {
		return navn;
	}

}
