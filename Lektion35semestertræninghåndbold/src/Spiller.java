import java.util.ArrayList;

public class Spiller {
	private String navn;
	private int Årgang;

	private final ArrayList<Deltagelse> deltagere = new ArrayList<>();

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getÅrgang() {
		return Årgang;
	}

	public void setÅrgang(int årgang) {
		Årgang = årgang;
	}

	public ArrayList<Deltagelse> getDeltagere() {
		return new ArrayList<>(deltagere);
	}

	public void addDeltagelse(Deltagelse deltagelse) {
		if (!deltagere.contains(deltagelse)) {
			deltagere.add(deltagelse);
			deltagelse.setSpiller(this);
		}
	}
	
	public void deleteDeltagelse(Deltagelse deltagelse) {
		if (deltagere.contains(deltagelse)) {
			deltagere.remove(deltagelse);
			deltagelse.deleteDeltagelseD(this);
		}
	}

}
