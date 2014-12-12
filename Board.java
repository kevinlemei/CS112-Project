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
          if (clickCount%2!=0) {
            board[rowSelected][colSelected].content = Chip.RED;
            TurnTracker.currentTurn.setText("Black's turn");
            TurnTracker.currentTurn.setForeground(Color.BLACK);
            
          }
          else {
            board[rowSelected][colSelected].content = Chip.BLACK;
            TurnTracker.currentTurn.setText("Red's turn");
            TurnTracker.currentTurn.setForeground(Color.RED);
          }
          TurnTracker.currentTurn.updateUI();
        }
        repaint();
        if (win(Chip.RED)){
         if (winDialog("Red"))
          setEnabled(true);
        }
        if (win(Chip.BLACK)){
         if (winDialog("Black"))
          setEnabled(true);
        }
      }
    });
    
    setEnabled(false);
  }
  
  public boolean win(Chip player) {
    
    int count = 0;
    
    /////////checks every horizontal 4-in-a-row for each row/////////
    for (int row = 0; row<ROWS; row++) {
      for (int col = 0; col<COLUMNS; col++) {
        if (board[row][col].content == player) {
          count++;
          if (count == 4) return true;
        }
        else count = 0;
      }
    }
    
    /////////checks every vertical 4-in-a-row for each column////////
    for (int col = 0; col<COLUMNS; col++) {
      for (int row = 0; row<ROWS; row++) {
        if (board[row][col].content == player) {
          count++;
          if (count == 4) return true;
        }
        else count = 0;
      }
    }
    
    ////////checks every diagonal 4-in-a-row/////////
    for (int row = 3; row<6; row++) {
      for (int col = 0; col<4; col++) {
        for (int i=0; i<4; i++) {
          if (board[row-i][col+i].content == player) {
            count++;
            if (count == 4) return true;
          }
        }
        count = 0;
      }
    }
    
    ///////checks diagonal in other direction//////
    for (int row = 0; row<3; row++) {
      for (int col = 0; col<4; col++) {
        for(int i=0; i<4; i++) {
          if (board[row+i][col+i].content == player) {
            count++;
            if (count == 4) return true;
          }
        }
        count = 0;
      }
    }
    
    return false;
    
  }
  
  public void border() {
    setBackground(Color.BLUE);
    Border border = new LineBorder(Color.BLUE, LINE_WIDTH);
    setBorder(border);
    repaint();
  }
  
  public boolean winDialog(String s){
   String s1 = "Yay! Keep playing!";
   String s2 = "Awesome. I'm done.";
   Object[] options = {s1, s2};
   int n = JOptionPane.showOptionDialog(null, s +" won!", "Winner", 
     JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, 
     null, options, s1);
   if (n==JOptionPane.YES_OPTION){
    return true;
   }else{
    return false;
   }
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
