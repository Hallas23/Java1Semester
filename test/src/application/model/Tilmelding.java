package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Mads, Ramsn og Simon
 */

public class Tilmelding {
	private String navn;
	private String ledsagernavn;
	private boolean foredragsholder;

	private Hotel hotel;
	private Deltager deltager;
	private Konference konference;
	private ArrayList<Udflugt> udflugter = new ArrayList<>();
	private HotelTillæg hoteltillæg;
	private LocalDate ankomstdato;
	private LocalDate afrejsedato;
	private boolean seng;

	public Tilmelding(String navn, String ledsagernavn, boolean foredragsholder, boolean seng, Deltager deltager,
			Konference konference, LocalDate ankomstdato, LocalDate afrejsedato) {
		this.navn = navn;
		this.ledsagernavn = ledsagernavn;
		this.foredragsholder = foredragsholder;
		this.deltager = deltager;
		this.konference = konference;
		this.ankomstdato = ankomstdato;
		this.afrejsedato = afrejsedato;
		this.seng = seng;
		konference.addTilmelding(this);
	}

	public void setForedragsholder(boolean foredragsholder) {
		this.foredragsholder = foredragsholder;
	}

	public void setAnkomstdato(LocalDate ankomstdato) {
		this.ankomstdato = ankomstdato;
	}

	public void setAfrejsedato(LocalDate afrejsedato) {
		this.afrejsedato = afrejsedato;
	}

	public void setSeng(boolean seng) {
		this.seng = seng;
	}

	public boolean isSeng() {
		return seng;
	}

	public void setKonference(Konference konference) {
		this.konference = konference;
		konference.addTilmelding(this);
	}

	public Konference getKonference() {
		return konference;
	}

	public Deltager getDeltager() {
		return deltager;
	}

	public String getNavn() {
		return navn;
	}

	public boolean isForedragsholder() {
		return foredragsholder;
	}

	public String getLedsagernavn() {
		return ledsagernavn;
	}

	public void setLedsagernavn(String ledsagernavn) {
		this.ledsagernavn = ledsagernavn;
	}

	public String toString() {
		return deltager.getNavn() + " din pris er: " + getPris() + " kr";

	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		if (this.hotel != hotel) {
			this.hotel = hotel;
			hotel.addTilmelding(this);
		}
	}

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<>(udflugter);
	}

	public void addtUdflugt(Udflugt udflugt) {
		if (!udflugter.contains(udflugt))
			this.udflugter.add(udflugt);
	}

	public void removeUdflugt(Udflugt u) {
		if (udflugter.contains(u)) {
			this.udflugter.remove(u);
		}
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setHotelTillæg(HotelTillæg hoteltillæg) {
		this.hoteltillæg = hoteltillæg;
	}

	public void setDeltager(Deltager deltager) {
		if (this.deltager != deltager)
			this.deltager = deltager;
	}

	public double getPris() {
		double pris = 0;
		if (!udflugter.isEmpty()) {
			for (Udflugt udflugt : udflugter) {
				pris += udflugt.getPris();
			}
		}
		Long konferencetid = ChronoUnit.DAYS.between(ankomstdato, afrejsedato) + 1;
		Long hoteltid = ChronoUnit.DAYS.between(ankomstdato, afrejsedato);
		pris += konferencetid * 1500;
		HotelTillæg hoteltillæg = getHoteltillæg();

		if (hoteltillæg != null && hotel != null) {
			if (hoteltillæg.isBad()) {
				pris += hotel.getBadPris() * hoteltid;
			}
			if (hoteltillæg.isMad()) {
				pris += hotel.getMadPris() * hoteltid;
			}
			if (hoteltillæg.isWifi()) {
				pris += hotel.getWifiPris() * hoteltid;
			}

			pris += hoteltid * hotel.getPrisprdag();
			if (ledsagernavn != null || seng) {
				pris += hoteltid * hotel.getDobbeltseng();
			}
		}

		if (foredragsholder) {
			pris -= konferencetid * 1500;
		}
		return pris;
	}

	public HotelTillæg getHoteltillæg() {
		return hoteltillæg;
	}

	public LocalDate getAnkomstdato() {
		return ankomstdato;
	}

	public LocalDate getAfrejsedato() {
		return afrejsedato;
	}

}
