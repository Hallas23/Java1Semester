package lektion6;
import java.util.Scanner;

public class E501 {
	
	public static void main(String[] args) {
	
	Scanner cs = new Scanner(System.in);
	{
	int i =22;
	System.out.println("Enter the number you want to check");
	i = cs.nextInt();
	
	if(i > 0) {
        System.out.println("The given number "+i+" is Positive");
	}
	
	else if(i < 0) {
        System.out.println("The given number "+i+" is Negative");
	}
	
	else {
        System.out.println("The given number "+i+" is neither positive or negative");
	}
	}
}
}

