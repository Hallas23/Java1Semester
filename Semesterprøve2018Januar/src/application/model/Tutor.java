package application.model;

import java.util.ArrayList;

public class Tutor {

	private String email;
	private String name;
	private Hold hold;
	private final ArrayList<Arrangement> arrangementer = new ArrayList<>();

	public Tutor(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Hold getHold() {
		return hold;
	}

	public void setHold(Hold hold) {
		if (this.hold != hold) {
			Pre.require(this.hold == null);
			this.hold = hold;
			hold.addTutor(this);
		}
	}

	public void setHoldNull() {
		if (this.hold != null) {
			Hold oldHold = this.hold;
			this.hold = null;
			oldHold.removeTutor(this);
		}
	}

	public ArrayList<Arrangement> getArrangementer() {
		return new ArrayList<>(arrangementer);
	}
	
	
	
	public void addArrangement(Arrangement arrangement) {
		if (!arrangementer.contains(arrangement)) {
		arrangementer.add(arrangement);
		}
	}
	
	public void removeArrangement(Arrangement arrangement) {
		if (arrangementer.contains(arrangement)) {
			arrangementer.remove(arrangement);
		}
	}
	
	public double Arrangementspris() {
		double pris = 0;
		for (Arrangement m : arrangementer) {
			pris = pris + m.getPris();
		}
		return pris;
	}

}
