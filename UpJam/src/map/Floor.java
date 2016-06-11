package map;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Floor extends Tile {

	private Image img = new ImageIcon(this.path + "floor/dayCarpetTile.png").getImage(); 
	
	public Floor(int xCoord, int yCoord) {
		super(xCoord, yCoord);
		this.setSolid(false);
	}
	

	@Override
	public void tick() {
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(img, this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE, null);
	}

}
