package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Test {

	public static void main(String[] args) {
		
		Deltager et = new Deltager("Ole Jensen", 24, "Jensen vej", "Århus", "eaa",  88887777, 22224444);
		Deltager to = new Deltager("Ole Wedel", 28, "Jensen vej", "Århus", "eaa", 88887777, 22224444);
		Deltager tre = new Deltager("Ole Grim", 32, "Jensen vej", "Århus", "eaa",  88887777, 22224444);
		
		Konference p = new Konference(LocalDate.of(2018, 11, 15), LocalDate.of(2018, 11, 19), "Herning", "Konference om Herning by");
		
		Hotel hotel1 = new Hotel("Svanen", "jern 25", 3, 200, 300, 400);		
		hotel1.setBadPris(100);
		hotel1.setMadPris(200);
		hotel1.setWifiPris(500);
		HotelTillæg tillægs = new HotelTillæg(false, true, false);
		
		Udflugt Herning = new Udflugt("Tur til Herning museum", "Herning", LocalDateTime.of(2018, 11, 15, 12, 30), LocalDateTime.of(2018, 11, 15, 16, 30), 300);

		Tilmelding t = new Tilmelding("nice", "nice2", false, tre, p);
		t.setHotel(hotel1);
		t.setHotelTillæg(tillægs);
		
		
		
		System.out.println(t.getPris());
		//System.out.println(en);
		
		
		System.out.println(p.getFraDato());
		
		p.removeTilmelding(0);
		System.out.println(p.getTilmeldinger());
	}

}
