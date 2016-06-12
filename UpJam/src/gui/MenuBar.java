package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MenuBar extends JPanel {
	static JPanel p;
	static JFrame frame;
	static JLabel trapsLabel;
	static JTextField noTraps;
	static Color blueColour = new Color(27, 14, 89);

	public MenuBar(int width, boolean isDay, JFrame game){
		super();
		setSize(width, 64);
		
		setLayout(new GridLayout(1, 3));

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
		Font font = new Font("Press Start K", Font.PLAIN, 16);
		
		JButton b = new JButton("Menu");
		b.setFont(font);
		b.setBackground(blueColour);
		b.setForeground(Color.WHITE);
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new MenuPopUp(game);
				updateTrapsLabel(15);
				nightToDay(false);
			}
		});
		add(b);

		trapsLabel = new JLabel("   No. of Traps: 5     ", SwingConstants.RIGHT);
		trapsLabel.setFont(new Font("Press Start K", Font.PLAIN, 12));
		add(trapsLabel);
		
		if(isDay){
			setBackground(Color.LIGHT_GRAY);
			trapsLabel.setForeground(blueColour);
		}else{
			setBackground(Color.DARK_GRAY);
			trapsLabel.setForeground(Color.WHITE);
		}
		
	}

	/**
	 * Update the number of traps
	 * @param no Number of traps
	 */
	public static void updateTrapsLabel(int no) {
		trapsLabel.setText("   No. of Traps: " + no + "     ");
	}
	
	/**
	 * Use to change colour scheme between day/night (theoretically)
	 * @param isDay
	 */
	public void nightToDay(boolean isDay){
		if(isDay){
			setBackground(Color.LIGHT_GRAY);
			trapsLabel.setForeground(blueColour);
		}else{
			setBackground(Color.DARK_GRAY);
			trapsLabel.setForeground(Color.WHITE);
		}
	}
}
