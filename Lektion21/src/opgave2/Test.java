package opgave2;

public class Test {

	public static void main(String[] args) {
		Person ole = new Person("ole", 22);
		Gift es = new Gift("ll", 22.00, ole);
		Gift es1 = new Gift("ll", 22.00, ole);
		Person ole2 = new Person("Mathias", 223);
		Gift es2 = new Gift("ll", 22.00, ole2);
		Person ole3 = new Person("LEEEEEEEEEEEEEET", 2244);
		Gift d = new Gift("L", 22.00, ole3);

		
		ole3.addGift(es);
		ole3.addGift(es1);
		ole3.addGift(es2);
		ole3.addGift(d);
		
		
		System.out.println(ole3.getGivers().toString());
		
	}

}
