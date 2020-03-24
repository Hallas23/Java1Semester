package application.model;

import java.util.ArrayList;

/**
 * Mads, Ramsn og Simon
 */

public class Hotel {
	private String navn;
	private String adresse;
	private int prisprdag;
	private int badpris;
	private int madpris;
	private int wifipris;
	private HotelTillæg hoteltillæg;
	private int dobbeltseng;
	private Konference konference;
	private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();


	public Hotel(String navn, String adresse, int prisprdag, int dobbeltseng, int badpris, int madpris, int wifipris, Konference konference) {
		this.navn = navn;
		this.adresse = adresse;
		this.badpris = badpris;
		this.madpris = madpris;
		this.wifipris = wifipris;
		this.prisprdag = prisprdag;
		this.dobbeltseng = dobbeltseng;
		konference.addHotel(this);
		
	}
	
	public void addTilmelding(Tilmelding tilmelding) {
		if (!tilmeldinger.contains(tilmelding)) {
			tilmeldinger.add(tilmelding);
			tilmelding.setHotel(this);
		}
	}
	
	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<>(tilmeldinger);
	}

	public void removeTilmelding(Tilmelding t)  {
			tilmeldinger.remove(t);
		
	}

	public Konference getKonference() {
		return konference;
	}

	public int getDobbeltseng() {
		return dobbeltseng;
	}
	
	public void setKonference(Konference konference) {
		this.konference = konference;
		konference.addHotel(this);
	}

	public int getPrisprdag() {
		return prisprdag;
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
	
	public void setDobbeltseng(int dobbeltseng) {
		this.dobbeltseng = dobbeltseng;
	}

	public int getBadPris() {
		return badpris;
	}

	public void setBadPris(int badpris) {
		this.badpris = badpris;
	}

	public int getMadPris() {
		return madpris;
	}

	public void setMadPris(int madpris) {
		this.madpris = madpris;
		
	}

	public int getWifiPris() {
		return wifipris;
	}

	public void setWifiPris(int wifipris) {
		this.wifipris = wifipris;
	}
	
	public String toString() {
		return navn + " " + " " + adresse + badpris;
	}
	
	public HotelTillæg getHoteltillæg() {
		return hoteltillæg;
	}

	public void setPrisprdag(int prisprdag) {
		this.prisprdag = prisprdag;
	}
}
