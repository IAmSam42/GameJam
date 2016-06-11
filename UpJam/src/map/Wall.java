package map;

import java.awt.Graphics;

public class Wall extends Tile {

	public Wall(int xCoord, int yCoord) {
		super(xCoord, yCoord);
		this.setSolid(true);
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
