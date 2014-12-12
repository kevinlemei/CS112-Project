import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

class Board extends JPanel {
  
  final static int LINE_WIDTH = 9;
  final static int ROWS = 6;
  final static int COLUMNS = 7;
  
  Cell[][] board = new Cell[ROWS][COLUMNS];
  int clickCount = 0;
  
  Board() {
    //initial graphics of the board
    setLayout(new GridLayout(ROWS, COLUMNS, LINE_WIDTH, LINE_WIDTH));
    setBackground(Color.BLUE);
    Border border = new LineBorder(Color.BLUE, LINE_WIDTH);
    setBorder(border);
    
///////////creates a matrix of Cells and initializes each Cell///////
    for (int i=0; i<ROWS; i++) {
      for (int j=0; j<COLUMNS; j++) {
        board[i][j] = new Cell();
        add(board[i][j]);
      }
    }
    
/////////clicking on the board results in an ActionEvent//////////
    addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        int clickX = e.getX();
        
        
        // get the column clicked
        int colSelected = clickX / 80;
        //we start at the bottom row
        int rowSelected = 5;
        
        
        //finds the lowest row that can have a chip inserted
        if (colSelected<COLUMNS) {
          while (rowSelected > -1 && board[rowSelected][colSelected].content != Chip.BLANK) {
            rowSelected--;
          }
        }
        
        //sets the cell either red or black depending on whose turn it is
        //also updates the TurnTracker
        if (rowSelected > -1) {
          if (clickCount % 2 != 0) {
            clickCount++;
        	board[rowSelected][colSelected].content = Chip.RED;
            TurnTracker.currentTurn.setText("Black's turn");
            TurnTracker.currentTurn.setForeground(Color.BLACK); 
          }
          else {
            clickCount++;
            board[rowSelected][colSelected].content = Chip.BLACK;
            TurnTracker.currentTurn.setText("Red's turn");
            TurnTracker.currentTurn.setForeground(Color.RED);
          }
          TurnTracker.currentTurn.updateUI(); //updates the graphics label
        }
        
        repaint();
        
        /////determines the winner dialog and whether to start a new game
        if (win(Chip.RED)){
          if (winDialog("Red"))
            setEnabled(true);
        }
        if (win(Chip.BLACK)){
          if (winDialog("Black"))
            setEnabled(true);
        }
        if (isDraw()){
          if (drawDialog())
            setEnabled(true); 
        }
      }
    });
    
    setEnabled(false);
    
  }
  
///////////checks the board for a winner////////
  public boolean win(Chip player) {
    /////////checks every horizontal 4-in-a-row for each row/////////
    int count = 0;
    for (int row = 0; row<ROWS; row++) {
      for (int col = 0; col<4; col++) {
        for (int i = 0; i<4; i++) {
          if (board[row][col+i].content == player)
            count++;
        }
        if (count == 4) return true;
        else count = 0;
      }
    }  
    /////////checks every vertical 4-in-a-row for each column////////
    for (int col = 0; col<COLUMNS; col++) {
      for (int row = 0; row<3; row++) {
        for (int i = 0; i<4; i++) {
          if (board[row+i][col].content == player)
            count++;
        }
        if (count == 4) return true;
        else count = 0;
      }
    }
    ////////checks every diagonal 4-in-a-row/////////
    for (int row = 3; row<6; row++) {
      for (int col = 0; col<4; col++) {
        for (int i=0; i<4; i++) {
          if (board[row-i][col+i].content == player)
            count++;
        }
        if (count == 4) return true;
        count = 0;
      }
    }
    ///////checks diagonal in other direction//////
    for (int row = 0; row<3; row++) {
      for (int col = 0; col<4; col++) {
        for(int i=0; i<4; i++) {
          if (board[row+i][col+i].content == player)
            count++;
        }
        if (count == 4) return true;
        count = 0;
      }
    }
    //if no 4 in a row, return false
    return false;
  }
  
  //if there is a winner, we open a dialogue window stating the winner
  //and whether they'd like to play again
  public boolean winDialog(String s){
    String s1 = "Yes";
    String s2 = "No";
    Object[] options = {s1, s2};
    int n = JOptionPane.showOptionDialog(null,s +" won! Start over?", "Winner", 
                                         JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, 
                                         null, options, s1);
    if (n==JOptionPane.YES_OPTION){
      return true;
    }else{
      return false;
    }
  }
  
  //checks whether the board is full indicating a draw
  public boolean isDraw(){
    int count=0;
    for (int i=0; i<ROWS; i++){
      for (int j=0; j<COLUMNS; j++){
        if (board[i][j].content==Chip.BLANK)
          ++count;
      }
    }
    if (count!=0) return false;
    else return true;
    
  }
  
  //dialogue window in the event of a draw
  public boolean drawDialog(){
    String s1 = "Yes";
    String s2 = "No";
    Object[] options = {s1, s2};
    int n = JOptionPane.showOptionDialog(null, "It's a draw. Start over?", "Draw", 
                                         JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, 
                                         null, options, s1);
    if (n==JOptionPane.YES_OPTION){
      return true;
    }else{
      return false;
    } 
  }
  
  //this is the code for starting a new game
  //it clears the board and is tied to the new game button as well as the dialogue windows
  public void setEnabled(boolean flag) {
    super.setEnabled(flag);
    for (Component c : getComponents()) 
      c.setEnabled(flag);
    for (int i=0; i<ROWS; i++) {
      for (int j=0; j<COLUMNS; j++) {
        board[i][j].clear();
      }
    }
    repaint();
  }
}
