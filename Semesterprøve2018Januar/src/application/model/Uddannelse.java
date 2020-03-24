package application.model;

import java.util.ArrayList;

public class Uddannelse {
	private String navn;
	private final ArrayList<Hold> holde = new ArrayList<>();

	public Uddannelse(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public ArrayList<Hold> getHold() {
		return new ArrayList<>(holde);
	}

	public Hold createHold(String betegnelse, String holdleder) {
		Hold hold = new Hold(betegnelse, holdleder, this);
		holde.add(hold);
		return hold;

	}
	public void addHold(Hold hold) {
		if (!holde.contains(hold)) {
			holde.add(hold);
			hold.setUddannelse(this);
		}
	}
	
	public ArrayList<String> tutorOversigt() {
		ArrayList<String> tutore = new ArrayList<>();
		
		for (int i = 0; i < holde.size(); i++) 
		{
			for (int j = 0; j < holde.get(i).getTutore().size(); j++) 
			{
				tutore.add(holde.get(i).getTutore().get(j).getName() + " " + holde.get(i).getTutore().get(j).getEmail() + " " +  
			holde.get(i).getUddannelse().getNavn() + " " +  holde.get(i).getBetegnelse());
			}
		}
		return tutore;
	}
}
