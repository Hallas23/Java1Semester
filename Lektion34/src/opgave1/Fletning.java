package opgave1;

import java.util.ArrayList;

public class Fletning {

		public static ArrayList<Customer> mergeAllCustomers(ArrayList<Customer> l1, ArrayList<Customer> l2) {
			ArrayList<Customer> result = new ArrayList<Customer>();
			int i = 0;
			int j = 0;
	
			while (i < l1.size() && j < l2.size()) {
				if (l1.get(i).compareTo(l2.get(j)) <= 0) {
					result.add(l1.get(i));
					i++;
				}
	
				else {
					result.add(l2.get(j));
					j++;
				}
			}
	
			while (i < l1.size()) {
				result.add(l1.get(i));
				i++;
			}
			while (j < l2.size()) {
				result.add(l2.get(j));
				j++;
			}
			return result;
		}
	}
