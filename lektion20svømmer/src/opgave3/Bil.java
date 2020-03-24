package opgave3;

import java.util.ArrayList;

public class Bil {

	private String license;
	private double pricePerDay;
	private int purchaseYear;
	private final ArrayList<Værkstedsbesøg> besøgs = new ArrayList<>();

	public Bil(String inputLicense, int inputYear) {
		this.license = inputLicense;
		this.purchaseYear = inputYear;

	}
	// Alle setMetoderne

	public ArrayList<Værkstedsbesøg> getBesøg() {
		return new ArrayList<>(besøgs);
	}
	
	public Værkstedsbesøg createBesøg(String hændelse, int kmTal, String dato) {
		Værkstedsbesøg besøg = new Værkstedsbesøg(hændelse, kmTal, dato);
		besøgs.add(besøg);
		return besøg;
	}
	
	public void addVærkstedsbesøg(Værkstedsbesøg besøg) {
	if (!besøgs.contains(besøg)) {
	besøgs.add(besøg);
		}
	}
	
	public void removeVærkstedsbesøg(Værkstedsbesøg besøg) {
		if (besøgs.contains(besøg)) {
		besøgs.remove(besøg);
			}
		}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public void setName(String inputLicense) {
		license = inputLicense;
	}

	public void setPurchaseYear(int inputpurchaseYear) {
		purchaseYear = inputpurchaseYear;;
	}


	public String getLicense() {
		return license;
	}

	public int getYear() {
		return purchaseYear;
	}

	public void printBil() {
		System.out.println(license);
		System.out.println(purchaseYear);
	}
	
	public void printBesøg(int nr) {
			besøgs.get(nr).printBesøg(nr);
		
	}

}
