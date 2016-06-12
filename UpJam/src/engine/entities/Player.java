package engine.entities;

import java.awt.Color;
import java.awt.Graphics;

import engine.Handler;
import map.Tile;

public class Player extends Entities {
	
	private boolean aPressed = false , wPressed = false, sPressed = false, dPressed = false;
	private int playerSpeed = 1;
	private Handler handler;
	
	public Player(int xCoord, int yCoord, int size, Handler handler) {
		super(xCoord, yCoord, size);
		this.handler = handler;
		handler.addPlayer(this);
	}

	@Override
	public void tick() {
		setVelX(0);
		setVelY(0);
		if(aPressed && !dPressed /**&& canMoveTo("a")*/){
			setVelX(-(int)(playerSpeed*getVelocityBuff()));
		}
		if(!aPressed && dPressed /*&& canMoveTo("d")*/){
			setVelX((int)(playerSpeed*getVelocityBuff()));
		}
		if(!wPressed && sPressed /*&& canMoveTo("s")*/){
			setVelY((int)(playerSpeed*getVelocityBuff()));
		}
		if(wPressed && !sPressed /*&& canMoveTo("w")*/){
			setVelY(-(int)(playerSpeed*getVelocityBuff()));
		}
		
		setXCoord(getXCoord() + getVelX());
		setYCoord(getYCoord() + getVelY());
	}
	
	private boolean canMoveTo(String input) {
		boolean leftSide = this.getBoundsTest(BoundPosition.Left).intersectsLine(this.map.getTile(getXCoord()/Tile.TILESIZE -1, getYCoord()/Tile.TILESIZE).getBoundsTest(BoundPosition.Right));
		
		if(input.equals("a") && leftSide && 
				!(this.map.getTile(((getXCoord()-1)/Tile.TILESIZE), getYCoord()/Tile.TILESIZE).isSolid())){return true;}
		/*if(input.equals("d") && rightSide && 
				!(this.map.getTile(((getXCoord()+Tile.TILESIZE)/Tile.TILESIZE), getYCoord()/Tile.TILESIZE).isSolid())){return true;}
		if(input.equals("s") && bottomSide && 
				!(this.map.getTile( getXCoord()/Tile.TILESIZE, ((getYCoord()-1)/Tile.TILESIZE)).isSolid())){return true;}
		if(input.equals("w") && topSide && 
				!(this.map.getTile( getXCoord()/Tile.TILESIZE,  ((getYCoord()+Tile.TILESIZE)/Tile.TILESIZE) ).isSolid())){return true;}
		*/
		
		return false;
	}
	
	/*private boolean canMoveTo(String input) {
		System.out.println("PLAYER IN: " + getXCoord()/Tile.TILESIZE + " | " + getYCoord()/Tile.TILESIZE);
		boolean leftSide = ((getXCoord()-1)/Tile.TILESIZE) >= 0;
		boolean bottomSide = ((getYCoord()+1)/Tile.TILESIZE) < this.map.getHeight();
		
		boolean rightSide = ((getXCoord()+1)/Tile.TILESIZE)< this.map.getWidth();
		boolean topSide = ((getYCoord()-1)/Tile.TILESIZE) >=0;
		
		if(input.equals("a") && leftSide && 
				!(this.map.getTile(((getXCoord()-1)/Tile.TILESIZE), getYCoord()/Tile.TILESIZE).isSolid())){return true;}
		if(input.equals("d") && rightSide && 
				!(this.map.getTile(((getXCoord()+Tile.TILESIZE)/Tile.TILESIZE), getYCoord()/Tile.TILESIZE).isSolid())){return true;}
		if(input.equals("s") && bottomSide && 
				!(this.map.getTile( getXCoord()/Tile.TILESIZE, ((getYCoord()-1)/Tile.TILESIZE)).isSolid())){return true;}
		if(input.equals("w") && topSide && 
				!(this.map.getTile( getXCoord()/Tile.TILESIZE,  ((getYCoord()+Tile.TILESIZE)/Tile.TILESIZE) ).isSolid())){return true;}
		return false;
	}*/
	
	/*private boolean canMoveTo(String input) {
		System.out.println("PLAYER IN: " + getXCoord()/Tile.TILESIZE + " | " + getYCoord()/Tile.TILESIZE);
		boolean leftSide = ((getXCoord()/Tile.TILESIZE) -1) >= 0;
		boolean bottomSide = ((getXCoord()/Tile.TILESIZE) +1) < this.map.getHeight();
		
		boolean rightSide = ((getYCoord()/Tile.TILESIZE) +1) < this.map.getWidth();
		boolean topSide = ((getYCoord()/Tile.TILESIZE) -1) >=0;
		
		if(input.equals("a") && leftSide && 
				!(this.map.getTile(((getXCoord()/Tile.TILESIZE) -1), getYCoord()/Tile.TILESIZE).isSolid())){return true;}
		if(input.equals("d") && rightSide && 
				!(this.map.getTile(((getXCoord()/Tile.TILESIZE) +1), getYCoord()/Tile.TILESIZE).isSolid())){return true;}
		if(input.equals("s") && bottomSide && 
				!(this.map.getTile( getXCoord()/Tile.TILESIZE, ((getYCoord()/Tile.TILESIZE) -1)).isSolid())){return true;}
		if(input.equals("w") && topSide && 
				!(this.map.getTile( getXCoord()/Tile.TILESIZE,  ((getYCoord()/Tile.TILESIZE) +1) ).isSolid())){return true;}
		return false;
	}*/
	
	/*private boolean canMoveTo() {
		System.out.println("PLAYER IN: " + getXCoord()/Tile.TILESIZE + " | " + getYCoord()/Tile.TILESIZE);
		boolean leftSide = ((getXCoord()/Tile.TILESIZE) -1) >= 0;
		boolean bottomSide = ((getXCoord()/Tile.TILESIZE) +1) < this.map.getHeight();
		
		boolean rightSide = ((getYCoord()/Tile.TILESIZE) +1) < this.map.getWidth();
		boolean topSide = ((getYCoord()/Tile.TILESIZE) -1) >=0;
		
		if(this.aPressed && leftSide && 
				!(this.map.getTile(((getXCoord()/Tile.TILESIZE) -1), getYCoord()/Tile.TILESIZE).isSolid())){return true;}
		if(this.dPressed && rightSide && 
				!(this.map.getTile(((getXCoord()/Tile.TILESIZE) +1), getYCoord()/Tile.TILESIZE).isSolid())){return true;}
		if(this.sPressed&& bottomSide && 
				!(this.map.getTile( getXCoord()/Tile.TILESIZE, ((getYCoord()/Tile.TILESIZE) +1)).isSolid())){return true;}
		if(this.wPressed&& topSide && 
				!(this.map.getTile( getXCoord()/Tile.TILESIZE,  ((getYCoord()/Tile.TILESIZE) +1) ).isSolid())){return true;}
		return false;
	}*/

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


	public void dropTrap() {
		handler.addExtras(new Trap((((int)((getXCoord()+16)/32))*32)+8,(((int)((getYCoord()+16)/32))*32)+8,Tile.TILESIZE));	
	}
}
