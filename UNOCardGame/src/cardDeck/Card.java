package cardDeck;

public abstract class Card implements CardInterface{ //There can not be just Card object it should be either colored card, wild card or action card so it is abstract
	protected String cardValue;
	protected boolean playable = false; //Playable depends on center card
	
	public Card(String CardValue) {
		this.cardValue = CardValue;
		
	}
	
	public String getCardValue() {
		return cardValue;
	}

	public boolean isPlayable() {
		return playable;
	}

	public void setPlayable(boolean playable) {
		this.playable = playable;
	}
	
	public String toString() {
		return cardValue;
	}
	
}
