package map;

import gui.Game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Floor extends Tile {

	private Image img; 
	
	public Floor(int xCoord, int yCoord, int floorType) {
		super(xCoord, yCoord);
		this.setSolid(false);
		transparency = .7;
		String pathText;
		switch(floorType) {
		
			case (255 << 24) | (255 << 16) | (255 << 8) | (255):
				pathText = "floor/dayCarpet.png";
				break;
			case (255 << 24) | (0 << 16) | (0 << 8) | (0):
				pathText = "floor/deadMan.png";
				break;
			default:
				pathText = null;
		}
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
