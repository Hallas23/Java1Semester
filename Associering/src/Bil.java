
public class Bil {

	private String name;
	private String farve;

	public Bil(String inputName, String inputFarve) {
		name = inputName;
		farve = inputFarve;

	}
	// Alle setMetoderne

	public void setName(String inputName) {
		name = inputName;
	}

	public void setAddres(String inputFarve) {
		farve = inputFarve;
	}

	// Alle getMetoderne

	public String getName() {
		return name;
	}

	public String getFarve() {
		return farve;
	}

	public void printBil() {
		System.out.println(name);
		System.out.println(farve);
	}

}
