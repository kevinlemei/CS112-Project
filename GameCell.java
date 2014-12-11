import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

class GameCell extends Connect4Cell {

 GameCell(int size) {
  super(size);
  //addMouseListener(new MouseAdapter(){
  // public void mousePressed(MouseEvent e){
  //  repaint();
  // }
 // });
 }
 
// class MyMouseListener extends MouseAdapter {

 //}
  
 
 public void paintComponent(Graphics g) {
  super.paintComponent(g);

  // the coordinates of the upper left corner of a rectangle
  // in which an oval will be inscribed

  int x = 20;  // x increases to the right
  int y = 30;  // y increases going down
  int width = getSize().width - 40;
  int height = getSize().height - 60;

  if (isEnabled()) {
   g.setColor(Color.YELLOW);
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
