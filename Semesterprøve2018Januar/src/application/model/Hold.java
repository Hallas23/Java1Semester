package application.model;

import java.util.ArrayList;

public class Hold {
	private String betegnelse;
	private String holdleder;
	private final ArrayList<Tutor> tutore = new ArrayList<>();
	private Uddannelse uddannelse;

	public Hold(String betegnelse, String holdleder, Uddannelse uddannelse) {
		this.betegnelse = betegnelse;
		this.holdleder = holdleder;
		this.uddannelse = uddannelse;
	}

	public String getBetegnelse() {
		return betegnelse;
	}

	public void setBetegnelse(String betegnelse) {
		this.betegnelse = betegnelse;
	}

	public String getHoldleder() {
		return holdleder;
	}

	public void setHoldleder(String holdleder) {
		this.holdleder = holdleder;
	}

	public ArrayList<Tutor> getTutore() {
		return new ArrayList<>(tutore);
	}

	public void addTutor(Tutor tutor) {
		if (!tutore.contains(tutor)) {
			tutore.add(tutor);
			tutor.setHold(this);
		}
	}

	public void removeTutor(Tutor tutor) {
		if (tutore.contains(tutor)) {
			tutore.remove(tutor);
			tutor.setHoldNull();
		}
	}

	public Uddannelse getUddannelse() {
		return uddannelse;
	}

	public double Arrangementspris() {
		double pris = 0;
		for (Tutor m : tutore) {
			pris = pris + m.Arrangementspris();
		}
		return pris;
	}

	public boolean harTidsoverlap(Arrangement arrangement) {
		boolean overlap = true;
		for (Tutor m : tutore) {
			for (int i = 0; i < m.getArrangementer().size(); i++) {
				if (m.getArrangementer().get(i).getSlutTid().isBefore(arrangement.getStartTid())
						|| (m.getArrangementer().get(i).getStartTid().isAfter(arrangement.getSlutTid()))) {
					overlap = false;
					System.out.print("Intet overlap ");
					return overlap;

				}
			}
		}
		System.out.println("Overlapper");
		return overlap;
	}

	public void setUddannelse(Uddannelse uddannelse) {
		if (this.uddannelse != uddannelse) {
			Pre.require(this.uddannelse == null);
			this.uddannelse = uddannelse;
			uddannelse.addHold(this);
		}
	}
	
	public String toString() {
		return betegnelse;
	}

}
