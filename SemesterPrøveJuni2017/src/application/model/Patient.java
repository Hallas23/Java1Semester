package application.model;

import java.util.ArrayList;

public class Patient {
	private String navn;
	private double vægt;
	private int vægtfaktor;
	private final ArrayList<Bestilling> måltider = new ArrayList<>();

	public Patient(String navn, double vægt, int vægtfaktor) {
		this.navn = navn;
		this.vægt = vægt;
		this.vægtfaktor = vægtfaktor;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public double getVægt() {
		return vægt;
	}

	public void setVægt(double vægt) {
		this.vægt = vægt;
	}

	public int getVægtfaktor() {
		return vægtfaktor;
	}

	public void setVægtfaktor(int vægtfaktor) {
		this.vægtfaktor = vægtfaktor;
	}

	public void addMåltid(Bestilling måltid) {
		if (!måltider.contains(måltid)) {
			måltider.add(måltid);
			måltid.setPatient(this);
		}
	}

	public void removeMåltid(Bestilling deltagelse) {
		if (måltider.contains(deltagelse)) {
			måltider.remove(deltagelse);
			deltagelse.setPatientNull();
		}

	}

	public ArrayList<Bestilling> getMåltider() {
		return new ArrayList<>(måltider);
	}

	public double beregnAnbefaletKalorierPerdag() {
		double anbefalet = vægt * vægtfaktor;
		return anbefalet;
	}

	public double beregnDagensAntalKalorier() {
		double kalorier = 0;
		for (Bestilling m : måltider) {
			kalorier = kalorier + m.beregnAntalKalorier();
		}
		return kalorier;
	}

	public double beregnProcentDagligAnbefalet() {
		double procent = 0;
		double anbefalet = this.beregnAnbefaletKalorierPerdag();
		procent = (this.beregnDagensAntalKalorier() / anbefalet) * 100;
		return procent;
	}

	public static void sortMåltider(ArrayList<Bestilling> list) {
		int min;

		for (int i = 0; i < list.size() - 1; i++) {
			min = i;
			for (int scan = i + 1; scan < list.size(); scan++)
				if (list.get(scan).compareTo(list.get(min)) < 0)
					min = scan;

			swap(list, min, i);

		}
	}

	private static void swap(ArrayList<Bestilling> list, int min, int i) {
		Bestilling temp = list.get(min);
		list.set(min, list.get(i));
		list.set(i, temp);
	}

	public static void insertionSort(ArrayList<Bestilling> list) 
	{	
		for (int index = 1; index < list.size(); index++) {
			Bestilling måltid = list.get(index);
			int position = index;
			// Shift larger values to the right
			while (position > 0 && list.get(position - 1).compareTo(måltid) > 0) {
				list.set(position, list.get(position - 1));
				position--;
			}
			list.set(position, måltid);
		}
	}
	
	public static void bubbleSort (ArrayList<Bestilling> data)
	{
	int position, scan;
	for (position = data.size() - 1; position >= 0; position--)
	{
	for (scan = 0; scan <= position - 1; scan++)
	if (data.get(scan).compareTo(data.get(scan+1)) > 0)
	swap (data, scan, scan+1);
	}
	}
	
}
