import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Cell extends JPanel {
  
  private int col, row;
  Chip content = Chip.BLANK;
  
/////////////constructor//////////////
  public Cell(int row, int col) {
    this.row = row;
    this.col = col;
    setPreferredSize(new Dimension(70, 70));
  }
  
///////a class function to clear the cell///////
  public void clear() {
    content = Chip.BLANK;
  }
  
/////////the graphics of the cell//////
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    int x = 10;
    int y = 10;
    int width = getSize().width - 20;
    int height = getSize().height - 20;
    
    
    setBackground(Color.YELLOW);
//    setLayout (new BoxLayout(this, BoxLayout.X_AXIS));
//    setBorder (new EmptyBorder(10,10,10,10));
    
    if (content == Chip.BLANK) {
      g.setColor(Color.WHITE);
      g.fillOval(x, y, width, height);
    }
    else if (content == Chip.RED) {
      g.setColor(Color.RED);
      g.fillOval(x, y, width, height);
    }
    else if (content == Chip.BLACK) {
      g.setColor(Color.BLACK);
      g.fillOval(x, y, width, height);
    }     
  }
  
//    
//    if (isEnabled()) {
//      g.setColor(chipColor);
//      g.fillOval(x, y, width, height);
//    }
//    
//    else {
//      g.setColor (Color.DARK_GRAY);
//      g.fillOval(x, y, width, height);
//      
//      g.setColor (getBackground());
//      g.fillOval(x+1, y+1, width-2, height-2);
//    }
}

