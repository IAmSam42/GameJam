package engine;

import engine.entities.Entities;
import engine.entities.Trap;
import gui.Game;

import java.awt.Graphics;
import java.util.LinkedList;

import map.Map;

public class Handler {
	
	private Game game;
	private Map map;
	private LinkedList<Entities> players = new LinkedList<Entities>();
	private LinkedList<Entities> extras = new LinkedList<Entities>();
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public void createMap(Map map){
		this.map = map;
	}
	
	public void addPlayer(Entities player){
		players.add(player);
		player.addMap(map);
	}

	public void addExtras(Entities trap) {
		extras.add(trap);		
	}

	public void tick(){
		//No tick needed for Map
		
		//Tick Objects - May not be needed
		for (int i = 0; i < extras.size(); i++) {
			extras.get(i).tick();
		}
		
		//Tick Players
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
		
		//Render Extras behind players 
		for (int i = 0; i < extras.size(); i++) {
			extras.get(i).render(g);
		}
		
		//Render players and AI
		for (int i = 0; i < players.size(); i++) {
			players.get(i).render(g);
		}
		
		//Render objects ontop
		
	}


	
	
}
