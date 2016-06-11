package map;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Map {
	
	//The values for each tile type are as follows:
	// wall (a: 255, r: 255, g:255, b:255)
	final int wall = (255 << 24) | (255 << 16) | (255 << 8) | (255);
	// tile (a:255, r:0, g:0, b:0)
	final int floor = (255 << 24) | (0 << 16) | (0 << 8) | (0);
	// end
	
	private Tile[][] map;//Represents the map in the format (x, y)
	private int width;
	private int height;
	private String mapToUse = "default";
	
	public Map(){
		//map = new Tile[this.width][this.height];
		genMap();
	}
	

	public Map(String fileLocation) throws IOException {
		File file  = new File(fileLocation);
		BufferedImage mapimage = ImageIO.read(file);
		
		this.width = mapimage.getWidth();
		this.height = mapimage.getHeight();		
		map = new Tile[this.width][this.height];
		
		for(int y=0; y<height; y++){
			for(int x=0; x<width; x++){
				int rgbVal = mapimage.getRGB(x, y);

				switch(rgbVal) {
					case floor:
						map[x][y] = new Floor(x, y);
					case wall:
						map[x][y] = new Wall(x, y);
				}
			}
		}
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
