package engine.entities;

import java.awt.Color;
import java.awt.Graphics;

import map.Tile;

public class Player extends Entities {
	private boolean aPressed, wPressed, sPressed,dPressed;
	public Player(int xCoord, int yCoord, int size) {
		super(xCoord, yCoord, size);
		aPressed = false;
		wPressed = false;
		sPressed = false;
		dPressed = false;
	}

	@Override
	public void tick() {
		if(aPressed && !dPressed){
			setXCoord(getXCoord()-(int)(defaultVelocity*getVelocityBuff()));
		}
		if(!aPressed && dPressed){
			setXCoord(getXCoord()+(int)(defaultVelocity*getVelocityBuff()));
		}
		if(!wPressed && sPressed){
			setYCoord(getYCoord()-(int)(defaultVelocity*getVelocityBuff()));
		}
		if(wPressed && !sPressed) {
			setYCoord(getYCoord()+(int)(defaultVelocity*getVelocityBuff()));
		}

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE);

	}
	
	public void setAPressed(boolean n){
		aPressed = n;
	}
	
	public void setWPressed(boolean n){
		aPressed = n;
	}
	
	public void setDPressed(boolean n){
		aPressed = n;
	}
	
	public void setSPressed(boolean n){
		aPressed = n;
	}
}
