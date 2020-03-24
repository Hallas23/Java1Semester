package opgave2;

import java.util.ArrayList;

import Opgave1.opgave1;
import opgave2.Customer;
import opgave2.SelectionSort;

public class Testapp {

	public static void main(String[] args) {
		Customer c1 = new Customer("Egon", "Olsen", 23);
		Customer c2 = new Customer("Abe", "Jensen", 23);
		Customer c3 = new Customer("Egon", "Abe", 22);

		Customer[] c = {c1,c2,c3};
	    ArrayList<Customer> cA = new ArrayList<>();
	    cA.add(c1);
	    cA.add(c2);
	    cA.add(c3);
		
//		SelectionSort.selectionSort(c);
//		for (Customer m: c) {
//			System.out.println(m);
//		}
		SelectionSort.selectionSortList(cA);
		for (Customer m: cA) {
			System.out.println(m);
		}
	}

}
