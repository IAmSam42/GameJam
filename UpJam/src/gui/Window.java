package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;

	public Window(int w, int h, String title, Game game){
		Dimension dimention = new Dimension(w, h);
		setMaximumSize(dimention);
		setMinimumSize(dimention);
		setPreferredSize(dimention);
		
		pack();
		
		add(new MenuBar(w, true, this), BorderLayout.NORTH);
		
		game.setBounds(0, 50, w, h);
		add(game, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		game.start();
		
		//frame.setUndecorated(true);	
	}
}
