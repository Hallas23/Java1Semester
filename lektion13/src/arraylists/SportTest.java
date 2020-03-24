package arraylists;

public class SportTest {

	public static void main(String[] args) {
		Player p = new Player("Ole Hansen", 50, 30);
		Player p1 = new Player("Egon olsen", 22, 32);
		Player p2 = new Player("Hans Ole", 50, 30);
		Player p3 = new Player("Børge Jensen", 22, 32);
		Team t1 = new Team("Tigers");
		t1.addPlayer(p2);
		t1.addPlayer(p1);
		t1.addPlayer(p);
		t1.addPlayer(p3);
		t1.printPlayers();
		System.out.println(t1.calcAverageAge());
		System.out.println("");
		System.out.println(t1.calctotalscore());
		System.out.println(t1.caclOldPlayersScore());
		System.out.println(t1.maxScore());
		System.out.println(t1.bestPlayerNames());

	}

}
