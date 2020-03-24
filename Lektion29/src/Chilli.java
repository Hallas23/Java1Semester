
public class Chilli implements Measurable {
	private String navn;
	private double Scoville;
	
	public Chilli(String navn, double scoville) {
		super();
		this.navn = navn;
		Scoville = scoville;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public double getScoville() {
		return Scoville;
	}

	public void setScoville(double scoville) {
		Scoville = scoville;
	}

	@Override
	public double getMeasure() {
		return getScoville();
	}
	@Override
	public String toString() {
		return navn;
	}
}
