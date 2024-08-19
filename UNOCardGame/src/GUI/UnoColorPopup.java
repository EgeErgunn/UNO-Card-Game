package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mainGame.GameSession;

public class UnoColorPopup extends JFrame {
    private JButton redButton;
    private JButton blueButton;
    private JButton greenButton;
    private JButton yellowButton;
    private GameSession game;

    public UnoColorPopup(GameSession game) {
    	this.game = game;
    	
        setTitle("Choose Color");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon image = new ImageIcon("images/UnoIcon.png");
        setIconImage(image.getImage());

        JPanel panel = new JPanel(new GridLayout(2, 2));
        redButton = createColorButton(Color.RED);
        blueButton = createColorButton(Color.BLUE);
        greenButton = createColorButton(Color.GREEN);
        yellowButton = createColorButton(Color.YELLOW);

        panel.add(redButton);
        panel.add(blueButton);
        panel.add(greenButton);
        panel.add(yellowButton);

        add(panel);
        setVisible(true);
    }
    
    private JButton createColorButton(Color color) {
        JButton button = new JButton();
        button.setBackground(color);
        button.setPreferredSize(new Dimension(50, 50));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color selectedColor = button.getBackground();
                JOptionPane.showMessageDialog(null, "You selected " + getColorName(selectedColor)+"! The color is now "+getColorName(selectedColor));
                game.setCenterCardColor(getColorName(selectedColor));
                game.getScreen().ColorCenterCard(game.getCenterCard());
        		game.updateCardsPlayability(game.getPlayers().get(game.getRoundIndex()));
        		game.getScreen().UpdateBotText();
        		dispose();
                try {
					game.nextPlayerTurn();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        });
        return button;
    }
    private String getColorName(Color color) {
        if (color.equals(Color.RED)) {
            return "Red";
        } else if (color.equals(Color.BLUE)) {
            return "Blue";
        } else if (color.equals(Color.GREEN)) {
            return "Green";
        } else if (color.equals(Color.YELLOW)) {
            return "Yellow";
        }
        return "";
    }
}
