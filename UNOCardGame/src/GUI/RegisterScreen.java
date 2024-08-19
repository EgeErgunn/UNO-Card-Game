package GUI;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class RegisterScreen extends javax.swing.JFrame {
	private javax.swing.JButton Register;
    private javax.swing.JButton ReturnToLogin;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField confirmPasswordField;
    private javax.swing.JTextField userNameField;
    private HashMap<String, String> userpasswordMap;
    private HashMap<String, Integer> userScoreMap;
    private HashMap<String, Integer> userGameMap;
    private HashMap<String, Integer> userWinMap;
               
    public RegisterScreen() throws IOException {
    	AccountsMapFromFile();
        initComponents();
    }
                      
    private void initComponents() { //Initialize components

        passwordField = new javax.swing.JTextField();
        confirmPasswordField = new javax.swing.JTextField();
        userNameField = new javax.swing.JTextField();
        Register = new javax.swing.JButton();
        ReturnToLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(700,300);
        ImageIcon image = new ImageIcon("images/UnoIcon.png");
        setIconImage(image.getImage());
        setBackground(new Color(8, 8, 236));

        passwordField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        passwordField.setText("Enter a Password");

        confirmPasswordField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        confirmPasswordField.setText("Confirm Your Password");

        userNameField.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        userNameField.setText("Enter a Name");

        Register.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Register.setText("Register");
        Register.setFocusable(false);
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					RegisterActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        ReturnToLogin.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        ReturnToLogin.setText("Return To Login");
        ReturnToLogin.setFocusable(false);
        ReturnToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					ReturnToLoginActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ReturnToLogin)
                            .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(142, 142, 142))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Register)
                .addGap(18, 18, 18)
                .addComponent(ReturnToLogin)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }  
    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) throws IOException {  //Creates a New User
    	NewUser();
    }
    private void ReturnToLoginActionPerformed(java.awt.event.ActionEvent evt) throws IOException {   //Returns to login screen                                  
        this.dispose();
        new LoginScreen().setVisible(true);
    }
    public void NewUser() { //Try to add new user and catch errors if possible returns to login page
    	try {
    		Register(userNameField.getText(), passwordField.getText());
    		StoreTheAccount();
    		JOptionPane.showMessageDialog(null, "You are succesfully registered");
    		this.dispose();
    		new LoginScreen().setVisible(true);
    	}
    	catch (InputMismatchException e) {
    		JOptionPane.showMessageDialog(null, "Your password has not been confirmed");
    	}
    	catch (IllegalArgumentException e) {
    		JOptionPane.showMessageDialog(null, "Usernames only allowed to contain digits or letters");
    	}
    	catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "This username is already registered!");
    	}
    }
    public void Register(String userName, String password) throws Exception  { //Check for whether this user and passwords is valid for registration then put it to maps
    	if (userpasswordMap.containsKey(userName)) {
            throw new Exception("Username already exists!");
        }
    	if (!(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))) {
            throw new InputMismatchException("Your password has not been confirmed");
        }
    	for (int i=0; i < userName.length(); i++) {
    		char c = userName.charAt(i);
    		if (!(Character.isLetter(c)) && !(Character.isDigit(c))) {
    			throw new IllegalArgumentException("This username does contain character except digit or letter");
    		}
    	}
    	userpasswordMap.put(userName, password);
    	userScoreMap.put(userName, 0);
    	userGameMap.put(userName, 0);
    	userWinMap.put(userName, 0);
    }
    public void StoreTheAccount() throws IOException { //Convert maps to text file
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("txts/Accounts.txt"))) {
			for (HashMap.Entry<String, String> entry : userpasswordMap.entrySet()) {
			        writer.write(entry.getKey() + ":" + entry.getValue()+ ":" +userScoreMap.get(entry.getKey())+":"+userGameMap.get(entry.getKey())+":"+userWinMap.get(entry.getKey()));
			        writer.newLine();
			    }
		}
    }
    public void AccountsMapFromFile() throws IOException { //Convert text file to maps
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

    
}
