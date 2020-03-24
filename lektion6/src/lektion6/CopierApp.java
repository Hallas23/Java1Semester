package lektion6;
import java.util.Scanner;

public class CopierApp {

	public static void main(String[] args) {
		Copier p = new Copier(490);
		p.makePaperJam(true);
		p.insertPaper(30);
		p.fixjam();
		p.makeCopy(35);
		p.printCopier();
		
		

	}

}
