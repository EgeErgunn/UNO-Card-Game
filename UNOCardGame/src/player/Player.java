package player;

import java.util.ArrayList;

import cardDeck.Card;

public abstract class Player implements PlayerInterface { //There can not be any Player object it need to be either bot or you(user) so its abstract
	protected String name;
	protected ArrayList<Card> hand;
	protected int totalScore;
	protected boolean saidUno = false;
	
	public Player(String name) {
		this.name = name;
		this.totalScore = 0;
		hand = new ArrayList<Card>();
	}
	public void resetHand() {
		hand = new ArrayList<Card>();
	}
	public int getTotalScore() {
		return totalScore;
	}
	public boolean isSaidUno() {
		return saidUno;
	}
	public void setSaidUno(boolean saidUno) {
		this.saidUno = saidUno;
	}
	public void addCard(Card card){
		hand.add(card);
	}
	public void removeCard(Card card) {
		hand.remove(card);
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name;
	}
}
