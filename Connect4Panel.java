import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

class Connect4Panel extends JPanel implements ActionListener {
<<<<<<< Updated upstream

 Board gameBoard;
 JButton powerButton;

 Connect4Panel() {

  super(new FlowLayout(FlowLayout.CENTER, 100, 100));
  setBackground(new Color(172,209,233));
  gameBoard = new Board();
  gameBoard.border();
  powerButton = new JButton("New Game");
  add(gameBoard);
  add(powerButton);
  powerButton.addActionListener(this);
=======
>>>>>>> Stashed changes
  
  Board gameBoard;
  JButton powerButton;
  JLabel title;
  
  Connect4Panel() {
    
    super(new FlowLayout(FlowLayout.CENTER, 100, 100));
    setBackground(new Color(172,209,233));
    title = new JLabel("CONNECT FOUR");
    title.setFont(new Font("SANS_SERIF", Font.BOLD, 72));
    title.setForeground(Color.WHITE);
    title.setAlignmentX(0.5f);
    gameBoard = new Board();
    gameBoard.border();
    powerButton = new JButton("New Game");
    add(title);
    add(gameBoard);
    add(powerButton);
    powerButton.addActionListener(this);
    
  }
  
  public void actionPerformed (ActionEvent e) {
    
    if (e.getSource().equals(powerButton)) {
      gameBoard.setEnabled(!gameBoard.isEnabled());
    }
    
  }
  
}
