package application.model;

import java.util.ArrayList;

public class Bestilling implements Comparable {
	private String navn;
	private String anretterNavn;
	private final ArrayList<Indtag> indtag = new ArrayList<>();
	private Patient patient;

	public Bestilling(String navn, String anretterNavn, Patient patient) {
		this.navn = navn;
		this.anretterNavn = anretterNavn;
		patient.addMåltid(this);
	}

	public String getNavn() {
		return navn;
	}

	public Indtag createIndtag(int vejetFørindtaglse, int vejetEfterindtaglse, String beskrivelse,
			int anslåetAntalKalorier) {
		Indtag indtaget = new Indtag(vejetFørindtaglse, vejetEfterindtaglse, beskrivelse, anslåetAntalKalorier);
		indtag.add(indtaget);
		return indtaget;
	}

	public void removeIndtag(Indtag indtaget) {
		if (indtag.contains(indtaget)) {
			indtag.remove(indtaget);
		}
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getAnretterNavn() {
		return anretterNavn;
	}

	public void setAnretterNavn(String anretterNavn) {
		this.anretterNavn = anretterNavn;
	}

	public void setPatient(Patient patient) {
		if (this.patient != patient) {
			Pre.require(this.patient == null);
			this.patient = patient;
			patient.addMåltid(this);
		}
	}

	public void setPatientNull() {
		if (this.patient != null) {
			Patient oldPatient = this.patient;
			this.patient = null;
			oldPatient.removeMåltid(this);
		}
	}
	
	public double beregnAntalKalorier() {
		double kalorier = 0;
		double temp = 0;
		double temp2 = 0;
		for (Indtag i: indtag) {
			if (i.getVejetEfterindtaglse() > 0) {
				
			temp = ((i.getVejetFørindtaglse() - i.getVejetEfterindtaglse()) / i.getVejetFørindtaglse() * 100);
			temp2 = ((i.getAnslåetAntalKalorier() * temp) / 100);
			kalorier = kalorier + temp2;
			}
			else {
				kalorier = kalorier + i.getAnslåetAntalKalorier();
			}
		}
		return kalorier;
	}
	
	public String toString() {
		return navn + " " + anretterNavn + " " + patient.getNavn();
	}

	@Override
	public int compareTo(Object o) {
		Bestilling måltid = (Bestilling) o;
		if (this.getAnretterNavn().compareTo(måltid.getAnretterNavn()) < 0) {
			return 0;
		}
		if (this.getAnretterNavn().equals(måltid.getAnretterNavn())) {
			if (this.getNavn().compareTo(måltid.getNavn()) < 0) {
			return 0;
			}
		}
	
		return 1;
	}
	
}