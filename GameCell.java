import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class GameCell extends JPanel {
  
  public Color chipColor = Color.YELLOW;
  public int col, row;
  Chip content;
  
/////////////constructor//////////////
  public GameCell(int col, int row, int size) {
    this.col = col;
    this.row = row;
    setPreferredSize (new Dimension(size,size));
    setBackground(Color.YELLOW);
  }
  
  public void clear() {
    content = Chip.BLANK;
  }
  
  class MyMouseListener extends MouseAdapter {
    
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    int x = 20;
    int y = 20;
    int width = getSize().width - 30;
    int height = getSize().height - 30;
    
    if (isEnabled()) {
      g.setColor(chipColor);
      g.fillOval(x, y, width, height);
    }
    
    else {
      g.setColor (Color.DARK_GRAY);
      g.fillOval(x, y, width, height);
      
      g.setColor (getBackground());
      g.fillOval(x+1, y+1, width-2, height-2);
    }
  }
  
  
}
