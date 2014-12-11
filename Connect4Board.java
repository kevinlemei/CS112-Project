import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;

class Connect4Board extends JPanel {
  
  final static int LINE_WIDTH = 3;
  final static int ROWS = 6;
  final static int COLUMNS = 7;
  final static int CELL_SIZE = 100;
  
  LineBorder border;
  int filledCells;
  
  Component theParent;
  GameCell gameCell;
  
  class MyMouseListener extends MouseAdapter {
	    
  }
  
  Connect4Board(Component f) {
    theParent = f;
    setLayout(new GridLayout(ROWS, COLUMNS, LINE_WIDTH, LINE_WIDTH));
   
    ////old board code --- keeping for now
    // for (; filledCells<ROWS*COLUMNS; ++filledCells)
    //  add(new GameCell(CELL_SIZE));
    
    GameCell[][] gameBoard = new GameCell[6][7];
    for (int boardRow = 0; boardRow<ROWS; boardRow++){
    	for (int boardCol = 0; boardCol<COLUMNS; boardCol++){
    		gameBoard[boardRow][boardCol] = new GameCell (boardRow, boardCol, CELL_SIZE);
    		//gameBoard[boardCol][boardRow] = new GameCell (boardCol, boardRow, CELL_SIZE);
    	}
    }
    setEnabled(false);  
    addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e){
          int clickX = e.getX();
          int clickY = e.getY();
          // Get the row and column clicked
          int clickRow = clickY / CELL_SIZE;
          int clickCol = clickX / CELL_SIZE;
          if (e.getClickCount()%2 != 0)
            gameCell.chipColor = Color.RED;
          else
            gameCell.chipColor = Color.BLACK;
          repaint();
        }
      });
  }
  
  public void setEnabled(boolean flag) {
    
    super.setEnabled(flag);
    
    for (Component c : getComponents()) 
      c.setEnabled(flag);
    
    border = new LineBorder(flag ? Color.GRAY : Color.WHITE, LINE_WIDTH);
    setBorder(border);
    setBackground(flag ? Color.BLUE : Color.WHITE);
    
    repaint();
  }
  
  Component getRoot() {
    return theParent;
  }
  
}
