import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

class TurnTracker extends JLabel {
  
  int clickCount = 0;
  public static JLabel currentTurn;
  
  TurnTracker() {
    setLayout(new FlowLayout());
    setPreferredSize (new Dimension(200,50));
    
    currentTurn = new JLabel("Red's turn");
    currentTurn.setFont(new Font("SANS_SERIF", Font.BOLD, 24));
    currentTurn.setForeground(Color.RED);
    add(currentTurn);

    
  }
  
  
}