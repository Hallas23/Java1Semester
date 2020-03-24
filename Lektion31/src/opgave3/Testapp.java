package opgave3;

import java.util.ArrayList;

import Opgave1.opgave1;
import opgave2.Customer;
import opgave2.SelectionSort;

public class Testapp {

	public static void main(String[] args) {
		Customer c1 = new Customer("Egon", "Olsen", 23);
		Customer c2 = new Customer("Abe", "Jensen", 23);
		Customer c3 = new Customer("Egon", "Abe", 22);

		Customer[] list = { c1, c2, c3 };

		InsertionSortering.insertioneSortC(list);
		for (Customer m : list) {
			System.out.println(m);
		}

		String[] s = { "Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul",
				"Torkild" };

	}
}