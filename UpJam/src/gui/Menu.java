package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Menu {
	private static JFrame frame;
	private static JPanel panel;

	private static final int width = 1000;
	private static final int height = 800;

	public Menu(){
		frame = new JFrame("28 Robots Later");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setSize(width, height);

		// Import font
		try {
			GraphicsEnvironment ge = GraphicsEnvironment
					.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(
					"resources/font/prstartk.ttf")));
		} catch (IOException | FontFormatException e) {
			// Handle exception
		}
		// Create font for buttons, size for title is different
		Font fontButton = new Font("Press Start K", Font.PLAIN, 30);

		// Get blue colour
		Color blueColour = new Color(27, 14, 89);

		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// Title
		JLabel label = new JLabel(
				"<html><center>28 Robots Later</center></html>");
		label.setBounds(150, 80, 750, 165);
		label.setFont(new Font("Press Start K", Font.PLAIN, 75));
		label.setForeground(blueColour);
		panel.add(label);

		// Create play button
		JButton play = new JButton("Play");
		play.setBounds(125, 300, 300, 100);
		play.setFont(fontButton);
		play.setForeground(Color.WHITE);
		play.setBackground(blueColour);

		// Add play listener
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int gameWidth = 840;
				int gameHeight = (gameWidth / 16) * 9;
				new Window(gameWidth, gameHeight, "28 Robots Later", new Game(
						gameWidth, gameHeight));
				frame.dispose();
			}

		});
		panel.add(play);

		// Create credits button
		JButton credits = new JButton("Credits");
		credits.setBounds(125, 450, 300, 100);
		credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		credits.setFont(fontButton);
		credits.setForeground(Color.WHITE);
		credits.setBackground(blueColour);

		// Add credits listener
		credits.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Credits();
			}
		});

		panel.add(credits);

		// Create quit button
		JButton quit = new JButton("Quit");
		quit.setBounds(125, 600, 300, 100);
		quit.setFont(fontButton);
		quit.setForeground(Color.WHITE);
		quit.setBackground(blueColour);

		// Add quit listener
		quit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(quit);

		//Uptown Jammin'
		JLabel studios = new JLabel("By UpJammin' Studios, Version 0.6.5");
		studios.setBounds(15, 740, 750, 15);
		studios.setFont(new Font("Press Start K", Font.PLAIN, 12));
		studios.setForeground(blueColour);
		panel.add(studios);
		
		// Images
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(365, 122, 640, 640);
		layeredPane.setLayout(null);
		
		ImageIcon corridor = new ImageIcon("resources/Sprites/corridor.png");
		JLabel c = new JLabel();
		c.setIcon(corridor);
		c.setBounds(1, 1, 631, 635);
		layeredPane.add(c, new Integer(1));
		
		ImageIcon sam = new ImageIcon("resources/Sprites/samNOTSOBIG.png");
		JLabel s = new JLabel();
		s.setIcon(sam);
		s.setBounds(170, 245, 365, 365);
		layeredPane.add(s, new Integer(3));
		
		ImageIcon bob = new ImageIcon("resources/Sprites/bobLITTLEBITBIGGER.png");
		JLabel b = new JLabel();
		b.setIcon(bob);
		b.setBounds(400, 150, 195, 321);
		layeredPane.add(b, new Integer(2));
		
		panel.add(layeredPane);
		
		frame.setVisible(true);

	}
	public static void main(String[] args) {
		new Menu();
	}

}
