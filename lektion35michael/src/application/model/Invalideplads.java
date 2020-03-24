package application.model;

import java.time.LocalTime;

public class Invalideplads extends Parkeringsplads {
	private double areal;

	public Invalideplads(int nummer, Parkeringshus hus, double areal) {
		super(nummer, hus);
		this.areal = areal;
	}

	public double getAreal() {
		return areal;
	}

	@Override
	public String toString() {
		return String.format("Invalideplads [%s, %s, areal=%.1f]",
				this.getNummer(), this.getAnkomst(), areal);
	}

	//-------------------------------------------------------------------------

	// Del af S4
	@Override
	public int pris(LocalTime afgang) {
		return 0;
	}
}
