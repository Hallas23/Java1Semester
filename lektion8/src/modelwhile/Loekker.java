package modelwhile;

public class Loekker {
	public void udskriv1_10() {
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
		System.out.println("5");
		System.out.println("6");
		System.out.println("7");
		System.out.println("8");
		System.out.println("9");
		System.out.println("10");

	}

	public void udskriv1_10_iteration() {
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}
	}

	public int summer() {
		int sum = 0;
		int i = 1;
		while (i <= 10) {
			sum = sum + i;
			i++;
		}
		return sum;

	}

	public int summer(int n) {
		int sum = 0;
		int i = 1;
		while (i <= n) {
			sum = sum + i;
			i++;
		}
		return sum;

	}

	public int multiplum(int a, int b) {
		int resultat = 0;
		int i = 0;
		while (i < a) {
			resultat = resultat + b;
			i++;
		}
		return resultat;

	}

	public int summerEven() {
		// TODO Exercise E6.2A
		return -1;
	}

	public int summerSquare() {
		// TODO Exercise E6.2B
		return -1;
	}

	public void allPowers() {
		
		
		for(int i = 0; i <= 20; i++) {
			System.out.println(Math.pow(2, i));
		
		}
	}

	public int sumOdd(int a, int b) {
		int e = a;
		
		while(e < b) {
			e = e + 2;
			a = a + e;
}
		
		return a;
	}

	public int sumOfOddDigits(int number) {
		
		String digits = String.valueOf(number);
		int numberofdigits2 = String.valueOf(number).length();
		int sum = 0;
		int t = 0;
		
		while(numberofdigits2> 0) {
			char c = digits.charAt(t++);
			int i = Character.getNumericValue(c);
			numberofdigits2--;
			
			if(i % 2 != 0) {
				sum = sum + i;
			}
				
		}
	return sum;
}
}