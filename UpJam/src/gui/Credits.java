package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Credits {
	private static JFrame frame;
	private static JPanel panel;

	private static final int width = 800;
	private static final int height = 500;

	public Credits() {
		frame = new JFrame("28 Robots Later");
		frame.setSize(width, height);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setSize(width, height);

		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// Import font
		try {
			GraphicsEnvironment ge = GraphicsEnvironment
					.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(
					"resources/font/prstartk.ttf")));
		} catch (IOException | FontFormatException e) {
			// Handle exception
		}

		// Get blue colour
		Color blueColour = new Color(27, 14, 89);

		JLabel title = new JLabel("Credits");
		title.setBounds(150, 25, 550, 100);
		title.setFont(new Font("Press Start K", Font.PLAIN, 75));
		title.setForeground(blueColour);
		panel.add(title);

		JLabel credit = new JLabel(
				"<html><center>Font: http://www.zone38.net/<br>Music: www.purple-planet.com<br><br>Developers:<br>Thomas Sammons<br>Sam Holdcroft<br>Helena Bower<br>Sam Durdy<br>Vicci Garner</center></html>");
		credit.setBounds(50, 5, 800, 500);
		credit.setFont(new Font("Press Start K", Font.PLAIN, 25));
		credit.setForeground(blueColour);
		panel.add(credit);
		frame.setVisible(true);
	}

}
