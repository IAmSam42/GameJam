package engine;

import engine.entities.Entities;
import engine.entities.Trap;
import gui.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import map.Camera;
import map.Map;
import map.Tile;


public class Handler {
	
	private Game game;
	private Map map;
	private LinkedList<Entities> players = new LinkedList<Entities>();
	private LinkedList<Entities> extras = new LinkedList<Entities>();
	private Camera cam;
	private Rectangle[][] fog;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public void createMap(Map map){
		this.map = map;
		fog = new Rectangle[map.getWidth()][map.getHeight()];
//		for(int y = 0; y<map.getHeight();y++){
//			for(int x = 0; x<map.getWidth();x++){
//				fog[x][y] = new Rectangle(x*Tile.TILESIZE, y*Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE);
//			}
//		}
		
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
			cam.tick(players.get(0));
		}
	}
	
	
	public void render(Graphics g){
		//Render the map
		for (int y = 0; y < map.getHeight(); y++) {
			for (int x = 0; x < map.getWidth(); x++) {
				if (map.getTile(x, y).getXCoord() >= (0 - cam.getX() - Tile.TILESIZE)
						&& map.getTile(x, y).getYCoord() >= (0 - cam.getY() - Tile.TILESIZE)
						&& map.getTile(x, y).getXCoord() <= (game.getWidth() - cam.getX())
						&& map.getTile(x, y).getYCoord() <= (game.getHeight() - cam.getY())) {
					map.getTile(x, y).render(g);
					//System.out.println(((1-map.getTile(x, y).getOpacity())*255));
					g.setColor(new Color(0, 0, 0, (int)((1-map.getTile(x, y).getOpacity())*255)));
					g.fillRect(x*Tile.TILESIZE, y*Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE);
					map.getTile(x, y).setOpacity(0);
				}
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

	public LinkedList<Entities> getExtras() {
		return this.extras;
	}

	public void addCamera(Camera cam) {
		this.cam = cam;		
	}


	
	
}
