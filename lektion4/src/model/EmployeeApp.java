package model;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans", "Jensen", 42);
		e1.printEmployee();
		e1.birthday();
		e1.setName("Egon");
		e1.setName2("Olsen");
		e1.printEmployee();

	}

}
