package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	static JLabel instructions;
	public static Window acc;
	
	public Window(int w, int h, String title, Game game){
		acc = this;
		Dimension dimention = new Dimension(w, h +85);
		setMaximumSize(dimention);
		setMinimumSize(dimention);
		setPreferredSize(dimention);
		
		pack();
		
		add(new MenuBar(w, true, this), BorderLayout.NORTH);
		
		game.setBounds(0, 64, w, h);
		add(game, BorderLayout.CENTER);
		
		JLabel instructions = new JLabel("Press Enter to start the night", SwingConstants.CENTER);
		instructions.setBounds(0, h + 10, w, 45);
		instructions.setFont(new Font("Press Start K", Font.PLAIN, 12));
		instructions.setForeground(new Color(27, 14, 89));
		add(instructions, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		game.start();
		
		//frame.setUndecorated(true);	
	}
	
	public static void close(){
		acc.dispose();
	}
	
	public static void survive(){
		instructions.setText("Survive");
	}
	
	public static void setInstructions(){
		instructions.setText("Press Enter to start the night");
	}

}
