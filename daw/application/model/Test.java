package application.model;

public class Test {

	public static void main(String[] args) {
		
		Deltager et = new Deltager("Ole Jensen", "Jensen vej", "Århus", "eaa", true, 88887777, 22224444);
		Deltager to = new Deltager("Ole Wedel", "Jensen vej", "Århus", "eaa", true, 88887777, 22224444);
		Deltager tre = new Deltager("Ole Grim", "Jensen vej", "Århus", "eaa", true, 88887777, 22224444);
		
		Hotel hotel1 = new Hotel("Svanen", "jern 25", 3, true, true ,true);		
		hotel1.setBadPris(100);
		hotel1.setMadPris(200);
		hotel1.setWifiPris(500);
		
		
		
		Tilmelding en = new Tilmelding("1", "MarkHansen");
		Tilmelding two = new Tilmelding("2", null);
		Tilmelding three = new Tilmelding("3", "Jens");
		
		en.setHotel(hotel1);
	
		
		et.addTilmelding(en);
		et.addTilmelding(two);
		et.addTilmelding(three);
		et.printTilmeldinger();
		
		System.out.println(hotel1.getHotelPrice());
		
		System.out.println(en.getHotel().toString());
		
	}

}
