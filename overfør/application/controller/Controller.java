package application.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import storage.Storage;
import application.model.*;

public class Controller {
	//laver en konference
	public static Konference createKonference(LocalDate startDato, LocalDate slutDato, String adresse, String beskrivelse) {
        Konference k = new Konference(startDato, slutDato, adresse, beskrivelse);
        Storage.addKonference(k);
        return k;
    }

    /**
     * Sletter konferencen.<br />
     */
    public static void deleteKonference(Konference k) {
        Storage.removeKonference(k);
    }

    /**
     * Henter alle konferencerne.
     */
    public static ArrayList<Konference> getKonference() {
        return Storage.getKonferencer();
    }
    
 // -------------------------------------------------------------------------
    
  //laver en deltager
  	public static Deltager createDeltager(String navn, int alder, String adresse, String by, String firmanavn,
			 int telefonNr, int firmatelefonNr) {
          Deltager d = new Deltager(navn, alder, adresse, by, firmanavn, telefonNr, firmatelefonNr);
          Storage.addDeltager(d);
          return d;
      }

      /**
       * Sletter en deltager
       */
      public static void deleteDeltager(Deltager d) {
          Storage.removeDeltager(d);
      }

      /**
       * Henter alle deltagerne.
       */
      public static ArrayList<Deltager> getDeltager() {
          return Storage.getDeltagere();
      }
      
   // -------------------------------------------------------------------------
      
      //laver et hotel
      public static Hotel createHotel(String navn, String adresse, int antalværelser, int badpris, int madpris, int wifipris) {
  		Hotel h = new Hotel(navn, adresse, antalværelser, badpris, madpris, wifipris);
  		Storage.addHotel(h);
  		return h;
  	}
      
  	//sletter et hotel
  	public static void deleteHotel(Hotel h) {
          Storage.removeHotel(h);
      }
  	
  	//henter hotellerne
  	public static ArrayList<Hotel> getHoteller() {
  		return Storage.getHoteller();
  	}
  	
 // -------------------------------------------------------------------------
  	
  //laver en udflugt
    public static Udflugt Udflugt(String beskrivelse, String adresse, LocalDateTime startTid, LocalDateTime slutTid, int pris) {
		Udflugt u = new Udflugt(beskrivelse, adresse, startTid, slutTid, pris);
		Storage.addUdflugt(u);
		return u;
	}
    
	//sletter en udflugt
	public static void deleteUdflugt(Udflugt u) {
        Storage.removeUdflugt(u);
    }
	
	//henter udflugterne
	public static ArrayList<Udflugt> getUdflugter() {
		return Storage.getUdflugter();
	}
	
	// -------------------------------------------------------------------------
	
	//laver et hoteltillæg
	public static HotelTillæg createHotelTillæg(boolean bad, boolean mad, boolean wifi) {
		HotelTillæg ht = new HotelTillæg(bad, mad, wifi);
		Storage.addHotelTillæg(ht);
		return ht;
	}
	
	//sletter et hotel tillæg
	public static void deleteHotelTillæg(HotelTillæg ht) {
        Storage.removeHotelTillæg(ht);
    }
	
	//henter hoteltillæg
	public static ArrayList<HotelTillæg> getHotelTillæg() {
		return Storage.getHotelTillæg();
	}
	
	// -------------------------------------------------------------------------
	
	//laver en tilmelding
		public static Tilmelding createTilmelding(String navn, String ledsagernavn, boolean foredragsholder, Deltager deltager, Konference konference) {
			Tilmelding t = new Tilmelding(navn, ledsagernavn, foredragsholder, deltager, konference);
			Storage.addTilmelding(t);
			return t;
		}
		
		//sletter en tilmelding
		public static void deleteTilmelding(HotelTillæg t) {
	        Storage.removeHotelTillæg(t);
	    }
		
		//henter tilmeldinger
		public static ArrayList<Tilmelding> getTilmeldinger() {
			return Storage.getTilmeldinger();
		}
  	
}