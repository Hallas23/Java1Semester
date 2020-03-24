package application.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import application.model.Kamp;
import application.model.Profspiller;
import application.model.Spiller;
import storage.Storage;

public class Controller {

	public static Kamp createKamp(String sted, LocalDate dato, LocalTime tid) {
		Kamp kamp = new Kamp(sted, dato, tid);
		Storage.addKamp(kamp);
		return kamp;
	}
	
	 public static void updateKamp(Kamp kamp, String sted, LocalDate dato, LocalTime tid) {
		kamp.setSted(sted);
		kamp.setDato(dato);
		kamp.setTid(tid);
    }

	public static Spiller createSpiller(String navn, int årgang) {
		Spiller spiller = new Spiller(navn, årgang);
		Storage.addSpiller(spiller);
		return spiller;
	}

	public static Spiller createProfSpiller(String navn, int årgang, int kampHonorar) {
		Spiller spiller = new Profspiller(navn, årgang, kampHonorar);
		Storage.addSpiller(spiller);
		;
		return spiller;
	}

	public static ArrayList<Kamp> alleKampe(ArrayList<Kamp> list1, ArrayList<Kamp> list2) {
		ArrayList<Kamp> flettedekampe = new ArrayList<>();
		int i1 = 0;
		int i2 = 0;
		
		while (i1 < list1.size() && i2 < list2.size()) {
			if (list1.get(i1).compareTo((list2.get(i2))) == 0) {
				flettedekampe.add(list1.get(i1));
				i1++;
			}
			else {
				flettedekampe.add(list2.get(i2));
				i2++;
			}
		}
		while (i1 < list1.size()) {
			flettedekampe.add(list1.get(i1));
			i1++;
		}
		
		while (i2 < list2.size()) {
			flettedekampe.add(list2.get(i2));
			i2++;
		}
		return flettedekampe;
	}

	public static void createSomeObjects() {
		Spiller s1 = Controller.createSpiller("Jane Hansen", 1999);
		Spiller s2 = Controller.createSpiller("Lene Hansen", 2000);
		Spiller s3 = Controller.createSpiller("Mette Petersen", 1999);

		Spiller s4 = Controller.createProfSpiller("Sofia Kjeldsen", 1999, 50);
		Spiller s5 = Controller.createProfSpiller("Maria Nielsen", 2000, 55);

		Kamp k1 = Controller.createKamp("Herning", LocalDate.of(2015, 1, 26), LocalTime.of(10, 30));
		Kamp k2 = Controller.createKamp("Ikast", LocalDate.of(2015, 1, 27), LocalTime.of(13, 30));

		k1.createDeltagelse(true, "Fødselsdag", s1);
		k2.createDeltagelse(true, "Dårlig form", s4);

		k1.createDeltagelse(false, "", s2);
		k1.createDeltagelse(false, "", s3);
		k1.createDeltagelse(false, "", s4);
		k1.createDeltagelse(false, "", s5);

		k2.createDeltagelse(false, "", s1);
		k2.createDeltagelse(false, "", s2);
		k2.createDeltagelse(false, "", s3);
		k1.createDeltagelse(false, "", s5);

	}

}