import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Cell extends JPanel {
  
  Chip content = Chip.BLANK;
  
/////////////constructor//////////////
  public Cell() {
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
}

