package application.controller;

/**
 * Mads, Ramsn og Simon
 */
import java.time.LocalDate;
import java.util.ArrayList;

import storage.Storage;
import application.controller.Controller;
import application.model.*;

public class Controller {
	/**
	 * Initialiserer en konference og tilføjer den konference arrayet i storage.
	 * @param startDato
	 * @param slutDato
	 * @param adresse
	 * @param beskrivelse
	 * @return den nitialiseret konference
	 */
	public static Konference createKonference(LocalDate startDato, LocalDate slutDato, String adresse, String beskrivelse) {
        Konference konference = new Konference(startDato, slutDato, adresse, beskrivelse);
        Storage.addKonference(konference);
        return konference;
    }

    /**
     * Sletter en konference
     * @param konference
     * Pre: En konference skal være initialiseret.
     */
    public static void deleteKonference(Konference konference) {
        Storage.removeKonference(konference);
    }

    /**
     * Henter alle konferencerne fra konference arrayet i storage.
     * @return konference arrayet i storage.
     */
    public static ArrayList<Konference> getKonference() {
        return Storage.getKonferencer();
    }
    /**
     * Opdatere en konference vha. nye værdier i parameter.
     * @param konference
     * @param startDato
     * @param slutDato
     * @param adresse
     * @param beskrivelse
     * Pre: En konference skal være initialiseret.
     */
    public static void updateKonference(Konference konference, LocalDate startDato, LocalDate slutDato, String adresse, String beskrivelse) {
    	konference.setFraDato(startDato);
    	konference.setTilDato(slutDato);
    	konference.setAdresse(adresse);
    	konference.setBeskrivelse(beskrivelse);
    }
    
    
 // -------------------------------------------------------------------------
    
  /**
   * Initialiserer en deltager og tilføjer dem til deltager arrayet i storage.
   * @param navn
   * @param alder
   * @param adresse
   * @param by
   * @param firmanavn
   * @param telefonNr
   * @param firmatelefonNr
   * @return den initialiseret deltager
   */
  	public static Deltager createDeltager(String navn, int alder, String adresse, String by, String firmanavn,
			int telefonNr, int firmatelefonNr) {
          Deltager deltager = new Deltager(navn, alder, adresse, by, firmanavn, telefonNr, firmatelefonNr);
          Storage.addDeltager(deltager);
          return deltager;
      }

      /**
       * Sletter en deltager fra deltager arrayet i storage.
       * @param deltager
       * Pre: En deltager skal initialiseret.
       */
      public static void deleteDeltager(Deltager deltager) {
          Storage.removeDeltager(deltager);
      }

      /**
       * Henter alle deltagerne fra deltager arrayet i storage.
       * @return deltagerne fra arrayet i storage.
       */
      public static ArrayList<Deltager> getDeltager() {
          return Storage.getDeltagere();
      }
      
      /**
       * Opdater en deltager vha. nye værdier i parameter
       * @param deltager
       * @param navn
       * @param alder
       * @param adresse
       * @param by
       * @param firmanavn
       * @param telefonNr
       * @param firmatelefonNr
       * Pre: En deltager skal være initialiseret.
       */
      public static void updateDeltager(Deltager deltager, String navn, int alder, String adresse, String by,
				String firmanavn, int telefonNr, int firmatelefonNr) {
          deltager.setNavn(navn);
          deltager.setAlder(alder);
          deltager.setAdresse(adresse);
          deltager.setBy(by);
          deltager.setFirmanavn(firmanavn);
          deltager.setTelefonNr(telefonNr);
          deltager.setFirmatelefonNr(firmatelefonNr);
      }
      
   // -------------------------------------------------------------------------
      
      /**
       * Initialisere et hotel og tilføjer den til hotel arrayet i storage.
       * @param navn
       * @param adresse
       * @param prisprdag
       * @param dobbeltseng
       * @param badpris
       * @param madpris
       * @param wifipris
       * @param konference
       * @return det initialiseret hotel.
       * Pre: der skal være initialiseret et hotel.
       */
      public static Hotel createHotel(String navn, String adresse, int prisprdag, int dobbeltseng, int badpris, int madpris, int wifipris, Konference konference) {
  		Hotel hotel = new Hotel(navn, adresse, prisprdag, dobbeltseng, badpris, madpris, wifipris, konference);
  		Storage.addHotel(hotel);
  		return hotel;
  	}
      
  	/**
  	 * Sletter et hotel fra hotel arrayet i storage.
  	 * @param hotel
  	 * Pre: Hotellet skal være initialiseret.
  	 */
  	public static void deleteHotel(Hotel hotel) {
          Storage.removeHotel(hotel);
      }
  	
  	/**
  	 * Returnere arrayet med hoteller fra storage.
  	 * @return arrayet med hoteller fra storage.
  	 */
  	public static ArrayList<Hotel> getHoteller() {
  		return Storage.getHoteller();
  	}
  	
  	/**
  	 * Opdatere hotellet vha. nye værdier i parameter.
  	 * @param hotel
  	 * @param navn
  	 * @param adresse
  	 * @param prisprdag
  	 * @param dobbeltseng
  	 * @param badpris
  	 * @param madpris
  	 * @param wifipris
  	 * @param konference
  	 * Pre: hotel og konference skal være initialiseret.
  	 */
  	 public static void updateHotel(Hotel hotel, String navn, String adresse, int prisprdag, int dobbeltseng, int badpris, int madpris, int wifipris,Konference konference) {
         hotel.setNavn(navn);
         hotel.setAdresse(adresse);
         hotel.setPrisprdag(prisprdag);
         hotel.setDobbeltseng(dobbeltseng);
         hotel.setBadPris(badpris);
         hotel.setMadPris(madpris);
         hotel.setWifiPris(wifipris);
         hotel.setKonference(konference);
     }
  	 /**
  	  * Setter et hotel på en tilmelding
  	  * @param hotel
  	  * @param tilmelding
  	  * Pre: Hotel og tilmelding er initialiseret.
  	  */
  	public static void setHotel(Tilmelding tilmelding, Hotel hotel) {
   	 tilmelding.setHotel(hotel);
    }
  	
 // -------------------------------------------------------------------------
  	
  /**
   * Initialisere en udflugt og tilføjer den til udflugt arrayet i storage.
   * @param beskrivelse
   * @param adresse
   * @param startTid
   * @param pris
   * @param konference
   * @return den initialiseret udflugt.
   * Pre: en konference skal være oprettet.
   */
    public static Udflugt CreateUdflugt(String beskrivelse, String adresse, LocalDate startTid, int pris, Konference konference) {
		Udflugt udflugt = new Udflugt(beskrivelse, adresse, startTid, pris, konference);
		Storage.addUdflugt(udflugt);
		return udflugt;
	}
    
	/**
	 * Sletter en udflugt.
	 * @param udflugt
	 * Pre: en udflugt skal være initialiseret.
	 */
	public static void deleteUdflugt(Udflugt udflugt) {
        Storage.removeUdflugt(udflugt);
    }
	
	/**
	 * Returner arrayet med udflugter fra storage
	 * @return arrayet med udflugter fra storage
	 */
	public static ArrayList<Udflugt> getUdflugter() {
		return Storage.getUdflugter();
	}
	
	public static void addUdflugt(Tilmelding tilmelding, Udflugt udflugt) {
		tilmelding.addtUdflugt(udflugt);
	}
	
	/**
	 * Opdatere en udflugt vha. nye værdier i parameter.
	 * @param udflugt
	 * @param beskrivelse
	 * @param adresse
	 * @param startTid
	 * @param pris
	 * @param konference
	 * Pre: en udflugt og en konference er initialiseret.
	 */
	public static void updateUdflugt(Udflugt udflugt, String beskrivelse, String adresse, LocalDate startTid, int pris, Konference konference) {
		udflugt.setBeskrivelse(beskrivelse);
        udflugt.setAdresse(adresse);
        udflugt.setStartTid(startTid);
        udflugt.setPris(pris);
        udflugt.setKonference(konference);
	}
	
	// -------------------------------------------------------------------------
	
	/**
	 * Initialisere et hoteltillæg og tilføjer den til hotel arrayet i storage.
	 * @param bad
	 * @param mad
	 * @param wifi
	 * @return det initialiseret hotel
	 */
	public static HotelTillæg createHotelTillæg(boolean bad, boolean mad, boolean wifi) {
		HotelTillæg hotelt = new HotelTillæg(bad, mad, wifi);
		Storage.addHotelTillæg(hotelt);
		return hotelt;
	}
	
	/**
	 * Sletter et hoteltillæg fra hotel arrayet i storage.
	 * @param hotel
	 * Pre: et hoteltillæg er initialiseret.
	 */
	public static void deleteHotelTillæg(HotelTillæg hotel) {
        Storage.removeHotelTillæg(hotel);
    }
	
	/**
	 * Returner hoteltillæg arrayet i storage.
	 * @return hoteltillæg arrayet i storage.
	 */
	public static ArrayList<HotelTillæg> getHotelTillæg() {
		return Storage.getHotelTillæg();
	}
	
	/**
	 * Opdatere et hoteltillæg vha. nye værdier i parameter.
	 * @param hotelTillæg
	 * @param bad
	 * @param mad
	 * @param wifi
	 * Pre: et hoteltillæg skal være initialiseret.
	 */
	public static void updateHotelTillæg(HotelTillæg hotelTillæg, boolean bad, boolean mad, boolean wifi) {
		hotelTillæg.setBad(bad);
		hotelTillæg.setMad(mad);
		hotelTillæg.setWifi(wifi);
	}
	
	// -------------------------------------------------------------------------
	
	/**
	 * Initialisere en tilmelding og tilføjer den til tilmelding arrayet i storage.
	 * @param navn
	 * @param ledsagernavn
	 * @param foredragsholder
	 * @param seng
	 * @param deltager
	 * @param konference
	 * @param ankomstdato
	 * @param afrejsedato
	 * @return den initialiseret tilmelding.
	 * Pre: en deltager skal være initialiseret.
	 */
		public static Tilmelding createTilmelding(String navn, String ledsagernavn, boolean foredragsholder,boolean seng, Deltager deltager, Konference konference, LocalDate ankomstdato, LocalDate afrejsedato) {
			Tilmelding tilmelding = new Tilmelding(navn, ledsagernavn, foredragsholder, seng, deltager, konference, ankomstdato, afrejsedato);
			Storage.addTilmelding(tilmelding);
			return tilmelding;
		}
		
		/**
		 * Sletter en tilmelding fra tilmelding arrayet i storage.
		 * @param tilmelding
		 * Pre: en tilmelding skal være initialiseret.
		 */
		public static void deleteTilmelding(Tilmelding tilmelding) {
	        Storage.removeTilmelding(tilmelding);
	    }
		
		/**
		 * Returner tilmelding arrayet i storage.
		 * @return tilmelding arrayet i storage.
		 */
		public static ArrayList<Tilmelding> getTilmeldinger() {
			return Storage.getTilmeldinger();
		}
		
		/**
		 * Opdatere en tilmelding vha. nye værdier i parameter.
		 * @param tilmelding
		 * @param navn
		 * @param ledsagernavn
		 * @param foredragsholder
		 * @param seng
		 * @param deltager
		 * @param konference
		 * @param ankomstdato
		 * @param afrejsedato
		 * Pre: en tilmelding og konference skal være initialiseret.
		 */
		 public static void updateTilmelding(Tilmelding tilmelding, String navn, String ledsagernavn, boolean foredragsholder,boolean seng, Deltager deltager, Konference konference, LocalDate ankomstdato, LocalDate afrejsedato) {
	         tilmelding.setNavn(navn);
	         tilmelding.setLedsagernavn(ledsagernavn);
	         tilmelding.setForedragsholder(foredragsholder);
	         tilmelding.setSeng(seng);
	         tilmelding.setDeltager(deltager);
	         tilmelding.setKonference(konference);
	         tilmelding.setAnkomstdato(ankomstdato);
	         tilmelding.setAfrejsedato(afrejsedato);
	     }
		 
		 /**
		  * Setter hoteltillæg på en tilmelding.
		  * @param tilmelding
		  * @param hoteltillæg
		  * Pre: hoteltillæg og tilmelding er initialiseret.
		  */
		 public static void setHotelTillæg(Tilmelding tilmelding, HotelTillæg hoteltillæg) {
			 tilmelding.setHotelTillæg(hoteltillæg);
		 }
		 
		 /**
		  * Objekter der allerede er lavet.
		  */
		public static void initStorage() {
			Konference k1 = Controller.createKonference(LocalDate.of(2018, 11, 27), LocalDate.of(2018, 11, 29), "Herning", "Konference om Herning by");
			Hotel h1 = Controller.createHotel("Den hvide svane", " Åaalborg hvidevej 22", 1050, 200, 0, 0, 50, k1);
			Deltager d1 = Controller.createDeltager("Ole Jensen", 24, "Jensen vej", "Århus", "eaa",88887777, 22224444);
			Udflugt ud1 = Controller.CreateUdflugt("Trapholt", "Trapholt Kolding", (LocalDate.of(2018, 11, 27)), 200, k1);
			Tilmelding t1 = Controller.createTilmelding("Ole", null, false, true, d1, k1, LocalDate.of(2018, 11, 27), LocalDate.of(2018, 11, 29));
			HotelTillæg ht1 = Controller.createHotelTillæg(false, false, true);
			Udflugt ud2 = Controller.CreateUdflugt("Egeskov", "Egeskovvej 28", (LocalDate.of(2018, 11, 27)), 75, k1);
			t1.addtUdflugt(ud1);
			t1.setHotel(h1);
			t1.setHotelTillæg(ht1);
			t1.addtUdflugt(ud2);
			
		}
		/**
		 * Kalder på initStorage()
		 */
		public static void init() {

			initStorage();

		}
}

