package Opgave1;

public class TestApp {

	public static void main(String[] args) {
		String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian", 
				"August", "Marius", "John", "Tove", "Poul", "Torkild"};
		
		opgave1.bubbleSort(s);
		for (String m: s) {
			System.out.println(m);
		}
		
	}

}
