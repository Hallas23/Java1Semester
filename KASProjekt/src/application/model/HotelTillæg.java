package application.model;

/**
 * Mads, Ramsn og Simon
 */

public class HotelTillæg {
	private boolean bad = false;
	private boolean mad = false; 
	private boolean wifi = false;
	private String kommentar;

	public HotelTillæg(boolean bad, boolean mad, boolean wifi) {
		this.bad = bad;
		this.mad = mad;
		this.wifi = wifi;
	}

	public boolean isBad() {
		return bad;
	}

	public void setBad(boolean bad) {
		this.bad = bad;
	}

	public boolean isMad() {
		return mad;
	}

	public void setMad(boolean mad) {
		this.mad = mad;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}
}