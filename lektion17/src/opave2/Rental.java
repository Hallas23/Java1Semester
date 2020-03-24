package opave2;

import java.time.LocalDate;


public class Rental {
	private int number;
	private int days;
	private double price;
	private LocalDate startDate;
	

	
	public Rental(int number, int days, double price, LocalDate startDate) {
		this.number = number;
		this.days = days;
		this.price = price;
		this.startDate = startDate;
	}
	public double getPricePrday() {
		double PricePrday = price / days;
		return PricePrday;
	}
	
	public void setDays(int days) {
		this.days = days;
	}
	
	public int getDays() {
		return days;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public LocalDate getEndDate() {
		LocalDate Enddate = startDate.plusDays(days);
		return Enddate;
	}
	
	public double getTotalPrice() {
		return price;
	}
	
}