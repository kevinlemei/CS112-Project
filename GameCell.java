import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;

class GameCell extends Connect4Cell {
	
	Color chipColor = Color.YELLOW;
	GameCell(int size) {
		super(size);
		addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if (e.getClickCount()%2!=0)
					chipColor = Color.RED;
				else
					chipColor = Color.BLACK;
				repaint();
			}
		});
	}
	
	class MyMouseListener extends MouseAdapter {
		
	}
		
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// the coordinates of the upper left corner of a rectangle
		// in which an oval will be inscribed

		int x = 20;  // x increases to the right
		int y = 20;  // y increases going down
		int width = getSize().width - 30;
		int height = getSize().height - 30;

		if (isEnabled()) {
			g.setColor(chipColor);
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
