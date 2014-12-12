import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

class Connect4Board extends JPanel {
  
  final static int LINE_WIDTH = 3;
  final static int ROWS = 6;
  final static int COLUMNS = 7;
  final static int CELL_SIZE = 100;
  
  Cell[][] board = new Cell[ROWS][COLUMNS];
  
  Connect4Board() {
    
    setLayout(new GridLayout(ROWS, COLUMNS, LINE_WIDTH, LINE_WIDTH));
    
    for (int i=0; i<ROWS; i++) {
      for (int j=0; j<COLUMNS; j++) {
        board[i][j] = new Cell(i,j);
        add(board[i][j]);
      }
    }
  }
}
//
////    for (int i = 0; i < ROWS; ++i) {
////     for (int j = 0; j < COLUMNS; ++j) {
////       add (cell = new Cell(i, j));
//    
//    //gameBoard[boardCol][boardRow] = new GameCell (boardCol, boardRow, CELL_SIZE);
//    // }
//    //   }
//    
////    setEnabled(false);  
//    
//    addMouseListener(new MouseAdapter() {
//      public void mouseClicked(MouseEvent e){
//        int clickX = e.getX();
//        int clickY = e.getY();
//        // Get the row and column clicked
//        int clickRow = clickY / CELL_SIZE;
//        int clickCol = clickX / CELL_SIZE;
////          if (e.getClickCount()%2 != 0)
////            cell.chipColor = Color.RED;
////          else
////            cell.chipColor = Color.BLACK;
//        repaint();
//      }
//    });
//  //}
//  
//  class MyMouseListener extends MouseAdapter {
//    
//  }
//  
//  
////  public void setEnabled(boolean flag) {
////    
////    super.setEnabled(flag);
////    
////    for (Component c : getComponents()) 
////      c.setEnabled(flag);
////    
////    border = new LineBorder(flag ? Color.GRAY : Color.WHITE, LINE_WIDTH);
////    setBorder(border);
////    setBackground(flag ? Color.BLUE : Color.WHITE);
////    
////    repaint();
////  }
//  
//}
