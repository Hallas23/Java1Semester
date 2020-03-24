/**
 * 
 */
/**
 * @author Simon
 *
 */
package opgave6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Max {

	public static void main(String[] args) {
		try {
            File filein = new File("C:\\Users\\Simon\\Documents\\Datamatiker\\test2.txt");
            PrintWriter printWriter = new PrintWriter(filein);
            
            int max = 0;
            for (int i = 100000; i >= 0; i--) {
            	int random = (int) (Math.random() * 102 - 1);
            		printWriter.println(random);
            	if (random > max) {
            		max = random;
            	}
            }
            printWriter.println("Max er : " + max);
            printWriter.close();
            printWriter.flush();
            System.out.println("Filen er lavet");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

	}
