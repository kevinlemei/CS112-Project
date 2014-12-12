import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

class Connect4Panel extends JPanel implements ActionListener {

 Board gameBoard;
 JButton powerButton;

 Connect4Panel() {

  super(new FlowLayout(FlowLayout.CENTER, 100, 100));
  setBackground(new Color(172,209,233));
  gameBoard = new Board();
  setBackground(new Color(172, 209, 233));
  gameBoard.border();
  powerButton = new JButton("New Game");
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
