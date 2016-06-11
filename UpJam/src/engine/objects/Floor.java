package engine.objects;

import java.awt.Graphics;

public class Floor extends Tile {

	public Floor(int xCoord, int yCoord) {
		super(xCoord, yCoord);
		this.setSolid(false);
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
