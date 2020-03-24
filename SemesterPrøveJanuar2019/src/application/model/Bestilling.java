package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
	private LocalDate dato;
	private final ArrayList<Plads> pladser = new ArrayList<>();
	private Kunde kunde;
	private Forestilling forestilling;

	Bestilling(LocalDate dato, Kunde kunde, Forestilling forestilling) {
		this.dato = dato;
		kunde.addBestilling(this);
		this.forestilling = forestilling;
	}

	public LocalDate getDato() {
		return dato;
	}

	public void addPlads(Plads plads) {
		if (!pladser.contains(plads)) {
			pladser.add(plads);
		}
	}

	public void removePlads(Plads plads) {
		if (pladser.contains(plads)) {
			pladser.remove(plads);
		}
	}
	
	public void setKunde(Kunde kunde) {
		if (this.kunde != kunde) {
			Pre.require(this.kunde == null);
			this.kunde = kunde;
			kunde.addBestilling(this);
		}
	}

	public void setKundeNull() {
		if (this.kunde != null) {
			Kunde oldKunde = this.kunde;
			this.kunde = null;
			oldKunde.removeBestilling(this);
		}
	}

	public Forestilling getForestilling() {
		return forestilling;
	}
	
	public ArrayList<Plads> getPladser() {
		return new ArrayList<>(pladser);
	}
	
	public double samletPris() {
		double pris = 0;
		for (Plads p: pladser) {
			pris += p.getPris();
		}
		return pris;
	}
	
	public String toString() {
		return kunde.getNavn();
	}
}
