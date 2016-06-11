package map;


public class Map {
	
	private Tile[][] map;	//Represents the map in the format (x, y)
	private int width;
	private int height;
	
	public Map(){
		this.width = 0;
		this.height = 0;
		
		map = new Tile[this.width][this.height];
		
	}
	
	public Map(String mapWanting){
		this.width = 0;
		this.height = 0;
		
		map = new Tile[this.width][this.height];
		
	}
	
	
	public Tile[][] getMap(){
		return this.map;
	}
	
	public Tile getTile(int x, int y){
		return map[x][y];
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	
}
