package gui;

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
		
		/*JPanel top = new JPanel();
		top.setBounds(0, 0, w, 50);
		top.add(new MenuBar(w, true, this));
		add(top);*/
		
		add(new MenuBar(w, true, this));
		
		game.setBounds(0, 50, w, h);
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
