package application.model;

import java.awt.List;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import storage.Storage;

public class Kamp implements Comparable {
	private Område område;
	private int nr;
	private final ArrayList<Reservation> reservationer = new ArrayList<>();
	private static int pris = 50;

	public Kamp(int nr) {
		this.nr = nr;
	}

	public Område getOmråde() {
		return område;
	}

	public void setOmråde(Område område) {
		this.område = område;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public ArrayList<Reservation> getReservationer() {
		return new ArrayList<>(reservationer);
	}

	public void addReservation(Reservation reservation) {
		if (!reservationer.contains(reservation)) {
			reservationer.add(reservation);
			reservation.addPlads(this);
		}
	}

	public void removeReservation(Reservation reservation) {
		if (reservationer.contains(reservation)) {
			reservationer.remove(reservation);
			reservation.removePlads(this);
		}
	}

	public String toString() {
		return "" + område + " " + nr;
	}

	public double pris(int timer) {
		double standardPris = 50;
		double vipPris = 62.5;
		double børnePris = 40;
		double turneringsPris = 55;

		if (område == Område.STANDARD && this.getClass().equals((Konsolplads.class))) {
			standardPris = (standardPris * 1.25) * timer;
			return standardPris;
		}

		if (område == Område.VIP && this.getClass().equals((Konsolplads.class))) {
			vipPris = (vipPris * 1.25) * timer;
			return vipPris;
		}

		if (område == Område.BØRNE && this.getClass().equals((Konsolplads.class))) {
			børnePris = (børnePris * 1.10) * timer;
			return børnePris;
		}

		if (område == Område.TURNERING && this.getClass().equals((Konsolplads.class))) {
			turneringsPris = (turneringsPris * 1.25) * timer;
			return turneringsPris;
		}

		if (område == Område.STANDARD) {
			standardPris = standardPris * timer;
			return standardPris;
		}

		if (område == Område.VIP) {
			vipPris = vipPris * timer;
			return vipPris;
		}

		if (område == Område.BØRNE) {
			børnePris = børnePris * timer;
			return børnePris;
		}

		if (område == Område.TURNERING) {
			turneringsPris = turneringsPris * timer;
			return turneringsPris;
		}
		return 0;
	}

	public static int getStandardTimePris() {
		return pris;
	}

	public static void setPris(int pris) {
		Kamp.pris = pris;
	}

	@Override
	public int compareTo(Object o) {
		Kamp plads = (Kamp) o;
		if (nr == plads.getNr()) {
			return 0;
		}
		if (nr > plads.getNr()) {
			return 1;
		}
		
		if (nr < plads.getNr()) {
			return -1;
		}
		
		return 50;
	}

	public int samletReservationstid(LocalDateTime fra, LocalDateTime til) {
		
		int reserveretTid = 0;
		
		for (int i = 0; i < this.getReservationer().size(); i++)
		{
			LocalDateTime start = this.getReservationer().get(i).getStart();
			LocalDateTime slut = this.getReservationer().get(i).getSlut();
			
			int dtid = 0;
			
			if (start.isBefore(fra)) 
			{
				start = fra;
			}
			if (slut.isAfter(til))
			{
				slut = til;
			}
			
			dtid = (int) Duration.between(start, slut).toHours();
			
			if (dtid > 0)
			{
				reserveretTid += dtid;
			}
		}
		return reserveretTid;
		
	}
	
}
