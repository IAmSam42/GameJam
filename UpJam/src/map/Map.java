package map;


public class Map {
	
	private Tile[][] map;
	private int width;
	private int height;
	private String mapToUse = "default";
	
	public Map(){
		//map = new Tile[this.width][this.height];
		genMap();
	}
	
	public Map(String mapWanting){
		this.mapToUse = mapWanting;
		//map = new Tile[this.width][this.height];
		genMap();
	}
	
	private void genMap(){
		
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
