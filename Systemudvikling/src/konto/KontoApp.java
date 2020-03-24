package konto;

public class KontoApp {

	public static void main(String[] args) {
		Konto e = new Konto("Ung", 21);
		e.indsætbeløb(2500);
		e.indsætbeløb(2500);
		e.indsætbeløb(619);
		System.out.println(e.getbeløb());
		System.out.println(e.getnr());
		System.out.println(e.getkontotype());

	}

}
