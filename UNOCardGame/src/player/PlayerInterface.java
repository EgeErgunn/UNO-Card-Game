package player;

import cardDeck.Card;

public interface PlayerInterface {
    void resetHand();
    int getTotalScore();
    String getName();
    void addCard(Card card);
    void removeCard(Card card);
}
