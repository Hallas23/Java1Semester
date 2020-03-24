	package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
	private LocalDate startDato;
	private LocalDate slutDato;
	private String beskrivelse;
	private String adresse;
	private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
	private ArrayList<Udflugt> udflugter = new ArrayList<>();
	private ArrayList<Hotel> hoteller = new ArrayList<>();
	
	public Konference(LocalDate startDato, LocalDate slutDato, String adresse, String beskrivelse) {
		this.startDato = startDato;
		this.slutDato = slutDato;
		this.adresse = adresse;
		this.beskrivelse = beskrivelse;
		
	}
	public String getBeskrivelse() {
		return beskrivelse;
	}

	public String getAdresse() {
		return adresse;
	}

	public LocalDate getFraDato() {
		return startDato;
	}

	public void setFraDato(LocalDate startDato) {
		this.startDato = startDato;
	}

	public LocalDate getTilDato() {
		return slutDato;
	}

	public void setTilDato(LocalDate slutDato) {
		this.slutDato = slutDato;
	}
	
	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<>(tilmeldinger);
	}

	public void removeTilmelding(int t)  {
			tilmeldinger.remove(t);
		
	}
	
	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<Udflugt>();
	}

	public void addUdflugt(Udflugt u) {
		if(!udflugter.contains(u)) {
			this.udflugter.add(u);
		}
	}

	public void removeUdflugt(Udflugt u) {
		if(udflugter.contains(u)) {
			this.udflugter.remove(u);
		}
	}
	
	public ArrayList<Hotel> getHoteller() {
		return new ArrayList<Hotel>();
	}

	public void addHotel(Hotel h) {
		if(!hoteller.contains(h)) {
			this.hoteller.add(h);
		}
	}

	public void removeHotel(Hotel h) {
		if(hoteller.contains(h)) {
			this.hoteller.remove(h);
		}
	}
}
