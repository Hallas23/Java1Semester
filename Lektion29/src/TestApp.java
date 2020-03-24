
public class TestApp {

	public static void main(String[] args) {
		Chilli c1 = new Chilli("Carolina", 200000);
		Chilli c2 = new Chilli("Egon", 500000);
		
		Chilli[] chillier = {c1, c2};
		
		System.out.println(Data.max(chillier).toString());
		
		
	

	}

}
