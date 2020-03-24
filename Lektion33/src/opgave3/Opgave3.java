/**
 * 
 */
/**
 * @author Simon
 *
 */
package opgave3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Opgave3 {

	public static void main(String[] args) {
		try {
            File filein = new File("C:\\Users\\Simon\\Documents\\Datamatiker\\ooo.txt");
            Scanner scan = new Scanner(filein);
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (scan.hasNext()) { 
             int sum = scan.nextInt();
             list.add(sum);
            }
            scan.close();
            for (int i = list.size() - 1; i >= 0  ; i--) {
            	System.out.println(list.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

	}
