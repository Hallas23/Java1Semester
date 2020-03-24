package application.model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Parkeringsplads {
	private int nummer;
	private LocalTime ankomst;

	// aggregation: Parkeringsplads 0..* --<> 1 Parkeringshus
	private Parkeringshus hus;	

	// association: Parkeringsplads 0..* --> 0..1 Bil
	private Bil bil; // nullable

	public Parkeringsplads(int nummer, Parkeringshus hus) {
		this.nummer = nummer;
		this.ankomst = null;
		this.hus = hus;
	}

	@Override
	public String toString() {
		return String.format("Parkeringsplads[%s, %s]", nummer, ankomst);
	}

	public int getNummer() {
		return nummer;
	}

	public LocalTime getAnkomst() {
		return ankomst;
	}

	//-------------------------------------------------------------------------

	public Parkeringshus getParkeringsHus() {
		return hus;
	}

	/** Pre: Denne parkeringsplads er ikke forbundet til et andet parkeringshus. */
	public void setParkeringshus(Parkeringshus hus) {
		if (this.hus != hus) {
			Pre.require(this.hus == null);
			this.hus = hus;
			hus.addParkeringsplads(this);
		}
	}

	public void setParkeringshusNull() {
		if (this.hus != null) {
			Parkeringshus hus = this.hus;
			this.hus = null;
			hus.removeParkeringsplads(this);
		}
	}

	//-------------------------------------------------------------------------

	/** Note: Nullable return value. */
	public Bil getBil() {
		return bil;
	}

	/** Note: Bilen er ikke null. */
	public void setBil(Bil bil) {
		if (this.bil != bil) {
			this.bil = bil;
			this.ankomst = LocalTime.now();
		}
	}

	//-------------------------------------------------------------------------

	// Del af S4 (10 p)
	public int pris(LocalTime afgangstidspunkt) {
		int prisPr10min = 6; // kr
		int varighed = (int) ankomst.until(afgangstidspunkt, ChronoUnit.MINUTES);
//		int varighed1 = (int) ChronoUnit.MINUTES.between(ankomst, afgangstidspunkt);
		if (varighed % 10 == 0)
			return varighed / 10 * prisPr10min;
		else
			return (varighed / 10 + 1) * prisPr10min;
	}

	//-------------------------------------------------------------------------

	// Del af S5 (8 p)
	public void hentBil(LocalTime afgangstidspunkt) {
		hus.setSaldo(hus.getSaldo() + this.pris(afgangstidspunkt));
		bil = null;
	}
}
