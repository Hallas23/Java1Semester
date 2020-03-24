package lektion4;

public class Counter {

	private int value; 
	
	public Counter(int value) { // constructor
		this.value = value;
	}
	
	public void click() { // metode
		value ++;
	}
	
	public int getValue() {
		return value;
	}
	
	public void undo() {
		value = Math.max(value-1, 0);
	}
	
	public void setLimit(int maximum) {
		value = Math.min(value,maximum);
	}
	
	public void reset() {
		value = 0;
	}

}

