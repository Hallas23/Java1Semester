package personeksempel;

public class Person {
	
	private String name;
	private String address;
	private double monthlySalary;
	private double årsløn;
	private int virksomheder;
	private boolean ansat;
	
	public Person (String inputName, String inputAddress, double inputMonthlySalary) {
		name = inputName;
		address = inputAddress;
		monthlySalary = inputMonthlySalary;
		årsløn = (monthlySalary + (monthlySalary / 100 * 2.5)) * 12;
		virksomheder = 8;
		ansat=true;
	}
	//Alle setMetoderne
	
	public void setName(String inputName) {
		name = inputName;
	}
	
	public void setAddres(String inputAddress) {
		address = inputAddress;
	}
	
	public void setMontlySalary(double inputMonthlySalary) {
		this.monthlySalary = inputMonthlySalary;
	}
	//Alle getMetoderne
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public double getMonthlySalary() {
		return monthlySalary;
	}
	
	public void årsløn(double årsløn) {
		årsløn = (monthlySalary + (monthlySalary / 100 * 2.5)) * 12;
	}
	
	public void setAnsat(boolean eransat) {
		ansat = eransat;
	}
	
	public boolean eransat() {
		return ansat;
	}
	
	public void printPerson() {
		System.out.println("************************************************");
		System.out.println("* " + name + "                                     *");
		System.out.println("* " + address + "                                *");
		System.out.println("* " + monthlySalary + "                                    *");
		System.out.println("* " + årsløn + "                                  *");
		System.out.println("* " + "Den ansatte har været ansat i " + virksomheder + " virksomheder" + " *");
		System.out.println("* Er personen ansat? " + ansat + "                      *");
		System.out.println("************************************************");
	}

}