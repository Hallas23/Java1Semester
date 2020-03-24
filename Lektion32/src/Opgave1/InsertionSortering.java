package Opgave1;

import java.util.ArrayList;

public class InsertionSortering {

	public static void insertioneSort(String[] list) {
		for (int i = 1; i < list.length; i++) {
			String next = list[i];
			int j = i;
			boolean found = false;
			while (!found && j > 0) {
				if (next.compareTo(list[j - 1]) > 0) {
					found = true;
				} else {
					list[j] = list[j - 1];
					j--;
				}
			}
			list[j] = next;
		}
	}

	public static void indsætKunde(ArrayList<Customer> list, Customer customer) {
		boolean found = false;
		int i = 0;

		while (!found && i < list.size()) {
			if (i== 0 && list.get(i).compareTo(customer) >= 0) {
				found = true;
				list.add(i, customer);
			}
			
			else if (i== list.size() -1 ){
				found = true;
				list.add(customer);
			}
			
			else if (list.get(i + 1).compareTo(customer) >= 0) {
				found = true;
				list.add(i+1, customer);
			}
			i++;
		}

	}
	
	public static void indsætKundeArray(Customer[] list, Customer customer) {
		boolean found = false;
		int j = list.length - 1;

		while (!found &&  j > 0) {
			if (list[j] !=null && customer.compareTo(list[j - 1]) >= 0) {
				found = true;
			}
				else {
					list[j] = list[j - 1];
					j--;
				}
		}
		list[j] = customer;
	}
}
