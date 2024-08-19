package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import player.Bot;
import player.Player;
import player.You;

public class Menu extends javax.swing.JFrame {
    private javax.swing.JToggleButton You;
	private javax.swing.JToggleButton Abdulrezzak;
    private javax.swing.JToggleButton Andrew;
    private javax.swing.JToggleButton Atilla;
    private javax.swing.JToggleButton Aylanur;
    private javax.swing.JToggleButton Doğan;
    private javax.swing.JToggleButton Öznur;
    private javax.swing.JToggleButton Göktürk;
    private javax.swing.JToggleButton Hamza;
    private javax.swing.JToggleButton Vahideh;
    private javax.swing.JToggleButton Music;
    private javax.swing.JButton EXİT;
    private javax.swing.JButton PLAY;
    private javax.swing.JButton LOGOUT;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JToggleButton jToggleButton9;
    private int playerCount = 1;
    private ArrayList<Player> players;
    private Bot abdulrezzakBot;
    private Bot andrewBot;
    private Bot atillaBot;
    private Bot aylanurBot;
    private Bot doğanBot;
    private Bot göktürkBot;
    private Bot hamzaBot;
    private Bot vahidehBot;
    private Bot öznurBot;
    private You you;
    private HashMap<String, Integer> userScoreMap;
    private HashMap<String, Integer> userGameMap;
    private HashMap<String, Integer> userWinMap;

    public Menu(You account) throws IOException {
    	players = new ArrayList<Player>();
    	this.userScoreMap = new HashMap<String, Integer>();
    	this.you = account;
    	players.add(you);
    	AccountsMapFromFile();
        initComponents();
    }                         
    private void initComponents() { //Initialize components

        jToggleButton9 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) { //add background
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("images/redBackground.jpg");
                g.drawImage(background.getImage(), 0, 0, this);
            }
        };
        PLAY = new javax.swing.JButton();
        EXİT = new javax.swing.JButton();
        LOGOUT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Music = new javax.swing.JToggleButton();
        You = new javax.swing.JToggleButton();
        Öznur = new javax.swing.JToggleButton();
        Hamza = new javax.swing.JToggleButton();
        Aylanur = new javax.swing.JToggleButton();
        Doğan = new javax.swing.JToggleButton();
        Vahideh = new javax.swing.JToggleButton();
        Atilla = new javax.swing.JToggleButton();
        Andrew = new javax.swing.JToggleButton();
        Göktürk = new javax.swing.JToggleButton();
        Abdulrezzak = new javax.swing.JToggleButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();

        jToggleButton9.setText("jToggleButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(500,200);
        ImageIcon image = new ImageIcon("images/UnoIcon.png");
        setIconImage(image.getImage());
        
        jPanel1.setForeground(new java.awt.Color(16, 140, 105));
        jPanel1.setBackground(new Color(255, 107, 86));

        PLAY.setText("PLAY");
        PLAY.setFont(new Font("MV Boli", Font.BOLD, 12));
        PLAY.setFocusable(false);
        PLAY.setBackground(new java.awt.Color(255, 255, 153));
        PLAY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PLAYActionPerformed(evt);
            }
        });

        EXİT.setText("EXIT");
        EXİT.setFont(new Font("MV Boli", Font.BOLD, 12));
        EXİT.setFocusable(false);
        EXİT.setBackground(new java.awt.Color(255, 255, 153));
        EXİT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXİTActionPerformed(evt);
            }
        });

        LOGOUT.setText("LOGOUT");
        LOGOUT.setFont(new Font("MV Boli", Font.BOLD, 12));
        LOGOUT.setBackground(new java.awt.Color(255, 255, 153));
        LOGOUT.setFocusable(false);
        LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() { //Converts maps to LeaderBoard List
        	ArrayList<String> users = new ArrayList<String>();
        	{
        		TreeMap<Integer, ArrayList<String>> sortedMap = new TreeMap<>();
        		for (HashMap.Entry<String, Integer> entry : userScoreMap.entrySet()) {
        			String user = entry.getKey() + "'s total score is: " + entry.getValue();
        			int score = entry.getValue();
        			if (!sortedMap.containsKey(score)) {
                        sortedMap.put(score, new ArrayList<String>());
                    }
                    sortedMap.get(score).add(user);
        		}
        		for (Integer score : sortedMap.keySet()) {
                    ArrayList<String> usersWithScore = sortedMap.get(score);
                    for (String user : usersWithScore) {
                        users.add(user);
                    }
                }
        		Collections.reverse(users);
        	}
        	public int getSize() {return users.size(); }
        	public String getElementAt(int i) { return users.get(i); }
        	
        });
        
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);
        jList1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String[] name = jList1.getSelectedValue().split("'");
                    String selectedPlayer = name[0];
                    int numberOfWins = userWinMap.get(selectedPlayer);
                    int numberOfLoss = userGameMap.get(selectedPlayer)-userWinMap.get(selectedPlayer);
                    int totalScore = userScoreMap.get(selectedPlayer);
                    int numberOfGames = userGameMap.get(selectedPlayer);
                    float winRatio = 0;
                    float averageScore = 0;
                    if (numberOfGames!=0) {
                    	averageScore = (float) totalScore/numberOfGames;
                    }
                    if (numberOfGames!=0) {
                    	winRatio = ((float) numberOfWins/numberOfGames)*100;
                    }
                    
                    StringBuilder message = new StringBuilder();
                    message.append("Name: ").append(selectedPlayer).append("\n");
                    message.append("Number of Wins: ").append(numberOfWins).append("\n");
                    message.append("Number of Losses: ").append(numberOfLoss).append("\n");
                    message.append("Total Score: ").append(totalScore).append("\n");
                    message.append("Average Score Per Game: ").append(averageScore).append("\n");
                    message.append("Win Ratio: ").append(winRatio).append("%\n");
                    JOptionPane.showMessageDialog(null, message , "Player Stats", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        Music.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        Music.setFocusable(false);
        Music.setText("Music On/Off");
        Music.setBackground(new java.awt.Color(255, 255, 153));

        You.setText(you.getName());
        You.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12));
        You.setFocusable(false);
        You.setSelected(true);
        You.setEnabled(false);
        You.setBackground(new java.awt.Color(255, 255, 153));
        
        Öznur.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        Öznur.setBackground(new java.awt.Color(255, 255, 153));
        Öznur.setText("Öznur");
        Öznur.setFocusable(false);
        Öznur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ÖznurActionPerformed(evt);
            }
        });
        

        Hamza.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        Hamza.setBackground(new java.awt.Color(255, 255, 153));
        Hamza.setText("Hamza");
        Hamza.setFocusable(false);
        Hamza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HamzaActionPerformed(evt);
            }
        });

        Aylanur.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        Aylanur.setBackground(new java.awt.Color(255, 255, 153));
        Aylanur.setText("Aylanur");
        Aylanur.setFocusable(false);
        Aylanur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AylanurActionPerformed(evt);
            }
        });

        Doğan.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        Doğan.setBackground(new java.awt.Color(255, 255, 153));
        Doğan.setText("   Doğan      ");
        Doğan.setFocusable(false);
        Doğan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoğanActionPerformed(evt);
            }
        });

        Vahideh.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 10)); // NOI18N
        Vahideh.setBackground(new java.awt.Color(255, 255, 153));
        Vahideh.setText("Vahideh");
        Vahideh.setFocusable(false);
        Vahideh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VahidehActionPerformed(evt);
            }
        });

        Atilla.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        Atilla.setBackground(new java.awt.Color(255, 255, 153));
        Atilla.setText("Attila");
        Atilla.setFocusable(false);
        Atilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtillaActionPerformed(evt);
            }
        });

        Andrew.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        Andrew.setBackground(new java.awt.Color(255, 255, 153));
        Andrew.setText("Andrew");
        Andrew.setFocusable(false);
        Andrew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AndrewActionPerformed(evt);
            }
        });

        Göktürk.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        Göktürk.setBackground(new java.awt.Color(255, 255, 153));
        Göktürk.setText("Göktürk");
        Göktürk.setFocusable(false);
        Göktürk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GöktürkActionPerformed(evt);
            }
        });

        Abdulrezzak.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 10)); // NOI18N
        Abdulrezzak.setBackground(new java.awt.Color(255, 255, 153));
        Abdulrezzak.setText("Abdulrezzak");
        Abdulrezzak.setFocusable(false);
        Abdulrezzak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbdulrezzakActionPerformed(evt);
            }
        });

        jTextPane1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(255, 0, 0));
        jTextPane1.setBackground(new java.awt.Color(255, 255, 153));
        jTextPane1.setText("UNO");
        jTextPane1.setEditable(false);
        jScrollPane5.setViewportView(jTextPane1);

        jTextPane2.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        jTextPane2.setText("        Leader Board");
        jTextPane2.setEditable(false);
        jScrollPane6.setViewportView(jTextPane2);

        jTextPane3.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
        jTextPane3.setEditable(false);
        jTextPane3.setToolTipText("");
        jScrollPane2.setViewportView(jTextPane3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(379, 379, 379)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Music)
                .addGap(143, 143, 143))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PLAY, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LOGOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EXİT, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(178, 178, 178)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Öznur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Hamza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Aylanur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Doğan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(You, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Göktürk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Andrew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Vahideh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Abdulrezzak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Atilla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(Music)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(You, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Atilla, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Doğan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Göktürk, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Öznur, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Andrew, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Aylanur, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Vahideh, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Hamza, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Abdulrezzak, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(LOGOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(85, 85, 85))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(PLAY, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(EXİT, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }                      

    private void PLAYActionPerformed(java.awt.event.ActionEvent evt) {   //Opens the creating game session screen                                  
        this.dispose();
        new CreateGameScreen(players).setVisible(true);
    }                                    

    private void EXİTActionPerformed(java.awt.event.ActionEvent evt) {  //Exits                                   
    	System.exit(0);
    }                                    

    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) { //Returns to Login screen                                       
        this.dispose();
        try {
			new LoginScreen().setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public void AccountsMapFromFile() throws IOException { //Converts text file to maps
        userScoreMap = new HashMap<>();
        userGameMap = new HashMap<>();
        userWinMap = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("txts/Accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                userScoreMap.put(parts[0].trim(), Integer.parseInt(parts[2].trim()));
                userGameMap.put(parts[0].trim(), Integer.parseInt(parts[3].trim()));
                userWinMap.put(parts[0].trim(), Integer.parseInt(parts[4].trim()));
            }
        }
    }

     
    //Creates and adds bots to game with toggle buttons
    private void VahidehActionPerformed(java.awt.event.ActionEvent evt) {    
    	if (Vahideh.isSelected()) {
    		vahidehBot = new Bot("Vahideh");
    		playerCount++;
    		players.add(vahidehBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    	else {
    		playerCount--;
    		players.remove(vahidehBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    }                                       
    private void AbdulrezzakActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	if (Abdulrezzak.isSelected()) {
    		abdulrezzakBot = new Bot("Abdulrezzak");
    		playerCount++;
    		players.add(abdulrezzakBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    	else {
    		playerCount--;
    		players.remove(abdulrezzakBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    }
    private void ÖznurActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	if (Öznur.isSelected()) {
    		öznurBot =  new Bot("Öznur");
    		playerCount++;
    		players.add(öznurBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    	else {
    		playerCount--;
    		players.remove(öznurBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    }
    private void AtillaActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	if (Atilla.isSelected()) {
    		atillaBot =  new Bot("Attila");
    		playerCount++;
    		players.add(atillaBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    	else {
    		playerCount--;
    		players.remove(atillaBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    }
    private void GöktürkActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	if (Göktürk.isSelected()) {
    		göktürkBot =  new Bot("Göktürk");
    		playerCount++;
    		players.add(göktürkBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    	else {
    		playerCount--;
    		players.remove(göktürkBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    }
    private void AndrewActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	if (Andrew.isSelected()) {
    		andrewBot =  new Bot("Andrew");
    		playerCount++;
    		players.add(andrewBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    	else {
    		playerCount--;
    		players.remove(andrewBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    }
    private void AylanurActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	if (Aylanur.isSelected()) {
    		aylanurBot =  new Bot("Aylanur");
    		playerCount++;
    		players.add(aylanurBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    	else {
    		playerCount--;
    		players.remove(aylanurBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    }
    private void HamzaActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	if (Hamza.isSelected()) {
    		hamzaBot =  new Bot("Hamza");
    		playerCount++;
    		players.add(hamzaBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    	else {
    		playerCount--;
    		players.remove(hamzaBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    }
    private void DoğanActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	if (Doğan.isSelected()) {
    		doğanBot =  new Bot("Doğan");
    		playerCount++;
    		players.add(doğanBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    	else {
    		playerCount--;
    		players.remove(doğanBot);
    		jTextPane3.setText(" Add  Player (Player "+playerCount+"/10)");
    	}
    }
}
