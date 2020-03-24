package opgave2;

public class Gift {
	private String description;
	private double price;
	private Person giver;
	
	
	public Gift(String description, double price, Person giver) {
		this.description = description;
		this.price = price;
		this.giver = giver;
	}
	
	public Person getGiver() {
		return giver;
	}
		
	public double getPrice() {
		return price;
	}
	
	
	
	
}
