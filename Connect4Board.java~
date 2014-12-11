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

	Connect4Board(Component f) {

		theParent = f;

		setLayout (new GridLayout(ROWS, COLUMNS, LINE_WIDTH, LINE_WIDTH));

		for (; filledCells<ROWS*COLUMNS; ++filledCells)
			add (new GameCell(CELL_SIZE));

		setEnabled(false);
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



//	void clearAll() {
//		grandTotal = 0;
//		labelCell.setText();
//		spotCell.clear();
//		textCell.clear();
//		drawingCell.clear();
//	}
}
