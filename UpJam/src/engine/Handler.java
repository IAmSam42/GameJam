package engine;

import gui.Game;

import java.awt.Graphics;

import map.Map;

public class Handler {
	
	private Game game;
	private Map map;
	
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public void createMap(Map map){
		this.map = map;
	}


	public void tick(){
		//No tick needed for Map
		
	}
	
	
	public void render(Graphics g){
		//Render the map
		//System.out.println("RENDER: " + map.getHeight());
		for (int y = 0; y < map.getHeight(); y++) {
			for (int x = 0; x < map.getWidth(); x++) {
				map.getTile(x, y).render(g);
			}
		}
		
		//Render objects ontop
	}
	
	
}
