package opgave1;

import java.util.ArrayList;



public class Bil {

	private String license;
	private double pricePerDay;
	private int purchaseYear;
	private Rental rental;
	private final ArrayList<Rental> rentals = new ArrayList<>();

	public Bil(String inputLicense, int inputYear) {
		this.license = inputLicense;
		this.purchaseYear = inputYear;

	}
	// Alle setMetoderne

	public ArrayList<Rental> getBesøg() {
		return new ArrayList<>(rentals);
	}
	
	public void addRental(Rental rental) {
	if (!rentals.contains(rental)) {
		rentals.add(rental);
		rental.AddBil(this);
		}
	}
	
	public void removeRental(Rental rental) {
		if (rentals.contains(rental)) {
		rentals.remove(rental);
		rental.removeBil(this);
			}
		}
	public void setRental(Rental rental) {
		if (this.rental != rental) {
			this.rental = rental;
			rental.AddBil(this);
		}
	}
	
	public ArrayList<Rental> getRentals() {
		return new ArrayList<>(rentals);
	}

	public String toString() {
		System.out.println(purchaseYear);
		return license;
		
	}
	
	public int største() {
		int størst = 0;
		int days = 0;
		for (int i = 0; i < rentals.size(); i++) {
			days = rentals.get(i).getDays();
			if(days > størst) {
				størst = days;
			}
		}
		return størst;
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

	public void printbiler() {
		System.out.println(purchaseYear);
		System.out.println(license);
		
	}

}
