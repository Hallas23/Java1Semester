package model;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
	/*
	 * Attributter der beskriver den ansattes tilstand
	 */
	private String fornavn;
	private String efternavn;
	private boolean trainee;
	private int age;

	/*
	 * Constructor, når den ansatte oprettes, skal den have et navn. Ved
	 * oprettelse er den ansatte en trainee
	 */
	public Employee(String inputName, String inputname2, int age) {
		fornavn = inputName;
		efternavn = inputname2;
		trainee = true;
		this.age = age;
		
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void birthday() {
		this.setAge(age +1);
	}

	/*
	 * Den ansattes navn kan ændres ved kald af setName metoden
	 */
	public void setName(String inputName) {
		fornavn = inputName;
	}
	
	public void setName2(String inputName2) {
		efternavn = inputName2;
	}
	

	/*
	 * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
	 */
	public String getName() {
		return fornavn;
	}

	public String getName2() {
		return efternavn;
	}
	/*
	 * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
	 */
	public void setTrainee(boolean isTrainee) {
		trainee = isTrainee;
	}

	/*
	 * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
	 * isTrainee
	 */
	public boolean isTrainee() {
		return trainee;
	}

	public void printEmployee() {
		System.out.println("*******************");
		System.out.println("Fornavn: " + fornavn + "*");
		System.out.println("Efternavn: " + efternavn + "*");
		System.out.println("Trainee: " + trainee + "*");
		System.out.println("Alder: " + age + "*");
		System.out.println("********************");
	}
}
