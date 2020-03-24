package application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Arrangement {
	private String titel;
	private LocalDate date;
	private LocalTime startTid;
	private LocalTime slutTid;
	private double pris;
	
	public Arrangement(String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, double pris) {
		this.titel = titel;
		this.date = date;
		this.startTid = startTid;
		this.slutTid = slutTid;
		this.pris = pris;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getStartTid() {
		return startTid;
	}

	public void setStartTid(LocalTime startTid) {
		this.startTid = startTid;
	}

	public LocalTime getSlutTid() {
		return slutTid;
	}

	public void setSlutTid(LocalTime slutTid) {
		this.slutTid = slutTid;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}
	
	public String toString() {
		return titel + " " + date + " " +  startTid + " " + slutTid + "\n";
		
	}
}
