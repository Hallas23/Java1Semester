import java.util.ArrayList;

public class Prisgruppe {

	private final ArrayList<Bil> prisa = new ArrayList<>();

	public ArrayList<Bil> getBilera() {
		return new ArrayList<>(prisa);
	}

	public void AddBilA(Bil bil) {
		if (!prisa.contains(bil)) {
			prisa.add(bil);
		}
	}

	public void printBilera() {
		for (Bil i : prisa) {
			i.printBil();
		}
	}
	
	public void printSpecifikBila(Bil bil) {
			bil.printBil();
		
	}
}
