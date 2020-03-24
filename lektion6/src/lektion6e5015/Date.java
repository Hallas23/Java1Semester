package lektion6e5015;

public class Date {
	
		private int måned;
		private double dato;
		private int år;
		private String season;
		
		
	public Date(int måned, double dato, int år) {
		this.måned = måned;
		this.dato = dato;
		this.år = år;
	}
	
	public int getmåned() {
		return måned;
	}
	
	public void setmåned(double dato) {
		this.måned = måned;
	}
	
	public String season() {
		if(måned >= 1.00 && måned < 4.00) {
			season = "Winter " + dato +" " + år;
		}
		
		else if(måned >= 4.00 && måned < 7.0) {
			season = "Spring " + dato + " " + år;
		}
		
		else if(måned >= 7.00 && måned < 10) {
			season = "Summer " + dato + " " + år;
		}
		
		else if(måned >= 1.00 && måned <= 12) {
			season = "Fall " + dato + " " + år;
		}
	return season;
}
}