import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Connect4Panel extends JPanel implements ActionListener {
  
  Board gameBoard;
  JButton newButton;
  JLabel title;
  JLabel credits;
  TurnTracker turn;
  
  Connect4Panel() {
    
    super(new FlowLayout(FlowLayout.CENTER, 1000, 15));
    setBackground(new Color(172,209,233));
    this.setPreferredSize(new Dimension(1000,1000));
    
    title = new JLabel("CONNECT FOUR");
    title.setFont(new Font("SANS_SERIF", Font.BOLD, 72));
    title.setForeground(Color.WHITE);
    title.setAlignmentX(0.5f);
    credits = new JLabel("created by Deborah Bakshiyev and Kevin Mei");
    credits.setFont(new Font("MONOSPACED", Font.PLAIN, 24));
    credits.setForeground(Color.WHITE);
    credits.setAlignmentX(0.5f);
    gameBoard = new Board();
    newButton = new JButton("New Game");
    turn = new TurnTracker();
    
    add(title);
    add(credits);
    add(gameBoard);
    add(turn);
    add(newButton);
    
    newButton.addActionListener(this);
    
  }
  
  public void actionPerformed (ActionEvent e) {
    
    if (e.getSource().equals(newButton)) {
      gameBoard.setEnabled(!gameBoard.isEnabled());
    }  
  }
  
}
