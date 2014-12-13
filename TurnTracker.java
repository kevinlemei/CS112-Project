import javax.swing.*;
import java.awt.*;

class TurnTracker extends JLabel {
  
  int clickCount = 0;
  public static JLabel currentTurn;
  
  TurnTracker() {
    setLayout(new FlowLayout());
    setPreferredSize (new Dimension(200,50));
    
    currentTurn = new JLabel("Black's turn");
    currentTurn.setFont(new Font("SANS_SERIF", Font.BOLD, 24));
    currentTurn.setForeground(Color.BLACK);
    add(currentTurn);
  }
}