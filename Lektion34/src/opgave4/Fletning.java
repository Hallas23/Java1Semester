package opgave4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Fletning {

	public static void mergeFiles(String filename1, String filename2, String filename3) {
		
			
			File file1 = new File(filename1);
			File file2 = new File(filename2);
			File file3 = new File(filename3);
			
			try(Scanner scan1 = new Scanner(file1);	Scanner scan2 = new Scanner(file2)) {
			
			PrintWriter printWriter3 = new PrintWriter(file3);
			
			while (scan1.hasNextInt() || scan2.hasNextInt()) {
				if (scan1.hasNextInt()) {
				printWriter3.println(scan1.nextInt());
				}
				if (scan2.hasNextInt()) {
				printWriter3.println(scan2.nextInt());
				}
			}
			printWriter3.close();
			printWriter3.flush();
			System.out.println("Filen er lavet");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
