// COSC-112 Intro to Computer Science II
// FINAL PROJECT: TIC TAC TOE
// DEBORAH BAKSHIYEV AND KEVIN MEI

import javax.swing.*;

public class TTTApp extends JFrame {
  
  final static int LINE_WIDTH = 3;
  final static int ROWS = 2;
  final static int COLUMNS = 3;
  final static int CELL_SIZE = 150;
  
  private TTTApp() {
    super("Tic Tac Toe");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setContentPane(new TTTPanel());
    pack();
    setVisible(true);
  }
  
  public static void main(String[] args) {
    new TTTApp();
  }
}