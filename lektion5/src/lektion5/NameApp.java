package lektion5;

public class NameApp {

	public static void main(String[] args) {
		Name s1 = new Name("Hans", "Jørgen", "Jørgensen");
		s1.setmiddlename("egon");
		System.out.println(s1.getInit());
		System.out.println(s1.getUsername());
		s1.printName();

	}

}
