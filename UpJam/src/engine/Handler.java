package engine;

import engine.entities.Entities;
import gui.Game;

import java.awt.Graphics;
import java.util.LinkedList;

import map.Map;

public class Handler {
	
	private Game game;
	private Map map;
	private LinkedList<Entities> players = new LinkedList<Entities>();
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public void createMap(Map map){
		this.map = map;
	}
	
	public void addPlayer(Entities player){
		players.add(player);
	}


	public void tick(){
		//No tick needed for Map
		for (int i = 0; i < players.size(); i++) {
			players.get(i).tick();
		}
	}
	
	
	public void render(Graphics g){
		//Render the map
		for (int y = 0; y < map.getHeight(); y++) {
			for (int x = 0; x < map.getWidth(); x++) {
				map.getTile(x, y).render(g);
			}
		}
		
		//Render players and AI
		for (int i = 0; i < players.size(); i++) {
			players.get(i).render(g);
		}
		
		//Render objects ontop
		
	}
	
	
}
