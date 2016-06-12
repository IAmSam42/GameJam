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

public class MenuBar {
	JPanel p;
	JFrame frame;
	static JTextField noTraps;

	public MenuBar(int width, int height) {
		frame = new JFrame("28 Robots Later");
		frame.setSize(width, height);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setLocationRelativeTo(null);

		p = new JPanel();
		p.setSize(width, height / 2);
		p.setBackground(Color.LIGHT_GRAY);
		p.setLayout(new GridLayout(1, 4));
		frame.getContentPane().add(p);

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

		// Get blue colour
		Color blueColour = new Color(27, 14, 89);

		JButton b = new JButton("Menu");
		b.setSize(width / 10, 25);
		b.setFont(font);
		b.setForeground(Color.WHITE);
		b.setBackground(blueColour);

		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new MenuPopUp();
			}
		});
		p.add(b);

		JLabel trapsLabel = new JLabel("No. of Traps: ");
		trapsLabel.setFont(new Font("Press Start K", Font.PLAIN, 12));
		trapsLabel.setSize(width / 5, 25);
		trapsLabel.setForeground(blueColour);
		p.add(trapsLabel);

		noTraps = new JTextField();
		noTraps.setEditable(false);
		noTraps.setBackground(Color.LIGHT_GRAY);
		p.add(noTraps);

		JLabel timer = new JLabel("T");
		timer.setFont(new Font("Press Start K", Font.PLAIN, 12));
		timer.setSize(width / 10, 25);
		timer.setForeground(blueColour);
		p.add(timer);

		frame.setVisible(true);
	}

	public static void updateTraps(int no) {
		noTraps.setText("" + no);
	}
}
