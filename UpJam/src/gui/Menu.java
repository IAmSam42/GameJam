package gui;

import javax.swing.JFrame;

public class Menu {
	private static JFrame frame;

	public static void main(String[] args) {
		frame = new JFrame("UpJammin'");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); 
		

		frame.setVisible(true);
		
		
	}

}
