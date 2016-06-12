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

public class MenuBar {
	static JPanel p;
	JFrame frame;
	static JLabel trapsLabel;
	static JLabel timer;
	static JTextField noTraps;
	static Color blueColour = new Color(27, 14, 89);

	public MenuBar(int width, int height, boolean isDay) {
		frame = new JFrame("28 Robots Later");
		frame.setSize(width, height);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setLocationRelativeTo(null);

		p = new JPanel();
		p.setSize(width, height / 2);
		
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
		
		JButton b = new JButton("Menu");
		b.setFont(font);
		b.setBackground(blueColour);
		b.setForeground(Color.WHITE);
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new MenuPopUp();
				updateTraps(15);
				updateTimer(30);
				nightToDay(false);
			}
		});
		p.add(b);

		trapsLabel = new JLabel("No. of Traps: 5", SwingConstants.CENTER);
		trapsLabel.setFont(new Font("Press Start K", Font.PLAIN, 12));
		p.add(trapsLabel);

		timer = new JLabel("T    ", SwingConstants.RIGHT);
		timer.setFont(new Font("Press Start K", Font.PLAIN, 12));
		p.add(timer);
		
		if(isDay){
			p.setBackground(Color.LIGHT_GRAY);
			trapsLabel.setForeground(blueColour);
			timer.setForeground(blueColour);
		}else{
			p.setBackground(Color.DARK_GRAY);
			trapsLabel.setForeground(Color.WHITE);
			timer.setForeground(Color.WHITE);
		}
		
		frame.setVisible(true);
	}

	public static void updateTraps(int no) {
		trapsLabel.setText("No. of Traps: " + no);
	}
	
	public static void updateTimer(int time){
		timer.setText("" + time + "    ");
	}
	
	public static void nightToDay(boolean isDay){
		if(isDay){
			p.setBackground(Color.LIGHT_GRAY);
			trapsLabel.setForeground(blueColour);
			timer.setForeground(blueColour);
		}else{
			p.setBackground(Color.DARK_GRAY);
			trapsLabel.setForeground(Color.WHITE);
			timer.setForeground(Color.WHITE);
		}
		
		p.repaint();
		p.revalidate();
	}
}
