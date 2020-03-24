package lektion6;
import java.util.Scanner;

public class E505 {
			
		public static void main(String[] args) {
		
		Scanner cs = new Scanner(System.in);
		{
		int e;
		int r;
		int t;
		System.out.println("Enter the number you want to check");
		e = cs.nextInt();
		r = cs.nextInt();
		t = cs.nextInt();
		
		if(e < r && r < t) {
	        System.out.println("The given numbers "+e+ " " + r + " "+ t + " " + " is increasing");
		}
		
		else if(e > r  || r > t) {
	        System.out.println("The given numbers "+e+ " " + r + " " + t + " " +" is Decrasing");
		}
		
		else {
	        System.out.println("The given numbers "+e+ " "+ r + " " +t + " " +" is neither increasing or decreasing");
		}
		}
	}
	}
