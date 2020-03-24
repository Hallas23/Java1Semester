
public class Beboelse {
	
	private String adresse;
	private int kvm;
	
	public Beboelse(String adresse, int kvm) {
		super();
		this.adresse = adresse;
		this.kvm = kvm;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getkvm() {
		return kvm;
	}

	public void setKvm(int kvm) {
		this.kvm = kvm;
	}
}
