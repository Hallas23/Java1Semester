package tidsregistrering;

public class TidApp {

	public static void main(String[] args) {
		Tid e = new Tid("Systemudvikling", 22, "Vi koder", "12.30", "12,25", 22 );
		e.addmedarbejder(10);
		System.out.println(e.getdeadline());
		System.out.println(e.getbeskrivelse());
		System.out.println(e.getmedarbejder());
		System.out.println(e.getestimat());
		System.out.println(e.getnavn());
	}

}
