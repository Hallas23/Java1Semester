package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {
	private String navn;
	private LocalDate startDato;
	private LocalDate slutDato;
	private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

	public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
		this.navn = navn;
		this.startDato = startDato;
		this.slutDato = slutDato;
	}

	public String getNavn() {
		return navn;
	}

	public LocalDate getStartDato() {
		return startDato;
	}

	public LocalDate getSlutDato() {
		return slutDato;
	}

	public ArrayList<Bestilling> getBestillinger() {
		return new ArrayList<>(bestillinger);
	}

	public Bestilling createBestilling(LocalDate dato, Kunde kunde, Forestilling forestilling) {
		Bestilling bestilling = new Bestilling(dato, kunde, this);
		bestillinger.add(bestilling);
		return bestilling;
	}

	public int antalBestiltePladserPåDag(LocalDate dato) {
		int antalpladser = 0;
		for (Bestilling b : bestillinger) {
			if (b.getDato().equals(dato)) {
				antalpladser += b.getPladser().size();
			}

		}
		return antalpladser;
	}

	public LocalDate succesDato() {
		int antalpladser = 0;
		LocalDate succesdato = null;
		for (Bestilling b : bestillinger) {
			if (b.getPladser().size() > antalpladser) {
				antalpladser = b.getPladser().size();
				succesdato = b.getDato();
			}
		}
		return succesdato;
	}
	
	public boolean erPladsLedig(int række, int nr, LocalDate dato) {
		boolean ledig = true;
		
		for (Bestilling b: bestillinger) {
			if (b.getDato().equals(dato)) {
				for (int i = 0; i < b.getPladser().size(); i++) {
					if((b.getPladser().get(i).getRække() == række) && (b.getPladser().get(i).getNr() == nr)) {
						ledig = false;
					}
				}
			}
		}
		return ledig;
	}
	public String toString() {
		return navn + " " + startDato + " " + slutDato ;
	}
}
