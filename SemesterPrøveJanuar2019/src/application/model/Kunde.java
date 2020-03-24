package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {
	private String navn;
	private String mobil;
	private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

	public Kunde(String navn, String mobil) {
		this.navn = navn;
		this.mobil = mobil;
	}

	public String getNavn() {
		return navn;
	}

	public String getMobil() {
		return mobil;
	}

	public void addBestilling(Bestilling bestilling) {
		if (!bestillinger.contains(bestilling)) {
			bestillinger.add(bestilling);
			bestilling.setKunde(this);
		}
	}

	public void removeBestilling(Bestilling bestiling) {
		if (bestillinger.contains(bestiling)) {
			bestillinger.remove(bestiling);
			bestiling.setKundeNull();
		}
	}

	public ArrayList<Bestilling> getBestillinger() {
		return new ArrayList<>(bestillinger);
	}

	public int BestiltePladserTilForestillingPåDag(Forestilling forestilling, LocalDate dato) {
		int antalpladser = 0;
		for (Bestilling b: bestillinger) {
			if (b.getForestilling() == forestilling) {
				if ((b.getDato().equals(dato))) {
					antalpladser += b.getPladser().size();

				}
			}
		}
		return antalpladser;
	}
	
	public String toString() {
		return navn + " " + mobil;
	}

}













