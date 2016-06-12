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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPopUp {
	private static JFrame frame;
	private static JPanel panel;

	private static final int width = 400;
	private static final int height = 500;

	public MenuPopUp(JFrame game) {
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

		// Create font for buttons, size for title is different
		Font fontButton = new Font("Press Start K", Font.PLAIN, 20);

		// Get blue colour
		Color blueColour = new Color(27, 14, 89);

		JLabel title = new JLabel("Menu");
		title.setBounds(105, 25, 250, 100);
		title.setFont(new Font("Press Start K", Font.PLAIN, 50));
		title.setForeground(blueColour);
		panel.add(title);
		
		JButton exitMain = new JButton("<html><center>Exit to Main Menu</center><html>");
		exitMain.setFont(fontButton);
		exitMain.setForeground(Color.WHITE);
		exitMain.setBackground(blueColour);
		exitMain.setBounds(75, 150, 250, 100);
		panel.add(exitMain);
		
		exitMain.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Menu();
				game.dispose();
				frame.dispose();
			}
		});
		
		JButton exitGame = new JButton("<html><center>Exit Game</center><html>");
		exitGame.setFont(fontButton);
		exitGame.setForeground(Color.WHITE);
		exitGame.setBackground(blueColour);
		exitGame.setBounds(75, 300, 250, 100);
		panel.add(exitGame);
		
		exitGame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);;
			}
		});
		
		frame.setVisible(true);
	}

}
