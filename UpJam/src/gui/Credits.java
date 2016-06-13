package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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

		JLabel title = new JLabel("Credits", SwingConstants.CENTER);
		title.setSize(width, 100);
		title.setFont(new Font("Press Start K", Font.PLAIN, 75));
		title.setForeground(blueColour);
		panel.add(title, BorderLayout.NORTH);

		JLabel credit = new JLabel(
				"<html><center>Font: http://www.zone38.net/<br><br>Music: Sam Durdy, www.purple-planet.com<br><br>Developers:<br>Thomas Sammons<br>Sam Holdcroft<br>Helena Bower<br>Sam Durdy<br>Vicci Garner</center></html>");
		credit.setSize(width, 500);
		credit.setFont(new Font("Press Start K", Font.PLAIN, 25));
		credit.setForeground(blueColour);
		panel.add(credit, BorderLayout.CENTER);
		
		//Images
		ImageIcon tom = new ImageIcon("resources/Sprites/tomSprite.png");
		JLabel t = new JLabel();
		t.setIcon(tom);
		t.setBounds(235, 396, 64, 64);
		panel.add(t, new Integer(1));
		
		ImageIcon shorts = new ImageIcon("resources/Sprites/shortsSprite.png");
		JLabel s = new JLabel();
		s.setIcon(shorts);
		s.setBounds(295, 396, 64, 64);
		panel.add(s, new Integer(1));
		
		ImageIcon helena = new ImageIcon("resources/Sprites/buttbuttSprite.png");
		JLabel h = new JLabel();
		h.setIcon(helena);
		h.setBounds(355, 396, 64, 64);
		panel.add(h, new Integer(1));
		
		ImageIcon durdy = new ImageIcon("resources/Sprites/stabbySprite.png");
		JLabel d = new JLabel();
		d.setIcon(durdy);
		d.setBounds(415, 396, 64, 64);
		panel.add(d, new Integer(1));
		
		ImageIcon bric = new ImageIcon("resources/Sprites/bricSprite.png");
		JLabel b = new JLabel();
		b.setIcon(bric);
		b.setBounds(475, 396, 64, 64);
		panel.add(b, new Integer(1));
		
		
		frame.setVisible(true);
	}

}
