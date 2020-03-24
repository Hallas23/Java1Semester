package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Mads, Ramsn og Simon
 */

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

	public void addTilmelding(Tilmelding tilmelding) {
		if (!tilmeldinger.contains(tilmelding)) {
			tilmeldinger.add(tilmelding);
			tilmelding.setKonference(this);
		}
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public String toString() {
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

	public void removeTilmelding(Tilmelding tilmelding) {
		tilmeldinger.remove(tilmelding);

	}

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<>(udflugter);
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void addUdflugt(Udflugt u) {
		if (!udflugter.contains(u)) {
			udflugter.add(u);
			u.setKonference(this);
		}
	}

	public void removeUdflugt(Udflugt u) {
		if (udflugter.contains(u)) {
			udflugter.remove(u);
		}
	}

	public ArrayList<Hotel> getHoteller() {
		return new ArrayList<>(hoteller);
	}

	public void addHotel(Hotel hotel) {
		if (!hoteller.contains(hotel)) {
			hoteller.add(hotel);
			hotel.setKonference(this);

		}
	}

	public void removeHotel(Hotel h) {
		if (hoteller.contains(h)) {
			hoteller.remove(h);
		}
	}
}
