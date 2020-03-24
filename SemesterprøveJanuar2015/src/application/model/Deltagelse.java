package application.model;

public class Deltagelse {
	private boolean afbud;
	private String begrundelse;
	private Spiller spiller;
	
	 Deltagelse(boolean afbud, String begrundelse, Spiller spiller) {
		this.afbud = afbud;
		this.begrundelse = begrundelse;
		this.spiller = spiller;
		this.spiller.addDeltagelse(this);
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

	public Spiller getSpiller() {
		return spiller;
	}

	public void setSpiller(Spiller spiller) {
		if (this.spiller != spiller) {
			Pre.require(this.spiller == null);
			this.spiller = spiller;
			spiller.addDeltagelse(this);
		}
	}
		public void setSpillerNull()
		{
			if (this.spiller != null) {
				Spiller oldSpiller = this.spiller;
				this.spiller = null;
				oldSpiller.removeDeltagelse(this);
			}
		}
	
	public String toString() {
		return begrundelse + " " + spiller;
	}
	
	
}
