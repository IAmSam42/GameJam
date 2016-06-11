package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;

	public Window(int w, int h, String title, Game game){
		Dimension dimention = new Dimension(w, h);
		//JFrame frame = new JFrame();
		setMaximumSize(dimention);
		setMinimumSize(dimention);
		setPreferredSize(dimention);
		
		pack();
		add(game);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		game.start();
		
		//frame.setUndecorated(true);	
	}
}
