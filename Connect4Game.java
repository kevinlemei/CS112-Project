import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Connect4Game extends JFrame {

	Connect4Game () {
		super("Connect 4!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new Connect4Panel());
		pack();
		setVisible(true);
	}

	public static void main (String[] args) {
		new Connect4Game();
	}
}
