package GUI;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import mainGame.InvalidUsernamePasswordException;
import player.You;

public class LoginScreen extends javax.swing.JFrame {
	private javax.swing.JButton Login;
    private javax.swing.JButton Register;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField userNameField;
    private javax.swing.JPasswordField passwordField;
    private HashMap<String, String> userPasswordMap;
    private HashMap<String, Integer> userScoreMap;
    
    public LoginScreen() throws IOException {
    	AccountsMapFromFile();
        initComponents();
    }
                    
    private void initComponents() { //Initializing components

        jPanel1 = new javax.swing.JPanel();
        userNameField = new javax.swing.JTextField();
        Login = new javax.swing.JButton();
        Register = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(700,300);
        ImageIcon image = new ImageIcon("images/UnoIcon.png");
        setIconImage(image.getImage());
        
        jPanel1.setBackground(new Color(0, 0, 102));

        userNameField.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        userNameField.setText("Please Enter Your Name");

        Login.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Login.setText("Login");
        Login.setFocusable(false);
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					LoginActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });

        Register.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
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

        passwordField.setText("100puan");
        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Register)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(200, 200, 200))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addComponent(passwordField))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Login)
                .addGap(31, 31, 31)
                .addComponent(Register)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }                       

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) throws Exception {  //Reach the string from TextFields and try to Login (can throw some exceptions like invalid password or username) 
        try {
        	String userName = userNameField.getText();
        	String password = passwordField.getText();
        	Login(userName, password);
        	JOptionPane.showMessageDialog(null, "WELCOME "+userNameField.getText());
        	You you = new You(userName,userScoreMap.get(userName));
        	this.dispose();
        	new Menu(you).setVisible(true);
        }
        catch (InputMismatchException e) {
        	JOptionPane.showMessageDialog(null, "This username is not registered yet");
        }
        catch (InvalidUsernamePasswordException e) {
        	JOptionPane.showMessageDialog(null, "Invalid username or password!");
        }
        }                     
    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) throws IOException {  //Opens the register screen
    	this.dispose();
    	new RegisterScreen().setVisible(true);
    }
    public void Login(String userName, String password) throws Exception { //Check whether the name is exists in file and is matched with the password
    	if (!(userPasswordMap.containsKey(userName))) {
    		throw new InputMismatchException("This username is not registered yet");
    	}
    	if (!(userPasswordMap.get(userName).equalsIgnoreCase(password))) {
    		throw new InvalidUsernamePasswordException("Invalid username or password!");
    	}
    }
    public void AccountsMapFromFile() throws IOException { //Reads the accounts text file and convert it to maps
        userPasswordMap = new HashMap<>();
        userScoreMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("txts/Accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                userPasswordMap.put(parts[0].trim(), parts[1].trim());
                userScoreMap.put(parts[0].trim(), Integer.parseInt(parts[2].trim()));
            }
        }
    }
}