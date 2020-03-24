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

public class Gennemsnit {

	public static void main(String[] args) {
		try {
            File filein = new File("C:\\Users\\Simon\\Documents\\Datamatiker\\test2.txt");
            PrintWriter printWriter = new PrintWriter(filein);
            
            int sum = 0;
            int j = 0;
            for (int i = 10; i >= 0; i--) {
            	int random = (int) (Math.random() * 10 + 1);
            		printWriter.println(random);
            		sum = sum + random;
            		j++;
            }
            int average = sum / j;
            printWriter.println("Gennemsnittet er : " + average);
            printWriter.close();
            printWriter.flush();
            System.out.println("Filen er lavet");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

	}
