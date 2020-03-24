package opgave4;

import java.time.LocalDate;

public class SvømmerApp {

	public static void main(String[] args) {
		Svømmer s = new Svømmer("Ole", LocalDate.of(2000, 06, 22), "FCF", 7.50 , 10.00 , 12.50);
//		Svømmer s1 = new Svømmer("Ole", LocalDate.of(2000, 06, 22), "FCF", 2.22);
		//Svømmer s2 = new Svømmer("Ole", LocalDate.of(2000, 06, 22), "FCF", 2.22);
		s.bedsteTid();
		
		s.gennemsnitAfTid();
		
		s.snitUdenDårligste();
		
		s.gennemsnitAfTid();
		
		
	}

}
