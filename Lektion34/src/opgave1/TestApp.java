package opgave1;

import java.util.ArrayList;


public class TestApp {

	public static void main(String[] args) {
		Customer c1 = new Customer("aaaa", "ol", 22);
		Customer c2 = new Customer("cccc", "Olsen", 23);
		Customer c3 = new Customer("eeee", "Jensen", 23);
		Customer c4 = new Customer("åååå", "JAbe", 22);
		
		Customer c5 = new Customer("bbbb", "JAbe", 22);
		Customer c6 = new Customer("dddd", "JAbe", 22);
		Customer c7 = new Customer("ffff", "JAbe", 22);
		
		ArrayList<Customer> l1 = new ArrayList<Customer>();
		ArrayList<Customer> l2 = new ArrayList<Customer>();
		
		l2.add(c5);
		l2.add(c6);
		l2.add(c7);

		l1.add(c1);
		l1.add(c2);
		l1.add(c3);
		l1.add(c4);
		
		System.out.println(Fletning.mergeAllCustomers(l1, l2));
	}

}
