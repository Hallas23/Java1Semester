package application.model;

public class Profspiller extends Spiller {
	private double kampHonorar;

	public Profspiller(String navn, int årgang, double kampHonorar) {
		super(navn, årgang);
		this.kampHonorar = kampHonorar;
	}

	public double getKampHonorar() {
		return kampHonorar;
	}

	public void setKampHonorar(int kampHonorar) {
		this.kampHonorar = kampHonorar;
	}
	
	public double kampHonorar() {
		int afbud = 0;
		double honorar = 0;
		double procent = 0;
		
		for (Deltagelse d: this.getDeltagelser()) {
			honorar = honorar + (kampHonorar * 10);
			if (d.isAfbud()) {
				afbud++;
			}
		}
		if (afbud > 0) {
			procent = (honorar / 100) * (afbud * 10);
			honorar = honorar - procent;
		}
		System.out.println(procent);
		return honorar;
	}
	
	public double kampHonorarforenkamp() {
		return kampHonorar * 10;
	}
}
