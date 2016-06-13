package map;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Map {
	
	//The values for each tile type are as follows:
	// dayCarpet (a: 255, r: 255, g:255, b:255)
	final int dayCarpet = (255 << 24) | (255 << 16) | (255 << 8) | (255);
	// deadMan (a: 255, r: 255, g:255, b:255)
	final int deadMan = (255 << 24) | (0 << 16) | (0 << 8) | (0);
	// blood (a:255, r:140, g:1, b:1)
	final int blood = (255 << 24) | (140 << 16) | (1 << 8) | (1);
	// inUpLeft (a:255, r:61, g:255, b:2)
	final int cornerInUpLeft = (255 << 24) | (61 << 16) | (255 << 8) | (2);
	// inUpRight (a:255, r:247, g:255, b:3)
	final int cornerInUpRight = (255 << 24) | (247 << 16) | (255 << 8) | (3);
	// inDownLeft (a:255, r:3, g:247, b:255)
	final int cornerInDownLeft = (255 << 24) | (3 << 16) | (247 << 8) | (255);
	// inDownRight (a:255, r:196, g:3, b:255)
	final int cornerInDownRight = (255 << 24) | (196 << 16) | (3 << 8) | (255);
	// ourtUpLeft(a:255, r:32, g:40, b:119)
	final int cornerOutUpLeft = (255 << 24) | (32 << 16) | (40 << 8) | (119);
	// outUpRight (a:255, r:255, g:0, b:228)
	final int cornerOutUpRight = (255 << 24) | (255 << 16) | (0 << 8) | (228);
	// outDownLeft (a:255, r:82, g:63, b:73)
	final int cornerOutDownLeft = (255 << 24) | (82 << 16) | (63 << 8) | (72);
	// outDownRight (a:255, r:77, g:207, b:155)
	final int cornerOutDownRight = (255 << 24) | (77 << 16) | (207 << 8) | (155);
	// Down(a:255, r:255, g:3, b:104)
	final int wallDown = (255 << 24) | (255 << 16) | (3 << 8) | (104);
	// Up (a:255, r:255, g:112, b:3)
	final int wallUp = (255 << 24) | (255 << 16) | (112 << 8) | (3);
	// Left (a:255, r:1, g:117, b:1)
	final int wallLeft = (255 << 24) | (1 << 16) | (117 << 8) | (1);
	// Right (a:255, r:255, g:3, b:3)
	final int wallRight = (255 << 24) | (255 << 16) | (3 << 8) | (3);
	
	// end
	
	private Tile[][] map;//Represents the map in the format (x, y)
	private int width;
	private int height;
	private String fileLocation = "resources/maps/bloodColourTestMapBig.bmp";
	
	public Map(){
		genMap();
	}
	
	public Map(String fileLocation) {
		this.fileLocation = fileLocation;
		genMap();
	}
	
	private void genMap(){
		File file  = new File(fileLocation);
		try {
			BufferedImage mapimage = ImageIO.read(file);
			this.width = mapimage.getWidth();
			this.height = mapimage.getHeight();		
			map = new Tile[this.width][this.height];
		
			for(int y=0; y < this.height; y++){
				for(int x=0; x < this.width; x++){
					int rgbVal = mapimage.getRGB(x, y);
					switch(rgbVal) {
						
						case dayCarpet:
							map[x][y] = new Floor(x*Tile.TILESIZE, y*Tile.TILESIZE, "floor/dayCarpet.png");
							break;
						case deadMan:
							map[x][y] = new Floor(x*Tile.TILESIZE, y*Tile.TILESIZE, "floor/deadMan.png");
							break;
						case blood:
							map[x][y] = new Floor(x*Tile.TILESIZE, y*Tile.TILESIZE, "floor/blood.png");
							break;
						case wallUp:
							map[x][y] = new Wall(x*Tile.TILESIZE, y*Tile.TILESIZE, "wall/wallWholeUp.png");
							break;
						case wallDown:
							map[x][y] = new Wall(x*Tile.TILESIZE, y*Tile.TILESIZE, "wall/wallWholeDown.png");
							break;
						case wallLeft:
							map[x][y] = new Wall(x*Tile.TILESIZE, y*Tile.TILESIZE, "wall/wallWholeLeft.png");
							break;
						case wallRight:
							map[x][y] = new Wall(x*Tile.TILESIZE, y*Tile.TILESIZE, "wall/wallWholeRight.png");
							break;
						case cornerInUpRight:
							map[x][y] = new Wall(x*Tile.TILESIZE, y*Tile.TILESIZE, "wall/wallCornerIUR.png");
							break;
						case cornerInUpLeft:
							map[x][y] = new Wall(x*Tile.TILESIZE, y*Tile.TILESIZE, "wall/wallCornerIUL.png");
							break;
						case cornerInDownRight:
							map[x][y] = new Wall(x*Tile.TILESIZE, y*Tile.TILESIZE, "wall/wallCornerIDR.png");
							break;
						case cornerInDownLeft:
							map[x][y] = new Wall(x*Tile.TILESIZE, y*Tile.TILESIZE, "wall/wallCornerIDL.png");
							break;
						case cornerOutUpRight:
							map[x][y] = new Wall(x*Tile.TILESIZE, y*Tile.TILESIZE, "wall/wallCornerOUR.png");
							break;
						case cornerOutUpLeft:
							map[x][y] = new Wall(x*Tile.TILESIZE, y*Tile.TILESIZE, "wall/wallCornerOUL.png");
							break;
						case cornerOutDownRight:
							map[x][y] = new Wall(x*Tile.TILESIZE, y*Tile.TILESIZE, "wall/wallCornerODR.png");
							break;
						case cornerOutDownLeft:
							map[x][y] = new Wall(x*Tile.TILESIZE, y*Tile.TILESIZE, "wall/wallCornerODL.png");
							break;
						default: 
							map[x][y] = new TextureError(x*Tile.TILESIZE, y*Tile.TILESIZE);
							System.err.println("Non Recognised Colour");
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Can't Find Map");
			e.printStackTrace();
		}
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
