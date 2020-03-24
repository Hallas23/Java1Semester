package application.model;

import java.util.ArrayList;

public class Parkeringshus {
	private String adresse;

	// del af S5
	private int saldo;

	// aggregation: Parkeringshus 1 <>-- Parkeringsplads
	private ArrayList<Parkeringsplads> pladser = new ArrayList<>();

	public Parkeringshus(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return String.format("Parkeringshus[%s]", adresse);
	}

	public String getAdresse() {
		return adresse;
	}

	// del af S5
	public int getSaldo() {
		return saldo;
	}

	// del af S5
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	//-------------------------------------------------------------------------

	public ArrayList<Parkeringsplads> getParkeringsPladser() {
		return new ArrayList<>(pladser);
	}

	public Parkeringsplads opretParkeringsplads(int nummer) {
		Parkeringsplads plads = new Parkeringsplads(nummer, this);
		pladser.add(plads);
		return plads;
	}

	/** Parkeringspladsen er ikke forbundet til et andet parkeringshus. */
	public void addParkeringsplads(Parkeringsplads plads) {
		if (!pladser.contains(plads)) {
			pladser.add(plads);
			plads.setParkeringshus(this);
		}
	}

	public void removeParkeringsplads(Parkeringsplads plads) {
		if (pladser.contains(plads)) {
			pladser.remove(plads);
			plads.setParkeringshusNull();
		}
	}

	//-------------------------------------------------------------------------

	// S2 (4 p)
	public int antalLedigePladser() {
		int antal = 0;
		for (Parkeringsplads plads : pladser) {
			if (plads.getAnkomst() == null)
				antal++;
		}
		return antal;
	}

	//-------------------------------------------------------------------------

	// S3 (10 p)
	public int findPladsMedBil(String regNummer) {
		int i = 0;
		while (i < pladser.size()) {
			Parkeringsplads plads = pladser.get(i);
			if (plads.getBil() != null && plads.getBil().getRegNr().equals(regNummer)) {
				return plads.getNummer();
			}
			i++;
		}
		return -1;
	}

	//-------------------------------------------------------------------------

	// S9 (5 p)
	public int findAntalBiler(Bilmærke mærke) {
		int antal = 0;
		for (Parkeringsplads plads : pladser) {
			if (plads.getAnkomst() != null && plads.getBil().getBilMærke().equals(mærke))
				antal++;
		}
		return antal;
	}

	//-------------------------------------------------------------------------

	// S9 (5 p)
	public ArrayList<String> optagnePladser() {
		ArrayList<String> pladsInfos = new ArrayList<>();
		for (Parkeringsplads plads : pladser) {
			if (plads.getBil() != null) {
				String info = "Plads " + plads.getNummer() + ": "
						+ plads.getBil().getRegNr() + ", "
						+ plads.getBil().getBilMærke();
				pladsInfos.add(info);
			}
		}
		return pladsInfos;
	}

	//-------------------------------------------------------------------------

	// Bruges i GUI
	public Parkeringsplads findLedigPlads() {
		int i = 0;
		while (i < pladser.size()) {
			Parkeringsplads plads = pladser.get(i);
			if (plads.getBil() == null)
				return plads;
			i++;
		}
		return null;
	}
}
