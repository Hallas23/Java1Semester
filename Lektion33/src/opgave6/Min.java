package opgave6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Min {

	public static void main(String[] args) {
		try {
            File filein = new File("C:\\Users\\Simon\\Documents\\Datamatiker\\test2.txt");
            PrintWriter printWriter = new PrintWriter(filein);
            
            int min = 50;
            for (int i = 10; i >= 0; i--) {
            	int random = (int) (Math.random() * 100 - 49);
            		printWriter.println(random);
            	if (random < min) {
            		min = random;
            	}
            }
            printWriter.println("Min er : " + min);
            printWriter.close();
            printWriter.flush();
            System.out.println("Filen er lavet");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

	}
