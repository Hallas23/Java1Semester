package lektion5bug;

public class Bug {
	
	private int position;
	private int direction;
	private int move;
	
	public Bug(int initialposition, int adddirection) {
		position = initialposition;
		direction = adddirection;
	}
	
	public int getposition() {
		return position;
	}
	
	public void addirection(int adddirection) {
		this.direction = adddirection;
		
	}
	
	
	public void move() {
		if (direction == 1) {
			this.move = position + position ++;;
		}
		else {
			this.move = position + position --;
		}
		
	}

	public void printBug() {
		System.out.println(position);
	}
	
	
}

