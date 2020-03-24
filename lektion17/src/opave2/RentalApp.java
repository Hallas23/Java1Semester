package opave2;

import java.time.LocalDate;

public class RentalApp {

	public static void main(String[] args) {
		Rental r1 = new Rental(400, 20, 20000.00, LocalDate.of(2018, 10, 24));
		System.out.println(r1.getEndDate());
		System.out.println(r1.getPricePrday());
	}

}
