package arraylists;

import java.util.ArrayList;

public class Team {

	
	private int agelimit = 30;
	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<String> bestplayer = new ArrayList<String>();

	public Team(String name) {

		
	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	public void printPlayers() {
		for (Player s : players) {
			System.out.println(s.getName() + " " + s.getScore() + " " + s.getAge());
		}
	}

	public double calcAverageAge() {
		double average = 0;
		double sum = 0;
		for (Player s : players) {
			sum = sum + s.getAge();
		}
		average = sum / players.size();
		return average;
	}

	public int calctotalscore() {
		int totalscore = 0;
		for (Player s : players) {
			totalscore = totalscore + s.getScore();
		}
		return totalscore;
	}

	public int caclOldPlayersScore() {
		int totalscore = 0;
		for (Player s : players) {
			if (s.getAge() > agelimit) {
				totalscore = totalscore + s.getScore();
			}
		}
		return totalscore;
	}

	public int maxScore() {
		int maxscore = 0;
		for (Player s : players) {
			if (s.getScore() > maxscore) {	
				maxscore = s.getScore();
			}
		}
		return maxscore;
	}

	public ArrayList<String> bestPlayerNames() {
		int e = maxScore();
		String t;
		for (Player s : players) {
			if (s.getScore() + 1 > e) {
				t = s.getName();
				bestplayer.add(t);
			}
		}
		return bestplayer;
	}
}
