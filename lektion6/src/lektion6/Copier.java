package lektion6;
import java.util.Scanner;

public class Copier {

	private int paper;
	private boolean paperstuck;
	
	public Copier(int paper) {
		this.paper = paper;
		if (paper > 500) {
			System.out.println("No more room for paper");
		}
		this.paperstuck = paperstuck;
	}
	
		
	public void insertPaper(int paper) {
		if (this.paper + paper > 500) {
			System.out.println("No more room for paper");
		}
		else {
		this.paper = this.paper + paper;
	}}
	
	public int getPaper() {
		return paper;
	}
	
	public void makeCopy(int copies) {
		if (paperstuck == true) {
			System.out.println("The paper is stuck");
		}
		
		else if (paper > 500) {
			System.out.println("No more room for paper");
		}
			
		else if (paper - copies >= 0) {
		paper = paper - copies;
		}
		
		else {
			System.out.println("insert paper");
		}
	}
		
		public void fixjam() {
			paperstuck = false;
			System.out.println("the paper is unstuck");
		}
		
		public void makePaperJam(boolean paperstuck) {
			this.paperstuck = paperstuck;
		}
	
	public void printCopier() {
		if (paper > 500) {
			System.out.println("No more room for paper");
		}
		else {
		System.out.println(paper);
		}
	}
}	
		
		
 

