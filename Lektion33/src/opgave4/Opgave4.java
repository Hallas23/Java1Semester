/**
 * 
 */
/**
 * @author Simon
 *
 */
package opgave4;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgave4 {

	public static void main(String[] args) {
		try {
            File filein = new File("C:\\Users\\Simon\\Documents\\Datamatiker\\test2.txt");
            PrintWriter printWriter = new PrintWriter(filein);
            
            for (int i = 100; i >= 0; i--) {
            	if (i % 2 != 0) {
            		printWriter.println(i);
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
