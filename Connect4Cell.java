import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

class Connect4Cell extends JPanel {

	Connect4Cell(int size) {
		setPreferredSize (new Dimension(size,size));
		setBackground(Color.YELLOW);
	}
}
