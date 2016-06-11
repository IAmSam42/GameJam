package map;

import engine.objects.Tile;

public class Map {
	
	private Tile[][] map;
	private int width;
	private int height;
	
	public Map(){
		this.width = 0;
		this.height = 0;
		
		map = new Tile[this.width][this.height];
		
	}
	
	public Tile[][] getMap(){
		return this.map;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	
}
