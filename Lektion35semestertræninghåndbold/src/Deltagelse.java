
public class Deltagelse {

	private boolean afbud;
	private String begrundelse;
	private Spiller spiller;

	Deltagelse(boolean afbud, String begrundelse, Spiller spiller) {
		this.afbud = afbud;
		this.begrundelse = begrundelse;
		spiller.addDeltagelse(this);
	}

	public boolean isAfbud() {
		return afbud;
	}

	public void setAfbud(boolean afbud) {
		this.afbud = afbud;
	}

	public String getBegrundelse() {
		return begrundelse;
	}

	public void setBegrundelse(String begrundelse) {
		this.begrundelse = begrundelse;
	}

	public void setSpiller(Spiller spiller) {
		this.spiller = spiller;
		spiller.addDeltagelse(this);
	}

	public Spiller getSpiller() {
		return spiller;
	}

	public void deleteDeltagelseD() {
		if (this.spiller != null) {
			Spiller oldGroup = this.spiller;
			this.spiller = null;
			oldGroup..removeDeltagelseS(this);
		}
	}
}
