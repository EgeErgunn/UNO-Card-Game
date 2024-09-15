# UNO-Card-Game
Playing the UNO card game against bots


Application usage information:
+ Register/Login Guide
 - In my application register and login are very simple, if you want to register press “Register” then create your account, if you already have one then type your username and password and login.
 - Username must include only letters and numbers, you cannot create an account with same username.
+ User Info
 - Every user’s total score, number of played games, number of wins, number of losses, win ratio and score per game parameters are stored in a text file.
+ Menu Guide
 - Leader board ( for more detail look for leader board info)
 - Adding bots: if you want to create new game with bots, you must add bots in menu screen with toggle buttons.
 - Logout Button: Goes back to login screen.
 - Exit Button: EXITS
 - Play Button: Will open a screen, you can create new session with name or continue the last saved one.
 - Music On/Off(Toggle Button): Not usuable yet.
+ Game Session Gameplay
 - Card Symbols are: S = Skip, W= Wild Card, +2=DrawTwo, +4=WildDrawFour, <=Reverse,
 - You can play any playable card in your hand by pressing on Card image (Button).
 - If you do not have any playable card you should draw card from deck (which will draw card and skip your turn)
 - When you have 2 cards and one is playable, before playing the card press UNO button to say uno.
 - If you play any wild card, the color choose popup will appear just click on the color you want to choose.
 - To get information about the current color and the direction of the game. Press the center card (Button).
+ Saving/Loading Game Sessions
 - You can save & exit anytime by pressing “SAVE & EXIT” button. (Exits to menu)
 - If you want to play loaded game just press “PLAY” from menu, then press “CONTINUE GAME”.
+ Leader board (Info)
 - By clicking any user’s name, you can see the stats about that account.
 - Accounts are sorted according to total scores.
+ How to check log information
 - You can check the log from txts folder to Log.txt file but it will only store the last game played.

Project Design Description:
+ Class relations.
 - Card (abstract class, implements CardInterface)
 - ColorCard (extends Card)
 - WildCard (extends Card)
 - ActionCard (extends ColorCard)
 - Player (abstract class, implements PlayerInterface)
 - You (extends Player)
 - Bot (extends Player)
 - Deck (class)
 - GameSession(class)
 - UnoGameLog(class)
 - InvalidUsernamePassword(extends Exceptions)
 - And GUI classes (extends javax.swing.JFrame)
 
+ Inheritances, type hierarchies, interfaces, abstract classes
 - The parent and child class hierarchy is: Player class is father class to both Bot and You classes, Card class is father class for colored card and wild card classes, and colored card class is father class for action card class.
 - Card class implements CardInterface interface, Player class implements PlayerInterface interface.
 - Card and Player classes should not be creatable so they are abstract classes.
 
+ .txt file processing details
 - Accounts, game saves and log is written to a text file as a String.
 - When uploading accounts or game it takes as a string, then split by “:” then use the proper parts of the string array.
 - The game log stores the last played game as a text. (When uploading or saving or creating new game, log.txt text file deletes the current text)
 
+ Your game session loop implementation
 - The method nextPlayerTurn() handles the transition between turns.
 - The game keeps track of the current player using an index (roundIndex).
 - The current player (determined by roundIndex) plays a card using playCard(card).
 - The index is updated to point to the next player (roundIndex++).
 - Then it calls nextPlayerTurn() again, this way game will repeat recursively.
 - When it is user’s turn, it will not call nextPlayerTurn() but after playing any card or drawing a card will call nextPlayerTurn() again.
 
+ Your computer bot implementation
 - When its bot’s turn a method search for card’s playability in bot hand. When loop finds a card, it plays it and breaks the loop. If can’t find card to play it draws from pile.
 - If bot play’s any wild card, it chooses color randomly.

+ GUI components.
 - Register/Login Screen:
  * JPanel
  * JButtons
  * JTextField
  * JPasswordField
  * JOptionPane
 - Menu Screen:
  * JPanel
  * JButton
  * JToggleButton
  * JList
  * JScrollPane
  * JTextPane
  * JOptionPane
 - Create Game Screen:
  * JPanel
  * JButton
  * JTextField
 - GameplayScreen:
  * JPane
  * JButton
  * JTextPane
  * JScrollPane
  * JOptionPane

Installation
1. Clone the Repository
2. Open Eclipse.
3. Go to File > Import.
4. Select Git > Projects from Git and click Next.
5. Choose Clone URI and click Next.
6. Paste the repository URL into the URI field and the rest of the fields should auto-fill.
7. Click Next, select the branches you want (usually just the main or master branch), and click Next again.
8. Choose the local directory where you'd like to store the project, and click Finish.
9. Go to File > Import.
10. Select Existing Projects into Workspace under General and click Next.
11. Browse to the directory where you cloned the repository and click Finish. This will import the project into Eclipse.
12. Once the project is imported, find the Sudoku file.
13. Right-click the file in the Project Explorer.
14. Choose Run As > Java Application.
