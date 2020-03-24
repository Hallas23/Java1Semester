/**
 * 
 */
/**
 * @author Simon
 *
 */
package storage;

import java.util.ArrayList;

import application.model.*;

public class Storage {
	private static ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
	private static ArrayList<Deltager> deltagere = new ArrayList<>();
	private static ArrayList<Hotel> hoteller = new ArrayList<>();
	private static ArrayList<HotelTillæg> tillæg = new ArrayList<>();
	private static ArrayList<Konference> konferencer = new ArrayList<>();
	private static ArrayList<Udflugt> udflugter = new ArrayList<>();
	
	// -------------------------------------------------------------------------

		public static ArrayList<Tilmelding> getTilmeldinger() {
			return new ArrayList<Tilmelding>(tilmeldinger);
		}

		public static void addTilmelding(Tilmelding tilmelding) {
			tilmeldinger.add(tilmelding);
		}

		public static void removeTilmelding(Tilmelding tilmelding) {
			tilmeldinger.remove(tilmelding);
		}
		
		// -------------------------------------------------------------------------

		public static ArrayList<Deltager> getDeltagere() {
			return new ArrayList<Deltager>(deltagere);
		}

		public static void addDeltager(Deltager deltager) {
			deltagere.add(deltager);
		}

		public static void removeDeltager(Deltager deltager) {
			deltagere.remove(deltager);
		}
		
		// -------------------------------------------------------------------------

		public static ArrayList<Hotel> getHoteller() {
			return new ArrayList<Hotel>(hoteller);
		}

		public static void addHotel(Hotel hotel) {
			hoteller.add(hotel);
		}

		public static void removeHotel(Hotel hotel) {
			hoteller.remove(hotel);
		}	
		
		// -------------------------------------------------------------------------
		
		public static ArrayList<HotelTillæg> getHotelTillæg() {
			return new ArrayList<HotelTillæg>(tillæg);
		}

		public static void addHotelTillæg(HotelTillæg t) {
			tillæg.add(t);
		}

		public static void removeHotelTillæg(HotelTillæg t) {
			tillæg.remove(t);
		}	
		
		// -------------------------------------------------------------------------
		
		public static ArrayList<Konference> getKonferencer() {
			return new ArrayList<Konference>(konferencer);
		}

		public static void addKonference(Konference k) {
			konferencer.add(k);
		}

		public static void removeKonference(Konference k) {
			konferencer.remove(k);
		}
		
		// -------------------------------------------------------------------------
		
		public static ArrayList<Udflugt> getUdflugter() {
			return new ArrayList<Udflugt>(udflugter);
		}

		public static void addUdflugt(Udflugt u) {
			udflugter.add(u);
		}

		public static void removeUdflugt(Udflugt u) {
			udflugter.remove(u);
		}
}
