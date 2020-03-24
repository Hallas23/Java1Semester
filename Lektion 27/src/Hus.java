
public class Hus extends Beboelse {
	
	private int grund;

	public Hus(String adresse, int kvm, int grund) {
		super(adresse, kvm);
		this.grund = grund;
	}

	public int getGrund() {
		return grund;
	}

	public void setGrund(int grund) {
		this.grund = grund;
	}
	
	public double beregnEjendomsværdi() {
		double værdi = 0;
		værdi = getkvm() * 290 + grund *40;
		return værdi;
	}
	
	
}
