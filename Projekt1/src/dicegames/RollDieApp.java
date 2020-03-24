package dicegames;

/**
 * This application instantiates the PlayRollDie game and starts it.
 */
public class RollDieApp {

    /**
     * The main method. Don't call this one directly.
     * @param args the program arguments
     */
	public static void main(String[] args) {
		PlayRollDie play = new PlayRollDie();
		PlayPairOfDices play1 = new PlayPairOfDices();
		play1.rollBothDices();
		play1.rollBothDices();
		play1.rollBothDices();
		play1.rollBothDices();
		play1.rollBothDices();
		play1.rollBothDices();
		play1.rollBothDices();
		play1.rollBothDices();
		play1.rollBothDices();
		play1.resetpairofdice();
		System.out.println(play1.highestsum());
		System.out.println(play1.numberofdoubles());
		System.out.println(play1.numberofrolls());
		System.out.println(play1.sumofdices());
		System.out.println(play1.numberofsixes());
		System.out.println(play1.numberoffives());
		System.out.println(play1.numberoffours());
		System.out.println(play1.numberofthrees());
		System.out.println(play1.numberoftwos());
		System.out.println(play1.numberofones());
		play.startGame();
	}

}
