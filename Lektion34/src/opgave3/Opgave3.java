package opgave3;

import java.util.ArrayList;
import java.util.Arrays;



import java.util.ArrayList;

public class Opgave3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer c1 = new Customer("Hansen1", "ole", 19);
		Customer c2 = new Customer("Hansen2", "ole", 19);
		Customer c3 = new Customer("Hansen3", "ole", 19);
		Customer c4 = new Customer("Hansen4", "ole", 19);
		Customer c5 = new Customer("Hansen5", "ole", 19);
		
		ArrayList<Customer> l1 = new ArrayList<Customer>();
		
		Customer[] l2 = new Customer[4];
		
		l1.add(c1);
		l1.add(c2);
		l1.add(c3);
		l1.add(c4);
		l1.add(c5);
	

		l2[0] = c1;
		l2[1] = c2;
		l2[2] = c3;
		l2[3] = c4;
		
		System.out.println(goodCustomers(l1,l2));
	}
	
	public static ArrayList<Customer> goodCustomers(ArrayList<Customer> Allc, Customer[] badC){
		ArrayList<Customer> l3 = new ArrayList<>(Allc);
		
		int i1 = 0;
		int i2 = 0;
		
		
		while(i1 < Allc.size() && i2 <badC.length) {
			if(Allc.get(i1).compareTo(badC[i2]) == 0) {
				l3.remove(badC[i2]);
			
				i1++;
				i2++;
			}
		}
		
		return l3;
	}

}
