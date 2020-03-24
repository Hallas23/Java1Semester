package opgave3;

public class Værkstedsbesøg {
	private String hændelse;
	private int kmTal;
	private String dato;
	
	Værkstedsbesøg(String hændelse, int kmTal, String dato) {
		this.hændelse = hændelse;
		this.kmTal = kmTal;
		this.dato = dato;
	}

	public String getHændelse() {
		return hændelse;
	}

	public void setHændelse(String hændelse) {
		this.hændelse = hændelse;
	}

	public int getKmTal() {
		return kmTal;
	}

	public void setKmTal(int kmTal) {
		this.kmTal = kmTal;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}
	
	public void printBesøg(int nr) {
		System.out.println(hændelse);
		System.out.println(kmTal);
		System.out.println(dato);
	}
	
}
