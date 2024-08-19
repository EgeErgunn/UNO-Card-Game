package player;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import cardDeck.Card;

public class You extends Player {
	private int totalScore;
	
	public You(String name, int totalScore) {
		super(name);
		this.totalScore = totalScore;
	}
	public void resetHand() {
		this.hand = new ArrayList<Card>();
	}
	//Updates total score but it needs to write everything at the same time
	public void updateTotalScore(int score, HashMap<String, Integer> userScoreMap, HashMap<String, String> userpasswordMap, HashMap<String, Integer> userGameMap, HashMap<String, Integer> userWinMap) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("txts/Accounts.txt"))) {
			for (HashMap.Entry<String, String> entry : userpasswordMap.entrySet()) {
				if (entry.getKey().equalsIgnoreCase(name)) {
					int totalScore = userScoreMap.get(entry.getKey())+score;
					writer.write(entry.getKey() + ":" + entry.getValue()+ ":" +totalScore+":"+userGameMap.get(entry.getKey())+":"+(userWinMap.get(entry.getKey())+1));
			        writer.newLine();
				}
				else {
					writer.write(entry.getKey() + ":" + entry.getValue()+ ":" +userScoreMap.get(entry.getKey())+":"+(userGameMap.get(entry.getKey())+1)+":"+userWinMap.get(entry.getKey()));
			        writer.newLine();
			    }
			}
		}
	}
	//Add game count +1 to players stats
	public void addGameCount(HashMap<String, Integer> userScoreMap, HashMap<String, String> userpasswordMap, HashMap<String, Integer> userGameMap, HashMap<String, Integer> userWinMap) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("txts/Accounts.txt"))) {
			for (HashMap.Entry<String, String> entry : userpasswordMap.entrySet()) {
				if (entry.getKey().equalsIgnoreCase(name)) {
					writer.write(entry.getKey() + ":" + entry.getValue()+ ":" +userScoreMap.get(entry.getKey())+":"+(userGameMap.get(entry.getKey())+1)+":"+userWinMap.get(entry.getKey()));
			        writer.newLine();
				}
				else {
					writer.write(entry.getKey() + ":" + entry.getValue()+ ":" +userScoreMap.get(entry.getKey())+":"+userGameMap.get(entry.getKey())+":"+userWinMap.get(entry.getKey()));
			        writer.newLine();
			    }
			}
		}
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void addCard(Card card){
		hand.add(card);
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
}
