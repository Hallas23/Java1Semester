package arraylists;

import java.util.ArrayList;


public class Ex2 {

    /**
     * Tests all the methods.
     */
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<Integer>();
        ints.add(12);
        ints.add(0);
        ints.add(45);
        ints.add(7);
        ints.add(-16);
        ints.add(0);
        ints.add(23);
        ints.add(-10);
//        ints.addAll(Arrays.asList(12, 0, 45, 7, -16, 0, 23, -10));
        System.out.println("ints: " + ints);
        System.out.println();

        // Test of sum() method: correct sum is 61.
        int total = sum1(ints);
        System.out.println("Sum: " + total);
        int total2 = sum2(ints);
        System.out.println("Test af sum2 " + total2);
        int total3 = minimum(ints);
        System.out.println("Test af minimum " + total3);
        int total4 = maximum(ints);
        System.out.println("Test af maximum " + total4);
        double total5 = average(ints);
        System.out.println("Test af average " + total5);
        int total6 = zero(ints);
        System.out.println("Test af zero " + total6);
        int total7 = evens(ints);
        System.out.println("Test af evens " + total7);
        

        // Test of minimum() method: correct minimum is -16.

        // Test of maximum() method: correct maximum is 45.

        // Test of average() method: correct average is 7.625.

        // Test of zeroes() method: correct number of zeroes is 2.

        // Test of evens() method: correct result is [12, 0, -16, 0, -10].
    }

    // sum made with for statement
    public static int sum1(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            sum = sum + number;
        }
        return sum;
    }
    
    public static int sum2(ArrayList<Integer> list) {
    	int sum = 0;
    	for(int s: list) {
    		sum = sum + s;
    		
    	}
    	return sum;
    }
    
    public static int minimum(ArrayList<Integer> list) {
    	int minimum = 0;
    	for(int s: list) {
    		if (s < minimum) {
    			minimum = s;
    		}
    	
    		
    	}
    	return minimum;
    }
    
    public static int maximum(ArrayList<Integer> list) {
    	int maximum = 0;
    	for(int s: list) {
    		if (s > maximum) {
    			maximum = s;
    		}
    	
    		
    	}
    	return maximum;
    }
    
    public static double average(ArrayList<Integer> list) {
    	double average = 0;
    	double e = 0;
    	double sum = 0;
    	for(int s: list) {
    	e++;
    	sum = sum + s;
    		if (e == list.size()) {
    			average = sum / list.size();
    		}
    	
    		
    	}
    	return average;
    	
    }
    
    public static int zero(ArrayList<Integer> list) {
    	int zero = 0;
    	for(int s: list) {
    		if (s == 0) {
    			 zero++;
    		}
    	
    		
    	}
    	return zero;
    	
    }
    
    public static int evens(ArrayList<Integer> list) {
    	int evens = 0;
    	for(int s: list) {
    		if (s % 2 == 0) {
    			 System.out.print(s + " ");
    			 evens++;
    		}
    	
    		
    	}
    	return evens;
    	
    }
   
}
