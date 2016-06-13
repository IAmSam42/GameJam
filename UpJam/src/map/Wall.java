package map;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Wall extends Tile {
	
	
	private Image img;
	
	
	public Wall(int xCoord, int yCoord, String pathText) {
		super(xCoord, yCoord);
		this.setSolid(true);
		transparency = 0;

		img = new ImageIcon(this.path + pathText).getImage();
	}
	
	
	
	@Override
	public void tick() {
	}
	

	@Override
	public void render(Graphics g) {
		g.drawImage(img, this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE, null);
	}
}
