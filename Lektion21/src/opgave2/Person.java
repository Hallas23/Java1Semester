package opgave2;

import java.util.ArrayList;




public class Person {
	private String name;
	private int age;
	
	private final ArrayList<Gift> gifts = new ArrayList<>();

	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return name;
	}
	
	public ArrayList<Gift> getGifts() {
		return new ArrayList<>(gifts);
	}
	
	public void addGift(Gift gift) {
		if (!gifts.contains(gift)) {
			gifts.add(gift);
		}
	}
	
	public void removeift(Gift gift) {
		if (gifts.contains(gift)) {
			gifts.remove(gift);
		}
	}
	
	public double ValueofGifts() {
		double value = 0;
		for (int i = 0; i < gifts.size(); i++) {
			value = value + gifts.get(i).getPrice();
		}
		return value;
	}
	
	public ArrayList<Person> getGivers() {
		ArrayList<Person> persons = new ArrayList<>();
		for (int i = 0; i < gifts.size(); i++) {
			persons.add(gifts.get(i).getGiver());
		}
		return persons;
	}
}
