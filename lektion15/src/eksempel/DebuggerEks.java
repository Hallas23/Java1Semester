package eksempel;

public class DebuggerEks {

	public int findMax(int[][] tal) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < tal.length; i++) {
			for (int j = 0; j < tal[i].length; j++) {
				if (tal[i][j] < max) {
					max = tal[i][j];
				}
			}
		}
		return max;
	}

	public int[] findEvenNumbers(int[][] tal) {
		int[] even = new int[tal.length];

		for (int i = 0; i < tal.length; i++) {			
			for (int j = 0; j < tal[i].length; j++) {
				if (isEven(tal[i][j])) {
					even[i] = tal[i][j];
				}
			}			
		}
		return even;
	}
	
	public boolean isEven(int number) {
		boolean even = false;
		if(number%2 == 0)
			even = true;
		return even;
	}

}
