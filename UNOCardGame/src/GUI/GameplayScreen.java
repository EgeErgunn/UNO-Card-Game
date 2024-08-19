package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import cardDeck.Card;
import cardDeck.ColoredCard;
import mainGame.GameSession;
import player.Player;
import player.You;

public class GameplayScreen extends javax.swing.JFrame {
	
	private javax.swing.JTextPane AbdulrezzakCardLeft;
    private javax.swing.JTextPane AbdulrezzakPane;
    private javax.swing.JTextPane AndrewCardLeft;
    private javax.swing.JTextPane AndrewPane;
    private javax.swing.JTextPane AtillaCardLeft;
    private javax.swing.JTextPane AtillaPane;
    private javax.swing.JTextPane AylanurCardLeft;
    private javax.swing.JTextPane AylanurPane;
    private javax.swing.JButton Card1;
    private javax.swing.JButton Card10;
    private javax.swing.JButton Card11;
    private javax.swing.JButton Card12;
    private javax.swing.JButton Card13;
    private javax.swing.JButton Card14;
    private javax.swing.JButton Card15;
    private javax.swing.JButton Card16;
    private javax.swing.JButton Card2;
    private javax.swing.JButton Card3;
    private javax.swing.JButton Card4;
    private javax.swing.JButton Card5;
    private javax.swing.JButton Card6;
    private javax.swing.JButton Card7;
    private javax.swing.JButton Card8;
    private javax.swing.JButton Card9;
    private javax.swing.JButton CenterCard;
    private javax.swing.JButton Deck;
    private javax.swing.JTextPane DoğanCardLeft;
    private javax.swing.JTextPane DoğanPane;
    private javax.swing.JTextPane GöktürkCardLeft;
    private javax.swing.JTextPane GöktürkPane;
    private javax.swing.JTextPane HamzaCardLeft;
    private javax.swing.JTextPane HamzaPane;
    private javax.swing.JButton SaveGameAndExit;
    private javax.swing.JButton UNO;
    private javax.swing.JTextPane VahidedhPane;
    private javax.swing.JTextPane VahidehCardLeft;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextPane ÖznurCardLeft;
    private javax.swing.JTextPane ÖznurPane;
    private javax.swing.JButton[] cardButtons;
    private javax.swing.JTextPane[] cardLeftPanes;
    private javax.swing.JTextPane[] namePanes;
    private JLabel textLabel ;
    private ArrayList<Player> players;
    private String gameName;
    private GameSession game;
    
    public GameplayScreen(GameSession game) {
    	this.setVisible(true);
    	this.game = game;
    	this.gameName = game.getSessionName();
    	this.players = game.getPlayers();
    	initComponents(players);
    }
    
    private void initComponents(ArrayList<Player> players) { //Initialize components

        jPanel2 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("images/GameplayBackground.jpg");
                g.drawImage(background.getImage(), 0, 0, this);
            }
        };
        Card9 = new javax.swing.JButton();
        Card10 = new javax.swing.JButton();
        Card11 = new javax.swing.JButton();
        Card12 = new javax.swing.JButton();
        Card13 = new javax.swing.JButton();
        Card14 = new javax.swing.JButton();
        Card15 = new javax.swing.JButton();
        Card16 = new javax.swing.JButton();
        UNO = new javax.swing.JButton();
        Deck = new javax.swing.JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("images/unoCard.png");
                g.drawImage(background.getImage(), 0, 0, this);
            }
        };
        CenterCard = new javax.swing.JButton();
        Card1 = new javax.swing.JButton();
        Card2 = new javax.swing.JButton();
        Card3 = new javax.swing.JButton();
        Card4 = new javax.swing.JButton();
        Card5 = new javax.swing.JButton();
        Card6 = new javax.swing.JButton();
        Card7 = new javax.swing.JButton();
        Card8 = new javax.swing.JButton();
        SaveGameAndExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AbdulrezzakCardLeft = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        HamzaCardLeft = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        VahidehCardLeft = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        AndrewPane = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        AylanurPane = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        ÖznurPane = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        GöktürkCardLeft = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        DoğanCardLeft = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        AtillaCardLeft = new javax.swing.JTextPane();
        jScrollPane10 = new javax.swing.JScrollPane();
        AbdulrezzakPane = new javax.swing.JTextPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        HamzaPane = new javax.swing.JTextPane();
        jScrollPane12 = new javax.swing.JScrollPane();
        VahidedhPane = new javax.swing.JTextPane();
        jScrollPane13 = new javax.swing.JScrollPane();
        AylanurCardLeft = new javax.swing.JTextPane();
        jScrollPane14 = new javax.swing.JScrollPane();
        AndrewCardLeft = new javax.swing.JTextPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        ÖznurCardLeft = new javax.swing.JTextPane();
        jScrollPane16 = new javax.swing.JScrollPane();
        GöktürkPane = new javax.swing.JTextPane();
        jScrollPane17 = new javax.swing.JScrollPane();
        DoğanPane = new javax.swing.JTextPane();
        jScrollPane18 = new javax.swing.JScrollPane();
        AtillaPane = new javax.swing.JTextPane();
        textLabel = new JLabel("Draw ("+String.valueOf(game.getDeck().getCards().size())+")");
        
        this.cardButtons = new javax.swing.JButton[]{Card1, Card2, Card3, Card4, Card5, Card6, Card7, Card8, Card9, Card10, Card11, Card12, Card13, Card14, Card15, Card16};
        this.cardLeftPanes = new javax.swing.JTextPane[] {DoğanCardLeft, ÖznurCardLeft, GöktürkCardLeft, AtillaCardLeft, AbdulrezzakCardLeft, HamzaCardLeft, AndrewCardLeft, VahidehCardLeft, AylanurCardLeft};
        this.namePanes = new javax.swing.JTextPane[] {DoğanPane, ÖznurPane, GöktürkPane, AtillaPane, AbdulrezzakPane, HamzaPane, AndrewPane, VahidedhPane, AylanurPane};

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(700,300);
        setBackground(new java.awt.Color(204, 255, 204));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);
        setMaximumSize(new java.awt.Dimension(1720, 1100));
        setMinimumSize(new java.awt.Dimension(1720, 1100));
        setPreferredSize(new java.awt.Dimension(1720, 1100));
        setResizable(false);
        setTitle(gameName);
        ImageIcon image = new ImageIcon("images/UnoIcon.png");
        setIconImage(image.getImage());

        jPanel2.setBackground(new java.awt.Color(200, 245, 206));

        Card9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card9ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        Card10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card10ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        Card11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card11ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        Card12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card12ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        Card13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card13ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        Card14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card14ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        Card15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card15ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        UNO.setText("UNO");
        UNO.setFont(new Font("Cooper Black",Font.BOLD, 25));
        UNO.setBackground(Color.black);
        UNO.setForeground(Color.white);
        UNO.setFocusable(false);
        UNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UNOActionPerformed(evt);
            }
        });

        Deck.setFocusable(false);
        Deck.setText("Draw\n"+String.valueOf(game.getDeck().getCards().size()));
        textLabel.setFont(new Font("Arial Black",Font.BOLD,10));
        textLabel.setForeground(Color.black);
        textLabel.setOpaque(true);
        textLabel.setBackground(Color.white);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        Deck.add(textLabel);
        Deck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					DeckActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        CenterCard.setFocusable(false);
        CenterCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CenterCardActionPerformed(evt);
            }
        });

        Card1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card1ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        Card2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card2ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        Card3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card3ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        Card4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card4ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        Card5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card5ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        Card6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card6ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        Card7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card7ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        Card8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card8ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
        
        Card16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					Card16ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        SaveGameAndExit.setFocusable(false);
        SaveGameAndExit.setText("<html>Save<br>&<br>Exit</html>");
        SaveGameAndExit.setFont(new Font("Cooper Black",Font.BOLD, 30));
        SaveGameAndExit.setBackground(Color.black);
        SaveGameAndExit.setForeground(Color.white);
        SaveGameAndExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					SaveAndExitActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
        
        for (JButton button : cardButtons) {
        	button.setFocusable(false);
        	button.setFont(new Font("Cooper Black", Font.BOLD,12));
        }
        
        jScrollPane1.setViewportView(AbdulrezzakCardLeft);
        AbdulrezzakPane.setText("Abdulrezzak");
        jScrollPane10.setViewportView(AbdulrezzakPane);
        AbdulrezzakCardLeft.setVisible(false);
        AbdulrezzakPane.setVisible(false);
        AbdulrezzakCardLeft.setEditable(false);
        AbdulrezzakPane.setEditable(false);
        AbdulrezzakPane.setFont(new Font("Times New Roman",Font.BOLD,15));

        jScrollPane3.setViewportView(VahidehCardLeft);
        VahidedhPane.setText("Vahideh");
        jScrollPane12.setViewportView(VahidedhPane);
        VahidehCardLeft.setVisible(false);
        VahidedhPane.setVisible(false);
        VahidehCardLeft.setEditable(false);
        VahidedhPane.setEditable(false);
        VahidedhPane.setFont(new Font("Times New Roman",Font.BOLD,15));

        AylanurPane.setText("Aylanur");
        jScrollPane5.setViewportView(AylanurPane);
        jScrollPane13.setViewportView(AylanurCardLeft);
        AylanurCardLeft.setVisible(false);
        AylanurPane.setVisible(false);
        AylanurCardLeft.setEditable(false);
        AylanurPane.setEditable(false);
        AylanurPane.setFont(new Font("Times New Roman",Font.BOLD,15));
        

        ÖznurPane.setText("Öznur");
        jScrollPane6.setViewportView(ÖznurPane);
        jScrollPane15.setViewportView(ÖznurCardLeft);
        ÖznurCardLeft.setVisible(false);
        ÖznurPane.setVisible(false);
        ÖznurCardLeft.setEditable(false);
        ÖznurPane.setEditable(false);
        ÖznurPane.setFont(new Font("Times New Roman",Font.BOLD,15));

        jScrollPane7.setViewportView(GöktürkCardLeft);
        GöktürkPane.setText("Göktürk");
        jScrollPane16.setViewportView(GöktürkPane);
        GöktürkCardLeft.setVisible(false);
        GöktürkPane.setVisible(false);
        GöktürkCardLeft.setEditable(false);
        GöktürkPane.setEditable(false);
        GöktürkPane.setFont(new Font("Times New Roman",Font.BOLD,15));

        jScrollPane8.setViewportView(DoğanCardLeft);
        DoğanPane.setText("Doğan");
        jScrollPane17.setViewportView(DoğanPane);
        DoğanCardLeft.setVisible(false);
        DoğanPane.setVisible(false);
        DoğanCardLeft.setEditable(false);
        DoğanPane.setEditable(false);
        DoğanPane.setFont(new Font("Times New Roman",Font.BOLD,15));

        HamzaPane.setText("Hamza");
        jScrollPane11.setViewportView(HamzaPane);
        jScrollPane2.setViewportView(HamzaCardLeft);
        HamzaCardLeft.setVisible(false);
        HamzaPane.setVisible(false);
        HamzaCardLeft.setEditable(false);
        HamzaPane.setEditable(false);
        HamzaPane.setFont(new Font("Times New Roman",Font.BOLD,15));

        jScrollPane14.setViewportView(AndrewCardLeft);
        AndrewPane.setText("Andrew");
        jScrollPane4.setViewportView(AndrewPane);
        AndrewCardLeft.setVisible(false);
        AndrewPane.setVisible(false);
        AndrewCardLeft.setEditable(false);
        AndrewPane.setEditable(false);
        AndrewPane.setFont(new Font("Times New Roman",Font.BOLD,15));

        AtillaPane.setText("Attila");
        jScrollPane18.setViewportView(AtillaPane);
        jScrollPane9.setViewportView(AtillaCardLeft);
        AtillaCardLeft.setVisible(false);
        AtillaPane.setVisible(false);
        AtillaCardLeft.setEditable(false);
        AtillaPane.setEditable(false);
        AtillaPane.setFont(new Font("Times New Roman",Font.BOLD,15));
        
        for (Player player : players) { //Activates the proper bots Texts
            if (player.getName().equalsIgnoreCase("Doğan")) {
                DoğanCardLeft.setVisible(true);
                DoğanPane.setVisible(true);
            }
            else if (player.getName().equalsIgnoreCase("Öznur")) {
                	ÖznurCardLeft.setVisible(true);
                    ÖznurPane.setVisible(true);
            }
            else if (player.getName().equalsIgnoreCase("Attila")) {
                	AtillaCardLeft.setVisible(true);
                    AtillaPane.setVisible(true);
            }
            else if (player.getName().equalsIgnoreCase("Vahideh")) {
                	VahidehCardLeft.setVisible(true);
                    VahidedhPane.setVisible(true);
            }
            else if (player.getName().equalsIgnoreCase("Andrew")) {
                	AndrewCardLeft.setVisible(true);
                    AndrewPane.setVisible(true);
            }
            else if (player.getName().equalsIgnoreCase("Hamza")) {
                	HamzaCardLeft.setVisible(true);
                    HamzaPane.setVisible(true);
            }
            else if (player.getName().equalsIgnoreCase("Abdulrezzak")) {
                	AbdulrezzakCardLeft.setVisible(true);
                    AbdulrezzakPane.setVisible(true);
            }
            else if (player.getName().equalsIgnoreCase("Aylanur")) {
                	AylanurCardLeft.setVisible(true);
                    AylanurPane.setVisible(true);
            }
            else if (player.getName().equalsIgnoreCase("Göktürk")) {
                	GöktürkCardLeft.setVisible(true);
                    GöktürkPane.setVisible(true);
            }}

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Card1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Card9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Card10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Card11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Card3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Card4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Card12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Card13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Card5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Card14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Card6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Card15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Card7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Card16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Card8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(UNO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SaveGameAndExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(269, 269, 269)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane11)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(590, 590, 590)
                        .addComponent(Deck, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(CenterCard, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jScrollPane8)
                            .addComponent(jScrollPane9)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane18))))
                .addGap(62, 62, 62))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Card2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CenterCard, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Deck, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(180, 180, 180)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SaveGameAndExit, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Card8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Card7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Card6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Card5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Card3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Card4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Card10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Card9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Card15, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(Card16, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addComponent(Card14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Card13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Card12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Card11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UNO, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }                     

    // Playing cards with cards buttons
    private void Card9ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                      
        game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(8));
    }                                     

    private void Card10ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                       
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(9));
    }                                      

    private void Card12ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                       
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(11));
    }                                      

    private void Card11ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                       
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(10));
    }                                      

    private void Card14ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                       
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(13));
    }                                                                        

    private void Card15ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                       
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(14));
    }                                      

    private void Card13ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                       
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(12));
    }                                                                               

    private void Card3ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                      
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(2));
    }                                     

    private void Card4ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                      
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(3));
    }                                     

    private void Card5ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                      
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(4));
    }                                     

    private void Card6ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                      
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(5));
    }                                     

    private void Card7ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                      
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(6));
    }                                     

    private void Card8ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                      
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(7));
    }                                                                            

    private void Card1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                      
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(0));
    }                                     

    private void Card2ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                      
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(1));
    }  
    
    private void Card16ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                      
    	game.playCard(game.getPlayers().get(game.getRoundIndex()).getHand().get(15));
    } 
    private void CenterCardActionPerformed(java.awt.event.ActionEvent evt) {    //Get information about the game color and the clockwise
    	if (players.get(0) instanceof You) {
    		JOptionPane.showMessageDialog(this, "The current color is "+game.getCenterCardColor()+". The game direction is counter-clockwise");
    	}
    	else {
    		JOptionPane.showMessageDialog(this, "The current color is "+game.getCenterCardColor()+". The game direction is clockwise");
    	}
    }
    private void SaveAndExitActionPerformed(java.awt.event.ActionEvent evt) throws IOException {   //Saves game and returns to Menu page                                      
    	game.Save();
    	dispose();
    	new Menu((You) game.getYou()).setVisible(true);
    } 
    private void UNOActionPerformed(java.awt.event.ActionEvent evt) { //Says Uno for the player                                   
        game.getYou().setSaidUno(true);
    }
    private void DeckActionPerformed(java.awt.event.ActionEvent evt) throws IOException {  //Draw card from the deck
        game.DrawCardAndSkipTurn(game.getPlayers().get(game.getRoundIndex()));
    }
    public void preventCardPlay() { //Prevent card draw
    	Deck.setEnabled(false);
    }
    public void ColorHandCards(ArrayList<Card> cards) { //Color the hand buttons as the players hand
    	if (cards.size()>16) {
    		return;
    	}
    	else {
    		for (JButton button : cardButtons) {
        		button.setBackground(null);
        		button.setText(null);
        		button.setOpaque(false);
        	}
        	int i=0;
        	for (Card card : cards) {
        		if (card instanceof ColoredCard) {
        			ColoredCard colorCard = (ColoredCard) card;
        			if (colorCard.getCardColor().equalsIgnoreCase("Red")) {
        				cardButtons[i].setBackground(Color.RED);
        				cardButtons[i].setOpaque(true);
        			}
        			else if (colorCard.getCardColor().equalsIgnoreCase("Yellow")) {
        				cardButtons[i].setBackground(Color.YELLOW);
        				cardButtons[i].setOpaque(true);
        			}
        			else if (colorCard.getCardColor().equalsIgnoreCase("Blue")) {
        				cardButtons[i].setBackground(Color.BLUE);
        				cardButtons[i].setOpaque(true);
        			}
        			else {
        				cardButtons[i].setBackground(Color.GREEN);
        				cardButtons[i].setOpaque(true);
        			}
        		}
        		else {
        			cardButtons[i].setBackground(Color.BLACK);
        			cardButtons[i].setOpaque(true);
        		}
        		if (card.getCardValue().equalsIgnoreCase("Wild")) {
        			cardButtons[i].setText("W");
        			cardButtons[i].setForeground(Color.WHITE);
            		cardButtons[i].setFont(new Font("Bauhaus 93",Font.BOLD,45));
        		}
        		else if (card.getCardValue().equalsIgnoreCase("WildDrawFour")) {
        			cardButtons[i].setText("+4");
        			cardButtons[i].setForeground(Color.WHITE);
            		cardButtons[i].setFont(new Font("Bauhaus 93",Font.BOLD,40));
        		}
        		else if (card.getCardValue().equalsIgnoreCase("DrawTwo")) {
        			cardButtons[i].setText("+2");
        			cardButtons[i].setForeground(Color.BLACK);
            		cardButtons[i].setFont(new Font("Bauhaus 93",Font.BOLD,40));
        		}
        		else if (card.getCardValue().equalsIgnoreCase("Reverse")) {
        			cardButtons[i].setText("<");
        			cardButtons[i].setForeground(Color.BLACK);
            		cardButtons[i].setFont(new Font("Bauhaus 93",Font.BOLD,45));
        		}
        		else if (card.getCardValue().equalsIgnoreCase("Skip")) {
        			cardButtons[i].setText("S");
        			cardButtons[i].setForeground(Color.BLACK);
            		cardButtons[i].setFont(new Font("Bauhaus 93",Font.BOLD,45));
        		}
        		else {
        			cardButtons[i].setText(card.getCardValue());
        			cardButtons[i].setForeground(Color.BLACK);
            		cardButtons[i].setFont(new Font("Bauhaus 93",Font.BOLD,45));
        		}
        		i++;
        	}
    	}
    }
    public void ColorCenterCard(Card centerCard) { //Colors the center card as intended
    	if (centerCard instanceof ColoredCard) {
			ColoredCard colorCard = (ColoredCard) centerCard;
			if (colorCard.getCardColor().equalsIgnoreCase("Red")) {
				CenterCard.setBackground(Color.RED);
			}
			else if (colorCard.getCardColor().equalsIgnoreCase("Yellow")) {
				CenterCard.setBackground(Color.YELLOW);
			}
			else if (colorCard.getCardColor().equalsIgnoreCase("Blue")) {
				CenterCard.setBackground(Color.BLUE);
			}
			else {
				CenterCard.setBackground(Color.GREEN);
			}
    	}
		else {
			CenterCard.setBackground(Color.BLACK);
    	}
    	if (centerCard.getCardValue().equalsIgnoreCase("Wild")) {
    		CenterCard.setText("W");
    		CenterCard.setForeground(Color.WHITE);
    		CenterCard.setFont(new Font("Bauhaus 93",Font.BOLD,45));
		}
		else if (centerCard.getCardValue().equalsIgnoreCase("WildDrawFour")) {
			CenterCard.setText("+4");
			CenterCard.setForeground(Color.WHITE);
			CenterCard.setFont(new Font("Bauhaus 93",Font.BOLD,40));
		}
		else if (centerCard.getCardValue().equalsIgnoreCase("DrawTwo")) {
			CenterCard.setText("+2");
			CenterCard.setForeground(Color.BLACK);
			CenterCard.setFont(new Font("Bauhaus 93",Font.BOLD,40));
		}
		else if (centerCard.getCardValue().equalsIgnoreCase("Reverse")) {
			CenterCard.setText("<");
			CenterCard.setForeground(Color.BLACK);
			CenterCard.setFont(new Font("Bauhaus 93",Font.BOLD,45));
		}
		else if (centerCard.getCardValue().equalsIgnoreCase("Skip")) {
			CenterCard.setText("S");
			CenterCard.setForeground(Color.BLACK);
			CenterCard.setFont(new Font("Bauhaus 93",Font.BOLD,45));
		}
		else {
			CenterCard.setText(centerCard.getCardValue());
			CenterCard.setForeground(Color.BLACK);
			CenterCard.setFont(new Font("Bauhaus 93",Font.BOLD,45));
		}
    }
    public void UpdateCardPlayability(ArrayList<Card> cards) { //Enables the proper cards based from centerCard
    	if (cards.size()>16) {
    		return;
    	}
    	else {
    		for (JButton button : cardButtons) {
        		button.setEnabled(false);
        	}
        	int i=0;
        	for (Card card : cards) {
    			if (card.isPlayable()) {
    				cardButtons[i].setEnabled(true);
    			}
    			i++;
        	}
    	}
    }
    public void UpdateDeckCount() { //Update the deck count text
		textLabel.setText("Draw ("+String.valueOf(game.getDeck().getCards().size())+")");
    }
    public void UpdateBotText () { //Update the bot texts
    	for (Player player : players) {
        	for (int i = 0; i<9; i++) {
        		if (namePanes[i].getText().equalsIgnoreCase(player.getName())) {
        			cardLeftPanes[i].setText(String.valueOf(player.getHand().size()));
        		}
        	}
        }
    }
    public void updateTurnColor(Player player) { //Shows the who's turn is it by coloring the text field
    	for (JTextPane pane : namePanes) {
    		pane.setBackground(Color.WHITE);
    	}
    	if (player.getName().equalsIgnoreCase("Doğan")) {
            DoğanPane.setBackground(Color.ORANGE);
    	}
        else if (player.getName().equalsIgnoreCase("Öznur")) {
                ÖznurPane.setBackground(Color.ORANGE);
        }
        else if (player.getName().equalsIgnoreCase("Attila")) {
                AtillaPane.setBackground(Color.ORANGE);
        }
        else if (player.getName().equalsIgnoreCase("Vahideh")) {
                VahidedhPane.setBackground(Color.ORANGE);
        }
        else if (player.getName().equalsIgnoreCase("Andrew")) {
                AndrewPane.setBackground(Color.ORANGE);
        }
        else if (player.getName().equalsIgnoreCase("Hamza")) {
                HamzaPane.setBackground(Color.ORANGE);
        }
        else if (player.getName().equalsIgnoreCase("Abdulrezzak")) {
                AbdulrezzakPane.setBackground(Color.ORANGE);
        }
        else if (player.getName().equalsIgnoreCase("Aylanur")) {
                AylanurPane.setBackground(Color.ORANGE);
        }
        else if (player.getName().equalsIgnoreCase("Göktürk")) {
                GöktürkPane.setBackground(Color.ORANGE);
        }
    }
}