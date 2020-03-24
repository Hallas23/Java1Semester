package opgav2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Opgave2 {

	public static void main(String[] args) {
		try {
            File filein = new File("C:\\Users\\Simon\\Documents\\Datamatiker\\ooo.txt");
            Scanner scan = new Scanner(filein);
            while (scan.hasNext()) { 
             int sum = scan.nextInt() * 2;
             System.out.println(sum);
            }
            scan.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

	}

