package application.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Kamp implements Comparable {
	private String sted;
	private LocalDate dato;
	private LocalTime tid;
	private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

	public Kamp(String sted, LocalDate dato, LocalTime tid) {
		this.sted = sted;
		this.dato = dato;
		this.tid = tid;
	}

	public String getSted() {
		return sted;
	}

	public LocalDate getDato() {
		return dato;
	}

	public LocalTime getTid() {
		return tid;
	}
	
	public void setSted(String sted) {
		this.sted = sted;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public void setTid(LocalTime tid) {
		this.tid = tid;
	}

	public ArrayList<Deltagelse> getDeltagelser() {
		return new ArrayList<>(deltagelser);
	}

	public Deltagelse createDeltagelse(boolean afbud, String begrundelse, Spiller spiller) {
		Deltagelse deltagelse = new Deltagelse(afbud, begrundelse, spiller);
		deltagelser.add(deltagelse);
		spiller.addDeltagelse(deltagelse);
		return deltagelse;
	}

	public void removeDeltagelse(Deltagelse deltager) {
		if (deltagelser.contains(deltager)) {
			deltagelser.remove(deltager);
		}
	}

	public ArrayList<String> afbud() {
		ArrayList<String> afbud = new ArrayList<>();
		for (Deltagelse d : deltagelser) {
			if (d.isAfbud()) {
				afbud.add(d.getSpiller().getNavn() + " " + d.getBegrundelse());
			}
		}
		return afbud;
	}

	@Override
	public int compareTo(Object o) {
		Kamp kamp = (Kamp) o;
		if (this.getDato().isBefore(kamp.getDato())) {
			return 0;
		}
		if (this.getDato().equals(kamp.getDato())) {
			if (this.getTid().isBefore(kamp.getTid())) {
				return 0;
			}
		}

		if (this.getDato().equals(kamp.getDato())) {
			if (this.getTid().equals((kamp.getTid()))) {
				if ((this.getSted().compareTo(kamp.getSted()) < 0)) {
					return 0;
				}
			}

		}
		return 1;
	}

	public void spillerHonorar(String tekstFil) {
		  try {
	            String fileName = tekstFil;
	            PrintWriter printWriter = new PrintWriter(fileName);
	            
	            
	            for (Deltagelse d : deltagelser) {
	    			if (!d.isAfbud()) {
	                printWriter.println(d.getSpiller().getNavn() + " " + d.getSpiller().kampHonorarforenkamp());
	    			}
	            }
	            
	            // flush og skriv filen
	            printWriter.flush();
	            printWriter.close();
	            System.out.println("Filen er lavet");
	        }
	        catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	

	public String toString() {
		return sted + " " + dato + " " + tid;
	}
	
}
