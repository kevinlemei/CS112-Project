import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;

class Board extends JPanel {
  
  final static int LINE_WIDTH = 9;
  final static int ROWS = 6;
  final static int COLUMNS = 7;
  final static int CELL_SIZE = 70;
  
  Cell[][] board = new Cell[ROWS][COLUMNS];
  int clickCount = 0;
  
  Board() {
    
    setLayout(new GridLayout(ROWS, COLUMNS, LINE_WIDTH, LINE_WIDTH));
    
    for (int i=0; i<ROWS; i++) {
      for (int j=0; j<COLUMNS; j++) {
        board[i][j] = new Cell(i,j);
        add(board[i][j]);
      }
    }
    
    
    addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        ++clickCount;
        int clickX = e.getX();
        int clickY = e.getY();
        
        // Get the row and column clicked
        int colSelected = clickX / 80;
        int rowSelected = 5;
        if (colSelected<COLUMNS){
          while (rowSelected>-1 && 
                 board[rowSelected][colSelected].content!=Chip.BLANK){
            rowSelected--;  
          }
        }
        if (rowSelected>-1){
          if (clickCount%2!=0)
            board[rowSelected][colSelected].content = Chip.RED;
          else
            board[rowSelected][colSelected].content = Chip.BLACK;
        }
        repaint();
      }
    });
    
    setEnabled(false);
  }
  
  public void border() {
    setBackground(Color.BLUE);
    Border border = new LineBorder(Color.BLUE, LINE_WIDTH);
    setBorder(border);
    repaint();
  }
  
  public void setEnabled(boolean flag) {
    super.setEnabled(flag);
    for (Component c : getComponents()) 
       c.setEnabled(flag);
    for (int i=0; i<ROWS; i++) {
      for (int j=0; j<COLUMNS; j++) {
        board[i][j].content = Chip.BLANK;
      }
    }
    
    repaint();
  }
}
