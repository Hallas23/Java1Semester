import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class Kamp {

	private final ArrayList<Deltagelse> deltagere = new ArrayList<>();
	private String sted;
	private LocalDate dato;
	private LocalTime tid;

	public Kamp(String sted, LocalDate dato, LocalTime tid) {
		this.sted = sted;
		this.dato = dato;
		this.tid = tid;
	}

	public ArrayList<Deltagelse> getDeltagere() {
		return new ArrayList<>(deltagere);
	}

	public Deltagelse CreateDeltagelse(boolean afbud, String begrundelse, Spiller spiller) {
		Deltagelse deltager = new Deltagelse(afbud, begrundelse, spiller);
		deltagere.add(deltager);
		return deltager;
	}
	
	public void removeDeltagelse(Deltagelse deltagelse)  {
		deltagere.remove(deltagelse);
	}

	public String getSted() {
		return sted;
	}

	public void setSted(String sted) {
		this.sted = sted;
	}

	public LocalDate getDato() {
		return dato;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public LocalTime getTid() {
		return tid;
	}

	public void setTid(LocalTime tid) {
		this.tid = tid;
	}

}
