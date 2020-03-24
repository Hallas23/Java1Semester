package arraylists;

public class Player {
	
	private String name;
	private int age;
	private int score;
	
	
	public Player(String name, int age, int score) {
		this.age = age;
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int score) {
		score = score + this.score;
	}
}

