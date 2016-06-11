package map;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Wall extends Tile {
	
	private Image img = new ImageIcon(this.path + "wall/greyWall.png").getImage(); 
	
	public Wall(int xCoord, int yCoord) {
		super(xCoord, yCoord);
		this.setSolid(true);
		System.out.println("WALL: " + yCoord);
	}
	
	@Override
	public void tick() {
	}
	
	@Override
	public void render(Graphics g) {
	
		g.drawImage(img, this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE, null);
	}
}
