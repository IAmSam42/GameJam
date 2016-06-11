package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPanel;

public class Menu {
	private static JFrame frame;
	private static JPanel panel;

	private static final int width = 1000;
	private static final int height = 800;

	public static void main(String[] args) {
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
					"resources/prstartk.ttf")));
		} catch (IOException | FontFormatException e) {
			// Handle exception
		}
		// Create font
		Font fontButton = new Font("Press Start K", Font.PLAIN, 30);

		// Get blue colour
		Color blueColour = new Color(27, 14, 89);

		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// Title
		JLabel label = new JLabel("<html><center>28 Robots Later</center></html>");
		label.setBounds(150, 80, 750,
				165);
		label.setFont(new Font("Press Start K", Font.PLAIN, 75));
		label.setForeground(blueColour);
		panel.add(label, BorderLayout.NORTH);

		// Create play button
		JButton play = new JButton("Play");
		play.setBounds(125, 300, 300, 100);
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		play.setFont(fontButton);
		play.setForeground(Color.WHITE);
		play.setBackground(blueColour);

		// Add play listener
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int gameWidth = 840;
				int gameHeight = (width/16)*9;
				new Window(gameWidth, gameHeight,"28 Robots Later", new Game(gameWidth, gameHeight));
				frame.dispose();
			}

		});
		panel.add(play);

		// Create quit button
		JButton quit = new JButton("Quit");
		quit.setBounds(125, 500, 300,
				100);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
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
		
		//Image
		ImageIcon myImage = new ImageIcon("resources/Sprites/samBIG.png");
		JLabel sam = new JLabel();
		sam.setIcon(myImage);
		sam.setBounds(400, 260, 500,
				500);
		panel.add(sam);

		frame.setVisible(true);

	}

}
