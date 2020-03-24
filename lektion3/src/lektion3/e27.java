package lektion3;

public class e27 {

	public static void main(String[] args) {

		String print = "Hello. World";
		String print2 = (print.replaceAll("o", "E"));
		String print3 = (print2.replaceAll("e", "o"));
		String print4 = (print3.replaceAll("E", "e"));
		
		System.out.println(print4);
		
	}

}
