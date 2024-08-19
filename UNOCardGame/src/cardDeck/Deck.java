package cardDeck;

import java.util.ArrayList;
import java.util.Collections;

import player.Player;

public class Deck {
	private ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
	}
	
	public void reset() { //Creates a deck, add every card needed
		String[] colors = {"Red","Blue","Yellow","Green"};
		String[] numbers = {"0","1","1","2","2","3","3","4","4","5","5","6","6","7","7","8","8","9","9"};
		String[] actions = {"Skip","Skip","Reverse","Reverse","DrawTwo","DrawTwo"};
		
		for (String color : colors) {
			for (String number : numbers) {
				cards.add(new ColoredCard(number,color));
			}
			for (String action : actions) {
				cards.add(new ActionCard(action,color));
			}
		}
		for (int i=0; i<4;i++) {
			cards.add(new WildCard("Wild"));
			cards.add(new WildCard("WildDrawFour"));
		}
	}
	
	public void shuffle() { 
		Collections.shuffle(cards);
	}
	public void removeCards(ArrayList<Card> notPileCards) { //This is for reshufling: it removes a arrayList of cards from the current deck's cards
		ArrayList<String> values = new ArrayList<String>();
		for (Card card1 : notPileCards) {
			values.add(card1.getCardValue());
		}
		ArrayList<Card> cardsToRemove = new ArrayList<Card>();
		for (Card card2 : cards) {
			if (values.contains(card2.getCardValue())) {
				values.remove(card2.getCardValue());
				cardsToRemove.add(card2);
			}
		}
		cards.removeAll(cardsToRemove);
	}
	
	public void drawCard(Player player) {
		player.addCard(cards.get(0));
		cards.remove(0);
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
}
					