package tidsregistrering;

public class Tid {

	private int projektnr;
	private String navn;
	private String deadline;
	private String estimat;
	private String beskrivelse;
	private int medarbejder;
	
	public Tid(String navn, int projektnr, String beskrivelse, String deadline, String estimat, int medarbejder) {
		this.navn = navn;
		this.deadline = deadline;
		this.estimat = estimat;
		this.beskrivelse = beskrivelse;
		this.medarbejder = medarbejder;
		
	}
		
	public void addmedarbejder(int antal) {
			medarbejder = medarbejder + antal; 
		}
	
	public String getdeadline() {
		return deadline;
	}
	
	public int getprojektnr() {
		return projektnr;
	}
	
	public String getnavn() {
		return navn;
	}
	
	public String getestimat() {
		return estimat;
	}
	
	public String getbeskrivelse() {
		return beskrivelse;
	}
	
	public int getmedarbejder() {
		return medarbejder;
	}
 	
	

}
