package application.model;


public class Tilmelding {
	private String navn;
	private String ledsagernavn;
	private boolean foredragsholder;
	private double pris;	
	private Hotel hotel;
	private Deltager deltager;
	private Udflugt udflugt;
	private HotelTillæg hoteltillæg;
	private Konference konference;
	


	Tilmelding(String navn, String ledsagernavn, boolean foredragsholder, Deltager deltager) {
		this.navn = navn;
		this.ledsagernavn = ledsagernavn;
		this.foredragsholder = foredragsholder;
		this.deltager = deltager;
		
		
	}

	public Konference getKonference() {
		return konference;
	}

	public void setKonference(Konference konference) {
		this.konference = konference;
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
		return deltager + "\n" + "Ledsager valgt : " + ledsagernavn + " Valg af udflugt : " + udflugt +  "\n" + hotel;
		
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	
	public void setHotel(Hotel hotel) {
		if(this.hotel != hotel) {
			this.hotel = hotel;
		}
	}
	
	public Udflugt getUdflugt() {
		return udflugt;
	}
	
	public void setUdflugt(Udflugt udflugt) {
		this.udflugt = udflugt;
	}
	
	public void setHotelTillæg(HotelTillæg hoteltillæg) {
		this.hoteltillæg = hoteltillæg;
	}
	
	
	
	public double getPris() {
		if (hoteltillæg.isBad()) {
			pris += hotel.getBadPris();
		}
		if(hoteltillæg.isMad()) {
			pris += hotel.getMadPris();
		}
		if(hoteltillæg.isWifi()) {
			pris += hotel.getWifiPris();
		}
		
//		pris += udflugt.getPris();
		
		
		return pris;
	}
	
	
}
