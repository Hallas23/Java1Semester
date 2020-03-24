/**
 * 
 */
/**
 * @author Simon
 *
 */
package opgave5;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Opgave5 {

	public static void main(String[] args) {
		try {
            File filein = new File("C:\\Users\\Simon\\Documents\\Datamatiker\\test2.txt");
            PrintWriter printWriter = new PrintWriter(filein);
            
            for (int i = 2000; i >= 0; i--) {
            	int random = (int) (Math.random() * 100 - 49);
            		printWriter.println(random);
            		if(random == - 1) {
            			i = 0;
            		}
            	
            }
            printWriter.close();
            printWriter.flush();
            System.out.println("Filen er lavet");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

	}
