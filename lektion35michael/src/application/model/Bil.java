package application.model;

public class Bil {
	private String regNr;

	// del af S8
	private Bilmærke mærke;

	public Bil(String regNr) {
		this.regNr = regNr;
	}

	@Override
	public String toString() {
		return String.format("Bil[%s, %s]", regNr, mærke);
	}

	public String getRegNr() {
		return regNr;
	}

	// del af S8
	public Bilmærke getBilMærke() {
		return mærke;
	}

	// del af S8
	public void setBilMærke(Bilmærke mærke) {
		this.mærke = mærke;
	}
}
