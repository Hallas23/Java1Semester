package application.model;

import java.util.ArrayList;

public class HotelTillæg {
	private boolean bad;
	private boolean mad;
	private boolean wifi;
	private String kommentar;
	private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

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

	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<Tilmelding>();
	}

	public void addTilmelding(Tilmelding t) {
		this.tilmeldinger.add(t);
	}

	public void removeTilmelding(Tilmelding t) {
		this.tilmeldinger.remove(t);
	}
}