import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

class Connect4Panel extends JPanel implements ActionListener {

	Connect4Board gameBoard;
	JButton powerButton;

	Connect4Panel() {

		super(new FlowLayout(FlowLayout.CENTER, 50, 50));
		gameBoard = new Connect4Board(this);
		powerButton = new JButton("Power");
		add(gameBoard);
		add(powerButton);
		powerButton.addActionListener(this);
	}

	public void actionPerformed (ActionEvent e) {

		if (e.getSource().equals(powerButton)) {
			gameBoard.setEnabled(!gameBoard.isEnabled());
		}
	}
}
