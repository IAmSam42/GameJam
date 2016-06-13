package engine;

import engine.entities.Entities;
import engine.entities.OpacityLayer;
import engine.entities.Player;
import engine.entities.Robot;
import gui.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.management.monitor.MonitorSettingException;
import javax.sound.sampled.Clip;

import map.Camera;
import map.Map;
import map.Tile;


public class Handler {
	
	private Game game;
	private Map map;
	private Player player;
	private LinkedList<Entities> robots = new LinkedList<Entities>();
	private LinkedList<Entities> extras = new LinkedList<Entities>();
	private Camera cam;
	private OpacityLayer[][] fog;
	private Clip clip;
	public Handler(Game game) {
		this.game = game;
	}
	
	public void createMap(Map map){
		this.map = map;
		fog = new OpacityLayer[map.getWidth()*2][map.getHeight()*2];

		for(int y = 0; y<map.getHeight()*2;y++){
			for(int x = 0; x<map.getWidth()*2;x++){
				System.out.println("Creating fog block "+x*(Tile.TILESIZE/2)+","+y*(Tile.TILESIZE/2));
				fog[x][y] = new OpacityLayer(x*(Tile.TILESIZE/2) , y*(Tile.TILESIZE/2) , Tile.TILESIZE/2);
			}
		}
		
	}
	
	public void addPlayer(Player player){
		this.player = player;
		player.addMap(map);
		player.addRobots(robots);
	}

	public void addRobot(Entities Robot){
		robots.add(Robot);
	}
	
	public void addExtras(Entities trap) {
		extras.add(trap);		
	}
	
	public LinkedList<Entities> getRobots(){
		return robots;
	}

	public void tick(){
		//No tick needed for Map
		
		//Tick Objects - May not be needed
		for (int i = 0; i < extras.size(); i++) {
			extras.get(i).tick();
		}
		player.tick();
		cam.tick(player);
		
		if(!Game.isDay){
			for (int i = 0; i < robots.size(); i++) {
				robots.get(i).tick();
			}
			for(OpacityLayer[] p: fog)
				for(OpacityLayer q: p)
					q.setOpacity(0);
			
			int x = ((player.getXCoord()+(Tile.TILESIZE/2))/Tile.TILESIZE)*2;
			int y = ((player.getYCoord()+(Tile.TILESIZE/2))/Tile.TILESIZE)*2;
			fog[x][y].setOpacity(1);
			fog[x+1][y].setOpacity(1);
			fog[x][y+1].setOpacity(1);
			fog[x+1][y+1].setOpacity(1);	
			
			fog[x][y].spreadOpacityCorner(x+1, y+1, 1, fog, map);
			fog[x+1][y].spreadOpacityCorner(x, y+1, 1, fog, map);
			fog[x][y+1].spreadOpacityCorner(x+1, y, 1, fog, map);
			fog[x+1][y+1].spreadOpacityCorner(x, y, 1, fog, map);
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
				map.getTile(x, y).setOpacity(0.05);
				}
			}
		}
		
		//Render Extras behind players 
		for (int i = 0; i < extras.size(); i++) {
			extras.get(i).render(g);
		}
		
	
		
		//Render players and AI
		player.render(g);
			
		//Render AI
		if(!Game.isDay){
			for (int i = 0; i < robots.size(); i++) {
				robots.get(i).render(g);
			}
			for(OpacityLayer[] p: fog){
				for(OpacityLayer q: p)
					q.render(g);
			}
		}
		
		//Render objects ontop
		
	}

	public LinkedList<Entities> getExtras() {
		return this.extras;
	}

	public void addCamera(Camera cam) {
		this.cam = cam;		
	}

	public void muteAllRobots(boolean mute) {
		ListIterator<Entities> robotIterator = robots.listIterator();
		while(robotIterator.hasNext()){
			((Robot)robotIterator.next()).getRobotAudio().mute(mute);
		}
		
	}


	
	
}
