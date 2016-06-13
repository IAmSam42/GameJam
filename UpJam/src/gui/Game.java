package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import map.Camera;
import map.Map;
import map.Tile;
import Controller.KeyHandler;
import engine.Handler;
import engine.entities.Player;
import engine.entities.Robot;


public class Game extends Canvas implements Runnable{
	
	public static boolean isDay = true;
	public static boolean paused = false;
	public static int timeTillDay = 60*120;
	public static int noOfDays = 0;
	private static final long serialVersionUID = 1L;
	private boolean running = false;
	private Thread thread;
	private Handler handler;
	private Camera cam;
	
	public JFrame frame = new JFrame();
	public int HEIGHT;
	public int WIDTH;

	/**
	 * Constructor
	 */
	public Game(int w, int h){
		HEIGHT = h;
		WIDTH = w;
		
		handler = new Handler(this);
		Map map = new Map();
		handler.createMap(map);
	
		cam = new Camera(0, 0);
		handler.addCamera(cam);
	


		Player player = new Player(32,32, Tile.TILESIZE, handler, map);

		handler.addRobot(new Robot(288, 224, Tile.TILESIZE, map, player, handler.getExtras()));
		handler.addRobot(new Robot(1000, 224, Tile.TILESIZE, map, player, handler.getExtras()));
		handler.addRobot(new Robot(100, 224, Tile.TILESIZE, map, player, handler.getExtras()));
		handler.addRobot(new Robot(550, 224, Tile.TILESIZE, map, player, handler.getExtras()));
		handler.addRobot(new Robot(600, 224, Tile.TILESIZE, map, player, handler.getExtras()));
		
		this.addKeyListener(new KeyHandler(player));
		this.setFocusable(true);

	}	
	
	/**
	 * Starts the Game
	 */
	public synchronized void start(){
		if(running){
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * Stops the Game
	 */
	public synchronized void stop(){
		running = false;
	}
	
	@Override
	/**
	 * Method to run once the thread has started
	 */
	public void run() {
		double fpsTimer = System.currentTimeMillis();
		double nsPerTick = 1000000000.0d/60;
		double then = System.nanoTime();
		double unprocessed = 0;
		while(running){

			boolean canRender = false;
			double now = System.nanoTime();
			unprocessed += (now - then) / nsPerTick;
			then = now;
			while(unprocessed >= 1){
				tick();
				canRender = true;
				--unprocessed;
			}
			try{
				Thread.sleep(1);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			if(canRender){
				render();
			}
			
			if(System.currentTimeMillis() - fpsTimer > 1000){
				fpsTimer += 1000;
			}
			while(paused){}
		}
	}


	private int timeCounter = 0;

	/**
	 * Tick method
	 */
	private void tick() {
		handler.tick();
		if(!isDay){
			timeCounter++;
			if(timeCounter > timeTillDay){
				isDay = true;
				timeCounter = 0;
				noOfDays++;
				MenuBar.updateTrapsLabel(Player.getTrapLimit() + 7 );
				Player.setTrapLimit(Player.getTrapLimit() + 7 );
				timeTillDay = (int) (timeTillDay*1.1);
				handler.muteAllRobots(true);
			}
		}
		
	}

	/**
	 * Render method
	 */
	private void render() {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		// Create Graphics to draw
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D)g;
				
		// Colour frame background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		g2d.translate(cam.getX(), cam.getY());
		
		handler.render(g);
	
		g2d.translate(-cam.getX(), -cam.getY());
		
		g.dispose();
		bs.show();
	}
	
	/**
	 * Gets the height of the game
	 */
	public int getHeight(){
		return HEIGHT;
	}
	
	
	/**
	 * Gets the Width of the game
	 */
	public int getWidth(){
		return WIDTH;
	}
	

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		int width = 840;
		int height = (width/16)*9;
		new Window(width, height,"Up Town Jam" ,new Game(width, height));
	}
}
