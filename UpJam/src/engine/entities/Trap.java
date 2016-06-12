package engine.entities;

//import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import map.Tile;

public class Trap extends Entities {

	public Trap(int xCoord, int yCoord, int size) {
		super(xCoord, yCoord, size);
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(new ImageIcon("resources/traps/magnetTrap.png").getImage() , this.getXCoord(), this.getYCoord(), Tile.TILESIZE/2, Tile.TILESIZE/2,null);
		
		//g.setColor(Color.BLUE);
		//g.fillRect(this.getXCoord(), this.getYCoord(), Tile.TILESIZE/2, Tile.TILESIZE/2);

	}

}
