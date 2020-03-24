package eksempel;

public class DebuggerApp {

	public static void main(String[] args) {
		
		DebuggerEks bug = new DebuggerEks();
		
		int[][] tal = 	{{1,4,5,88},
						 {3,77,99,101},
						 {6,8,9,1},
						 {3,0,209}
						};
		
		//System.out.println(bug.findMax(tal));
		int[] temp = bug.findEvenNumbers(tal);
		
		for(int e: temp) {
			System.out.println(e);
		}
	}

}
