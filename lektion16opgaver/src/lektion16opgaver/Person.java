package lektion16opgaver;
public class Person {
	private String name;
	private String title;
	private boolean senior;

	public Person(String name, String titel, boolean senior) {
		super();
		this.name = name;
		this.title = titel;
		this.senior = senior;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getActor() {
		return senior;
	}

	public String toString() {
		String s = title + " " + name;
		if (senior)
			s = s + " (senior)";
		return s;
	}
}