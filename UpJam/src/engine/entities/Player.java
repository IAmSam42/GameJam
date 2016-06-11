package engine.entities;

import java.awt.Color;
import java.awt.Graphics;

import map.Tile;

public class Player extends Entities {
	private boolean aPressed, wPressed, sPressed,dPressed;
	private int playerSpeed;
	
	public Player(int xCoord, int yCoord, int size) {
		super(xCoord, yCoord, size);
		aPressed = false;
		wPressed = false;
		sPressed = false;
		dPressed = false;
		playerSpeed = 1;
	}

	@Override
	public void tick() {
		setVelX(0);
		setVelY(0);
		if(aPressed && !dPressed){
			setVelX(-(int)(playerSpeed*getVelocityBuff()));
		}
		if(!aPressed && dPressed){
			setVelX((int)(playerSpeed*getVelocityBuff()));
		}
		if(!wPressed && sPressed){
			setVelY((int)(playerSpeed*getVelocityBuff()));
		}
		if(wPressed && !sPressed) {
			setVelY(-(int)(playerSpeed*getVelocityBuff()));
		}
		
		setXCoord(getXCoord() + getVelX());
		setYCoord(getYCoord() + getVelY());
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE);

	}
	
	public void setAPressed(boolean n){
		this.aPressed = n;
	}
	
	public void setWPressed(boolean n){
		this.wPressed = n;
	}
	
	public void setDPressed(boolean n){
		this.dPressed = n;
	}
	
	public void setSPressed(boolean n){
		this.sPressed = n;
	}
}
