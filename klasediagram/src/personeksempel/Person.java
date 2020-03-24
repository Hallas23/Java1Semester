package personeksempel;

public class Person {
	
	private String name;
	private String address;
	private int virksomheder;
	private double monthlySalary;
	private double yearlySalary;
	private boolean ansat;
	
	public Person (String inputName, String inputAddress, int inputvirksomheder, double inputMonthlySalary) {
		name = inputName;
		address = inputAddress;
		virksomheder = inputvirksomheder;
		monthlySalary = inputMonthlySalary;
		yearlySalary = (monthlySalary * 12) + (monthlySalary * 12) / 100 * 2.5;
		ansat = true;
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
	
	public void setAnsat(boolean isAnsat) {
		ansat = isAnsat;
	}
	public boolean erAnsat() {
		return ansat;
	}
	
		
	
	
	public void printPerson() {
		System.out.println(name);
		System.out.println(address);
		System.out.println("antal virksomheder " + virksomheder);
		System.out.println(monthlySalary);
		System.out.println(yearlySalary);
		System.out.println(ansat);
	}

}