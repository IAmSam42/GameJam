package engine.entities;

import java.awt.Color;
import java.awt.Graphics;

import map.Tile;

public class Player extends Entities {

	public Player(int xCoord, int yCoord, int size) {
		super(xCoord, yCoord, size);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE);

	}

}
