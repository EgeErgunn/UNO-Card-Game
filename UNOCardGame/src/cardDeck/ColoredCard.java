package cardDeck;

public class ColoredCard extends Card {
	protected String cardColor;
	
	public  ColoredCard(String CardValue, String CardColor) {
		super(CardValue);
		this.cardColor = CardColor;
	}
	@Override
	public String toString() {
		return cardColor+" "+cardValue;
	}
	public String getCardColor() {
		return cardColor;
	}
	public void setCardColor(String cardColor) {
		this.cardColor = cardColor;
	}

	
	
}
