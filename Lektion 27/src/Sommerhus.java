
public class Sommerhus extends Hus {

	private boolean beboet;	
	
	public Sommerhus(String adresse, int kvm, int grund, boolean beboet) {
		super(adresse, kvm, grund);
		this.beboet = beboet;
	}

	public boolean isBeboet() {
		return beboet;
	}

	public void setBeboet(boolean beboet) {
		this.beboet = beboet;
	}

	@Override
	public double beregnEjendomsværdi() {
		double værdi = 0;
		værdi = super.beregnEjendomsværdi() - getGrund() * 20;
		return værdi;
	}
}
