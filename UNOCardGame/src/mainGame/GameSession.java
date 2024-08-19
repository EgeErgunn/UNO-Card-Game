package mainGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JOptionPane;

import GUI.GameplayScreen;
import GUI.Menu;
import GUI.UnoColorPopup;
import cardDeck.ActionCard;
import cardDeck.Card;
import cardDeck.ColoredCard;
import cardDeck.Deck;
import cardDeck.WildCard;
import player.Bot;
import player.Player;
import player.You;

public class GameSession  {
	private String sessionName;
	private ArrayList<Player> players;
	private Deck deck;
	private int roundIndex=0; //An indexer for Players
	private Card centerCard;
	private String centerCardColor;
	private String centerCardValue;
	private GameplayScreen screen;
	private You you;
	private HashMap<String, Integer> userScoreMap;
	private HashMap<String, String> userpasswordMap;
	private HashMap<String, Integer> userGameMap;
    private HashMap<String, Integer> userWinMap;
    private UnoGameLog unoLog;
	
  //New gameSession constructor; shuffle deck opens screen and then starts the game
	public GameSession(String sessionName, Deck deck, ArrayList<Player> players) throws IOException {
		this.sessionName = sessionName;
		this.deck = deck;
		this.unoLog = new UnoGameLog();
		deck.reset();
		deck.shuffle();
		this.players = players;
		this.you = (You) players.get(0);
		AccountsMapFromFile();
		this.screen = new GameplayScreen(this);
		startGameSession(this);
	}
	//Creating a continuing game constructor (with Method overload, I created different constructors); distrubute the player hands, opens screen, and let the next player play
	//This constructor also sets almost every variable that GameSession have
	public GameSession(You you, String sessionName, Deck deck, ArrayList<Player> players, ArrayList<ArrayList<Card>> playerHands, Card centerCard) throws IOException { 
		this.sessionName = sessionName;
		this.deck = deck;
		this.unoLog = new UnoGameLog();
		this.players = players;
		this.you = you;
		this.centerCard = centerCard;
		this.roundIndex = players.indexOf(you);
		unoLog.log("-----Uploaded Game-----");
		DistributePlayerHands(playerHands);
		AccountsMapFromFile();
		this.screen = new GameplayScreen(this);
		if (centerCard instanceof ColoredCard) {
			centerCardColor = ((ColoredCard) centerCard).getCardColor();
		}
		else {
			centerCardColor = "Red";
		}
		centerCardValue = centerCard.getCardValue();
		screen.ColorHandCards(you.getHand());
		screen.ColorCenterCard(centerCard);
		screen.UpdateBotText();
		updateCardsPlayability(players.get(roundIndex));
		nextPlayerTurn();
	}

	public void startGameSession(GameSession gameSession) throws IOException { //Starts game session; if center card is wild or drawtwo reshuffle the deck and let the next player play
		if (deck.getCards().get(0) instanceof WildCard || deck.getCards().get(0).getCardValue().equalsIgnoreCase("DrawTwo")) {
			deck.shuffle();
			startGameSession(this);
		}
		else {
			this.centerCard = deck.getCards().get(0);
			ColoredCard centerCard = (ColoredCard) deck.getCards().get(0);
			deck.getCards().remove(0);
			
			for (Player player : players) {
				for (int i=0; i<7; i++)  {
					deck.drawCard(player);
					screen.UpdateDeckCount();
				}
				}
			centerCardColor = centerCard.getCardColor();
			centerCardValue = centerCard.getCardValue();
		}
		screen.ColorHandCards(players.get(0).getHand());
		screen.ColorCenterCard(centerCard);
		screen.UpdateBotText();
		updateCardsPlayability(players.get(roundIndex));
		nextPlayerTurn();
	}
	public void updateCardsPlayability(Player player) { //Update the card's playable parameter (true or false) according to centerCard
		for (Card card : player.getHand()) {
			if (card instanceof ColoredCard) {
				ColoredCard colorCard = (ColoredCard) card;
				if (centerCardColor.equalsIgnoreCase(colorCard.getCardColor()) || centerCardValue.equalsIgnoreCase(colorCard.getCardValue())) {
					card.setPlayable(true);
				}
				else {
					card.setPlayable(false);
				}
			}
			else {
				card.setPlayable(true);
			}
		}
		screen.UpdateCardPlayability(player.getHand());
	}
	public void preventCardPlay() { //Prevent the user to play any card
		for (Card card : you.getHand()) {
			card.setPlayable(false);
		}
		screen.UpdateCardPlayability(you.getHand());
	}
	public void preventDrawCard() { //Prevent the user to draw card
		screen.preventCardPlay();
	}
	public void nextPlayerTurn() throws IOException { //Let the next player play
		screen.updateTurnColor(players.get(roundIndex)); //To understand who is playing
		you.setSaidUno(false); //Make the uno said false every turn
		if (isGameOver()) {
			finishGame(); 
		}
		else if (deck.getCards().size()==0) { //If the deck cards out of amount, reshuffle it 
			reshuffleDeck();
			nextPlayerTurn();
		}
		else if (you.getHand().size()>16) {
			//Basically do not continue playing
			//By not activating botPlay() method below
		}
		else {
			if (players.get(roundIndex) instanceof Bot) { //If the next user is bot, call botPlay() method
				botPlay();
			}
		}
	}

	public void playCard(Card card) throws IOException { //Plays a card
		Player currentPlayer = players.get(roundIndex); //Get current player
		boolean isSkipPlayed = false;
		currentPlayer.getHand().remove(card); //Remove card from player hand
		unoLog.log(currentPlayer+" played "+card); //Write to log
		if (currentPlayer instanceof You) {
		if (you.getHand().size()==1 && !(you.isSaidUno())){ //If user did not say UNO but have 2 cards and at least one is playable, give user a penalty
			DrawCard(players.get(roundIndex));
			DrawCard(players.get(roundIndex));
			screen.UpdateDeckCount();
		    int	nextPlayerIndex; 
			if (roundIndex==players.size()-1) {
				nextPlayerIndex = 0;
			}
			else {
				nextPlayerIndex = roundIndex+1;
			}
			JOptionPane.showMessageDialog(screen,players.get(nextPlayerIndex)+" catched "+players.get(roundIndex)+" did not say UNO,"+players.get(roundIndex)+" drew 2 cards for penalty");
		}
		screen.ColorHandCards(currentPlayer.getHand()); 
		}
		if (card instanceof  ColoredCard) {
			if (card.getCardValue().equalsIgnoreCase("DrawTwo")){ //Draw two effect
				if (roundIndex==players.size()-1) {
					deck.drawCard(players.get(0));
					deck.drawCard(players.get(0));
					screen.UpdateDeckCount();
				}
				else {
					deck.drawCard(players.get(roundIndex+1));
					deck.drawCard(players.get(roundIndex+1));
					screen.UpdateDeckCount();
				}
			}
			else if (card.getCardValue().equalsIgnoreCase("Skip")) { //Make skip effect true
				isSkipPlayed = true;
			}
			else if (card.getCardValue().equalsIgnoreCase("Reverse")){ //Reverse effect
				Collections. reverse(players);
				roundIndex = players.indexOf(currentPlayer);
			}
			this.centerCard = card;
			ColoredCard centerCard =(ColoredCard) card;
			this.centerCardColor = centerCard.getCardColor();
			this.centerCardValue = centerCard.getCardValue();
		}
		else {
			if (card.getCardValue().equalsIgnoreCase("WildDrawFour")) { //WildDrawFour effect
				if (roundIndex==players.size()-1) {
					deck.drawCard(players.get(0));
					deck.drawCard(players.get(0));
					deck.drawCard(players.get(0));
					deck.drawCard(players.get(0));
					screen.UpdateDeckCount();
				}
				else {
					deck.drawCard(players.get(roundIndex+1));
					deck.drawCard(players.get(roundIndex+1));
					deck.drawCard(players.get(roundIndex+1));
					deck.drawCard(players.get(roundIndex+1));
					screen.UpdateDeckCount();
				}
				if (players.get(roundIndex) instanceof You) {  //If user played wildrawfour choose color with popup
					new UnoColorPopup(this);
					this.centerCardValue = card.getCardValue();
					String color = centerCardColor;
					unoLog.log("   "+players.get(roundIndex)+" chose the color "+color);
				}
				else {
					this.centerCardColor = randomColor(); //If bot played Wilddrawfour it chooses randomly
					this.centerCardValue = card.getCardValue();
					String color = centerCardColor;
					unoLog.log("   "+players.get(roundIndex)+" chose the color "+color);
				}
			}
			else { //Else is just Wild card 
				if (players.get(roundIndex) instanceof You) { //If user played wild choose color with popup
					new UnoColorPopup(this);
					this.centerCardValue = card.getCardValue();
					String color = centerCardColor;
					unoLog.log("   "+players.get(roundIndex)+" chose the color "+color);
				}
				else {
					this.centerCardColor = randomColor(); //If bot played Wild it chooses randomly
					this.centerCardValue = card.getCardValue();
					String color = centerCardColor;
					unoLog.log("   "+players.get(roundIndex)+" chose the color "+color);
				}
			}
			this.centerCard = card; //Make the center card chosen card
		}
		if (roundIndex==players.size()-1) { //Increase roundIndex by 1
			roundIndex=0;
		}
		else {
			roundIndex++;
		}
		if (players.get(roundIndex) instanceof You) { //If the next player is user, color user's hands
			screen.ColorHandCards(players.get(roundIndex).getHand());
		}
		if (isSkipPlayed) { //Increase roundIndex nextPlayer cards update
			if (roundIndex==players.size()-1) {
				roundIndex=0;
			}
			else {
				roundIndex++;
			}
		}
		screen.ColorCenterCard(card);
		updateCardsPlayability(players.get(roundIndex));
		screen.UpdateBotText();
		if (isSkipPlayed) { //Then decrease it for popup index
			if (roundIndex==0) {
				roundIndex=players.size()-1;
			}
			else {
				roundIndex--;
			}
		}
		if (card instanceof  ColoredCard) { 
			infoPopupAndUpdateLog(card);
			if (isSkipPlayed) {
				if (roundIndex==players.size()-1) {
					roundIndex=0;
				}
				else {
					roundIndex++;
				}
			}
			nextPlayerTurn(); //Call this for nextPlayer play
		}
		else {
			infoPopupAndUpdateLog(card); /*The reason I seperated Color card and wild cards is when user wild card game will continue after color choose popup. 
			nextPlayerTurn() method is inside in color choose popup so it should not call the method here*/
			if (isSkipPlayed) {
				if (roundIndex==players.size()-1) {
					roundIndex=0;
				}
				else {
					roundIndex++;
				}
			}
			if (currentPlayer instanceof Bot) { //If user played a wild card, the game will continue inside the  popup method
				nextPlayerTurn(); //Call this for nextPlayer to play
			}
		} 
	}
	public static String randomColor() { //Random color selector for bots choosing color
		String[] colors = {"Red","Blue","Yellow","Green"};
        Random rand = new Random();
        int index = rand.nextInt(colors.length);
        return colors[index];
    }
	private void DistributePlayerHands(ArrayList<ArrayList<Card>> playerHands) { //This distrubutes card for uploaded games basicaly add proper cards to proper player's hands
		int i = 0;
		for (ArrayList<Card> hand : playerHands) {
			players.get(i).setHand(hand);
			i++;
		}
	}
	public void botPlay() throws IOException { //Bots play the first card that is playable else they draw
		preventCardPlay();
		Boolean cardPlayed = false;
		for (Card card : players.get(roundIndex).getHand()) {
			if (card.isPlayable()) {
				playCard(card);
				cardPlayed = true;
				break;
			}
		}
		if (!(cardPlayed)) {
			DrawCardAndSkipTurn(players.get(roundIndex));
		}
	}
	public void infoPopupAndUpdateLog(Card card) { //This is the info popup and log writer
		if (roundIndex==0) {
			if (card.getCardValue().equalsIgnoreCase("Reverse")) {
				unoLog.log("   The game direction is changed");
				JOptionPane.showMessageDialog(screen, players.get(players.size()-1)+" played a "+card+", the direction is changed!");
			}
			else if (card.getCardValue().equalsIgnoreCase("Skip")) {
				unoLog.log("   "+players.get(roundIndex)+" turn is skiped");
				JOptionPane.showMessageDialog(screen, players.get(players.size()-1)+" played a "+card+", "+players.get(roundIndex)+"'s turn is skipped!");
			}
			else if (card.getCardValue().equalsIgnoreCase("DrawTwo")) {
				unoLog.log("   "+players.get(roundIndex)+" drew 2 cards");
				JOptionPane.showMessageDialog(screen, players.get(players.size()-1)+" played a "+card+", "+players.get(roundIndex)+" drew 2 cards!");
			}
			else if (card.getCardValue().equalsIgnoreCase("WildDrawFour")) {
				unoLog.log("   "+players.get(roundIndex)+" drew 4 cards");
				JOptionPane.showMessageDialog(screen, players.get(players.size()-1)+" played a Wild Draw Four, "+players.get(roundIndex)+" drew 4 cards! "+players.get(players.size()-1)+" will choose the color");
				if (players.get(players.size()-1) instanceof Bot) {
					JOptionPane.showMessageDialog(screen, players.get(players.size()-1)+" chose "+centerCardColor);
				}
			}
			else if (card.getCardValue().equalsIgnoreCase("Wild")) {
				JOptionPane.showMessageDialog(screen, players.get(players.size()-1)+" played a Wild Card! "+ players.get(players.size()-1)+" will choose the color");
				if (players.get(players.size()-1) instanceof Bot) {
					JOptionPane.showMessageDialog(screen, players.get(players.size()-1)+" chose "+centerCardColor);
				}
			}
			else {
				JOptionPane.showMessageDialog(screen, players.get(players.size()-1)+" played a "+card+"!");
			}
			if (players.get(players.size()-1).getHand().size()==1) {
				JOptionPane.showMessageDialog(screen, players.get(players.size()-1)+" said UNO!");
			}
		}
		else {
			if (card.getCardValue().equalsIgnoreCase("Reverse")) {
				unoLog.log("  The game direction is changed");
				JOptionPane.showMessageDialog(screen, players.get(roundIndex-1)+" played a "+card+", the direction is changed!");
			}
			else if (card.getCardValue().equalsIgnoreCase("Skip")) {
				unoLog.log("   "+players.get(roundIndex)+" turn is skiped");
				JOptionPane.showMessageDialog(screen, players.get(roundIndex-1)+" played a "+card+", "+players.get(roundIndex)+"'s turn is skipped!");
			}
			else if (card.getCardValue().equalsIgnoreCase("DrawTwo")) {
				unoLog.log("   "+players.get(roundIndex)+" drew 2 cards");
				JOptionPane.showMessageDialog(screen, players.get(roundIndex-1)+" played a "+card+", "+players.get(roundIndex)+" drew 2 cards!");
			}
			else if (card.getCardValue().equalsIgnoreCase("WildDrawFour")) {
				unoLog.log("   "+players.get(roundIndex)+" drew 4 cards");
				JOptionPane.showMessageDialog(screen, players.get(roundIndex-1)+" played a Wild Draw Four, "+players.get(roundIndex)+" drew 4 cards! "+ players.get(roundIndex-1)+" will choose the color");
				if (players.get(roundIndex-1) instanceof Bot) {
					JOptionPane.showMessageDialog(screen, players.get(roundIndex-1)+" chose "+centerCardColor);
				}
			}
			else if (card.getCardValue().equalsIgnoreCase("Wild")) {
				JOptionPane.showMessageDialog(screen, players.get(roundIndex-1)+" played a Wild Card! "+ players.get(roundIndex-1)+" will choose the color");
				if (players.get(roundIndex-1) instanceof Bot) {
					JOptionPane.showMessageDialog(screen, players.get(roundIndex-1)+" chose "+centerCardColor);
				}
			}
			else {
				JOptionPane.showMessageDialog(screen, players.get(roundIndex-1)+" played a "+card+"!");
			}
			if (players.get(roundIndex-1).getHand().size()==1) {
				unoLog.log(" "+players.get(roundIndex-1)+" said UNO");
				JOptionPane.showMessageDialog(screen, players.get(roundIndex-1)+" said UNO!");
			}
		}
	}

	public void DrawCard(Player player) throws IOException { //Just draw cards (for +2 +4 effects and gameStart distribution)
		deck.drawCard(player);
		if (you.getHand().size()> 16) {
			finishGame();
		}
		else {
		updateCardsPlayability(player);
		screen.UpdateDeckCount();
		screen.ColorHandCards(player.getHand());
		}
	}
	public void DrawCardAndSkipTurn(Player player) throws IOException { //When draw from deck by manual it needs to skip turn
		unoLog.log(player+" drew a card");
		deck.drawCard(player);
		if (!(you.getHand().size()> 16)) {
			updateCardsPlayability(player);
		}
		if (you.getHand().size()> 16) {
			
		}
		else if (player instanceof You) {
			screen.ColorHandCards(player.getHand());
		}
		if (!(you.getHand().size()> 16)) {
			JOptionPane.showMessageDialog(screen, players.get(roundIndex)+" drew a card!");
			if (roundIndex==players.size()-1) { //Turn is skipping by incrementing roundIndex
				roundIndex=0;
			}
			else {
				roundIndex++;
			}
			updateCardsPlayability(players.get(roundIndex));
			screen.ColorCenterCard(centerCard);
			screen.UpdateBotText();
			screen.UpdateDeckCount();
		}
		nextPlayerTurn();
	}
	public void finishGame() throws IOException { //Finish
			preventCardPlay(); //Prevent every button
			preventDrawCard();
			you.addGameCount(userScoreMap, userpasswordMap, userGameMap, userWinMap);
			Player winner = null;
			for (Player player : players) { //Choosing winner
				if (player.getHand().size()==0) {
					winner = player;
				}
			}
			if (winner != null) { //If there is a winner
				int score = 0;
				for (Player player : players) {
					for (Card card : player.getHand()) { //Calculate totalScore
						if (card instanceof ActionCard) {
							score+=20;
						}
						else if (card instanceof ColoredCard) {
							score+= Integer.valueOf(card.getCardValue());
						}
						else {
							score+=50;
						}
					}
				}
				unoLog.log(winner+" won the game. Player's score is "+score); //Write to log
				if (winner instanceof You) { //If winner is user update the score to map
					AccountsMapFromFile();
					((You) winner).updateTotalScore(score, userScoreMap, userpasswordMap, userGameMap, userWinMap);
				}
				JOptionPane.showMessageDialog(screen, winner+" won the game. Player's score is "+score);
			}
			else if (you.getHand().size()>16) { //If game finished because of out of screen
				unoLog.log("You are out of screen");
				JOptionPane.showMessageDialog(screen, "Your cards are out of screen. Game is over");
			}
			screen.dispose();
			for (Player player : players) {
				player.resetHand(); //Reset every hand
			}
			unoLog.log("------------------------------");
			unoLog.close();
			new Menu(you).setVisible(true); //Return to Menu
		
	}
	public Boolean isGameOver() { //Check for the whether the game finished or not
		for (Player player : players) {
			if (player.getHand().size()==0) {
				return true;
			}
		}
		if (you.getHand().size()>16) {
			return true;
		}
		return false;
	}
	public void reshuffleDeck() { //this method makes a array with every player cards and center card then basically it removes this array from a normal uno deck to gain the pile cards
		JOptionPane.showMessageDialog(screen, "The deck is out of cards. Cards will be reshuffled");
		ArrayList<Card> notPileCards = new ArrayList<Card>();
		notPileCards.add(centerCard);
		for (Player player : players) {
			for (Card card : player.getHand()) {
				notPileCards.add(card);
			}
		}
		deck.reset();
		deck.shuffle();
		deck.removeCards(notPileCards);
		screen.UpdateDeckCount();
	}
	public void AccountsMapFromFile() throws IOException { //Creates account maps from text file
        userpasswordMap = new HashMap<>();
        userScoreMap = new HashMap<>();
        userGameMap = new HashMap<>();
        userWinMap = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("txts/Accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                userpasswordMap.put(parts[0].trim(), parts[1].trim());
                userScoreMap.put(parts[0].trim(), Integer.parseInt(parts[2].trim()));
                userGameMap.put(parts[0].trim(), Integer.parseInt(parts[3].trim()));
                userWinMap.put(parts[0].trim(), Integer.parseInt(parts[4].trim()));
            }
        }
    }
	//User:GameSessionName:Deck:players:players hands:center card
	public void Save() throws IOException { //Write down almost everything to text file to play another time
		unoLog.log("-----Game Have Been Saved-----");
		unoLog.close();
		try (BufferedReader reader = new BufferedReader(new FileReader("txts/SavedGames.txt"))) {
			StringBuilder fileText = new StringBuilder();
            String line;
            boolean isUserSaved = false;
            boolean isNewLineNeed= false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equalsIgnoreCase(you.getName())) {
                	isUserSaved = true;
                	StringBuilder playerHandsString = new StringBuilder();
                	for (Player player : players) {
                		playerHandsString.append(player.getHand()).append("/");
                	}
                	String newLine = you.getName()+":"+sessionName+":"+deck.getCards()+":"+players+":"+playerHandsString.toString()+":"+centerCard;
                	fileText.append(newLine).append("\n");
                }
                else {
                	fileText.append(line).append("\n");
                }
            }
            if (!(isUserSaved)) {
            	isNewLineNeed = true;
            	StringBuilder playerHandsString = new StringBuilder();
            	for (Player player : players) {
            		playerHandsString.append(player.getHand()).append("/");
            	}
            	String newLine = you.getName()+":"+sessionName+":"+deck.getCards()+":"+players+":"+playerHandsString.toString()+":"+centerCard;
            	fileText.append(newLine);
            }
            char charToDelete1 = '[';
            char charToDelete2 = ']';
            for (int i = 0; i < fileText.length(); i++) {
                if (fileText.charAt(i) == charToDelete1 || fileText.charAt(i) == charToDelete2) {
                    fileText.deleteCharAt(i);
                    i--;
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("txts/SavedGames.txt"))) {
		        writer.write(fileText.toString());
		        if (isNewLineNeed) {
		        	writer.newLine();
		        }
		    }
	}
}
	public GameplayScreen getScreen() {
		return screen;
	}
	public String getCenterCardColor() {
		return centerCardColor;
	}
	public void setCenterCardColor(String centerCardColor) {
		this.centerCardColor = centerCardColor;
	}
	public Player getYou() {
		return you;
	}
	public String getSessionName() {
		return sessionName;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public Deck getDeck() {
		return deck;
	}
	public int getRoundIndex() {
		return roundIndex;
	}
	public Card getCenterCard() {
		return centerCard;
	}
	public void setCenterCard(Card centerCard) {
		this.centerCard = centerCard;
	}
}
