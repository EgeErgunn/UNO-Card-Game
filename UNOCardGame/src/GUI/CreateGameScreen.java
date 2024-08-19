package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import cardDeck.ActionCard;
import cardDeck.Card;
import cardDeck.ColoredCard;
import cardDeck.Deck;
import cardDeck.WildCard;
import mainGame.GameSession;
import player.Bot;
import player.Player;
import player.You;

public class CreateGameScreen extends javax.swing.JFrame {
	private javax.swing.JPanel jPanel1;
    private javax.swing.JButton newGame;
    private javax.swing.JButton continueGame;
    private javax.swing.JTextField gameName;
    
    private ArrayList<Player> players;
    private ArrayList<ArrayList<Card>> playerHands;
    private Deck deck;
    private String sessionName;
    private You you;
    private Card centerCard;
    boolean isUserHaveGame = false;
    
    public CreateGameScreen(ArrayList<Player> players) {
    	this.you = (You) players.get(0);
    	this.players = players;
        initComponents();
    }

    private void initComponents() { //Initialize componenents

        jPanel1 = new javax.swing.JPanel();
        newGame = new javax.swing.JButton();
        continueGame = new javax.swing.JButton();
        gameName = new javax.swing.JTextField();
        
        jPanel1.setBackground(new Color(0, 0, 102));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(700,300);
        ImageIcon image = new ImageIcon("images/UnoIcon.png");
        setIconImage(image.getImage());

        newGame.setText("NEW GAME");
        newGame.setFocusable(false);
        newGame.setFont(new Font("Showcard Gothic",Font.ITALIC,20));
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					newGameActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        continueGame.setText("CONTINUE GAME");
        continueGame.setFocusable(false);
        continueGame.setFont(new Font("Showcard Gothic",Font.ITALIC,20));
        continueGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					continueGameActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        gameName.setText("Name the Game Session");
        gameName.setFont(new Font("Times New Roman",Font.BOLD,12));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(continueGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gameName, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(newGame, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(continueGame, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    private void newGameActionPerformed(ActionEvent evt) throws IOException { //Creates a new game with the intended bots name
    	you.resetHand();
		this.dispose();
		new GameSession(gameName.getText(),new Deck(), players);
	}
    private void continueGameActionPerformed(ActionEvent evt) throws IOException { //Creates the continuing game
    	LoadGameVariables();
    	if (isUserHaveGame) {
    		this.dispose();
    		new GameSession (you, sessionName, deck, players, playerHands, centerCard);
    	}
	}

	private void LoadGameVariables() throws FileNotFoundException, IOException  { //Converts the continuing game variables from text to Object!!
		You you = (You) players.get(0);
		try (BufferedReader reader = new BufferedReader(new FileReader("txts/SavedGames.txt"))) {
			String line ;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(":");
				if (parts[0].equalsIgnoreCase(you.getName())) {
					isUserHaveGame = true;
					this.you = you;
					this.sessionName = parts[1];
					this.deck = createDeck(parts[2].split(", "));
					this.players = createPlayers(parts[3].split(", "));
					this.playerHands = createPlayerhands(parts[4].split("/"));
					this.centerCard = createCenterCard(parts[5]);
				}
			}
		}
		if (!isUserHaveGame) {
			JOptionPane.showMessageDialog(null, "You do not have a continuing game session");
		}
	}

	private Card createCenterCard(String centerCardString) { //Creating centerCard object
		String[] cardParts = centerCardString.split(" ");
		if (cardParts.length == 2) {
			String cardColor = cardParts[0];
	    	String cardValue = cardParts[1];
			if (cardValue.equals("Reverse") || cardValue.equals("DrawTwo") || cardValue.equals("Skip")) {
				return new ActionCard(cardValue, cardColor);
			}
			else {
				return new ColoredCard(cardValue, cardColor);
			}
		}
		else {
			String cardValue = cardParts[0];
			return new WildCard(cardValue);
		}
	}

	private ArrayList<ArrayList<Card>> createPlayerhands(String[] handsArray) { //Creating player cards object
		ArrayList<ArrayList<Card>> playerHands = new ArrayList<ArrayList<Card>>();
		for (String playerHandString : handsArray) {
			String[] playerHandArray = playerHandString.split(", ");
			ArrayList<Card> playerHandToAdd = new ArrayList<Card>();
			for (String card : playerHandArray) {
				String[] cardParts = card.split(" ");
				if (cardParts.length == 2) {
					String cardColor = cardParts[0];
			    	String cardValue = cardParts[1];
					if (cardValue.equals("Reverse") || cardValue.equals("DrawTwo") || cardValue.equals("Skip")) {
						Card cardToAdd = new ActionCard(cardValue, cardColor);
						playerHandToAdd.add(cardToAdd);
					}
					else {
						Card cardToAdd = new ColoredCard(cardValue, cardColor);
						playerHandToAdd.add(cardToAdd);
					}
				}
				else {
					String cardValue = cardParts[0];
					Card cardToAdd = new WildCard(cardValue);
					playerHandToAdd.add(cardToAdd);
				}
	        }
			playerHands.add(playerHandToAdd);
		}
		return playerHands;
	}

	private ArrayList<Player> createPlayers(String[] playersToCreate) { //Creating players
		ArrayList<Player> playersToAdd = new ArrayList<Player>();
		for (String player : playersToCreate) {
			if (you.getName().equalsIgnoreCase(player)) {
				playersToAdd.add(you);
			}
			else {
				playersToAdd.add(new Bot(player));
			}
		}
		return playersToAdd;
	}

	private Deck createDeck(String[] deckCards) { //Creating deck
		Deck deck = new Deck();
		for (String card : deckCards) {
			String[] cardParts = card.split(" ");
			if (cardParts.length == 2) {
				String cardColor = cardParts[0];
		    	String cardValue = cardParts[1];
				if (cardValue.equals("Reverse") || cardValue.equals("DrawTwo") || cardValue.equals("Skip")) {
					Card cardToAdd = new ActionCard(cardValue, cardColor);
					deck.getCards().add(cardToAdd);
				}
				else {
					Card cardToAdd = new ColoredCard(cardValue, cardColor);
					deck.getCards().add(cardToAdd);
				}
			}
			else {
				String cardValue = cardParts[0];
				Card cardToAdd = new WildCard(cardValue);
				deck.getCards().add(cardToAdd);
			}
        }
		return deck;
	}
}
