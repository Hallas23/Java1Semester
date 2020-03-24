package opgave1;


import java.util.ArrayList;



public class Rental {

	private int number;
	private int days;
	private String date;
	private final ArrayList<Bil> biler = new ArrayList<>();

	public Rental(int number, int days, String date) {
		this.number = number;
		this.days = days;
		this.date = date;
	}
	
	public ArrayList<Bil> getBiler() {
		return new ArrayList<>(biler);
	}
	
	public Bil createBil(String inputLicense, int inputYear) {
		Bil bil = new Bil(inputLicense, inputYear);
		this.AddBil(bil);
		return bil;
	}
	
	public void AddBil(Bil bil) {
			biler.add(bil);
			bil.addRental(this);
			
	}

	
	public void removeBil(Bil bil) {
		if (biler.contains(bil)) {
			biler.remove(bil);
		}
	}

	public String toString() {
		System.out.println(days);
		System.out.println(number);
		return date;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public double getPrice(Bil bil) {
		double price = bil.getPricePerDay() * days;
		return price;
	}
}
