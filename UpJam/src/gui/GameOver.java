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
import javax.swing.SwingConstants;

public class GameOver {
	JFrame frame;

	public GameOver() {
		frame = new JFrame("28 Robots Later");
		frame.setSize(500, 400);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

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
		
		JLabel title = new JLabel("<html>GAME OVER<html>", SwingConstants.CENTER);
		title.setBounds(100, 50, 500, 150);
		title.setFont(new Font("Press Start K", Font.PLAIN, 75));
		title.setForeground(blueColour);
		frame.add(title, BorderLayout.NORTH);
		
		JButton exitMain = new JButton("<html><center>Exit to Main Menu</center><html>");
		exitMain.setFont(new Font("Press Start K", Font.PLAIN, 20));
		exitMain.setForeground(Color.WHITE);
		exitMain.setBackground(blueColour);
		exitMain.setBounds(125, 225, 250, 75);
		frame.add(exitMain);
		
		exitMain.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Menu();
				frame.dispose();
			}
		});
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameOver();
	}
}
