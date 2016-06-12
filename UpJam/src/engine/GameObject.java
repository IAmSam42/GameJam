package engine;

import java.awt.Graphics;
import java.awt.geom.Line2D;

import map.Tile;


public abstract class GameObject {
	
	private int xCoord;
	private int yCoord;
	private int size;
	//private boolean isDay = true;
	
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public GameObject(int xCoord, int yCoord, int size){
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.size = size;
	}
	
	protected int getTopBound(){
		return yCoord;
	}
	
	protected int getLeftbound(){
		return xCoord;
	}
	
	public int getRightBound(){
		return (xCoord + Tile.TILESIZE);
	}
	
	protected int getBottomBound(){
		return (yCoord + Tile.TILESIZE);
	}


	protected enum BoundPosition{
		Top, Right, Left, Bottom;
	}
	
	public Line2D getBoundsTest(BoundPosition pos) {
		switch(pos){
			case Top:
				return new Line2D.Double(xCoord, yCoord, xCoord+Tile.TILESIZE, yCoord);
			case Right:
					return new Line2D.Double(xCoord+Tile.TILESIZE, yCoord+1, xCoord+Tile.TILESIZE, yCoord+Tile.TILESIZE-2);
			case Left:
					return new Line2D.Double(xCoord, yCoord+1, xCoord, yCoord+Tile.TILESIZE-2);
			case Bottom:
					return new Line2D.Double(xCoord, yCoord+Tile.TILESIZE, xCoord+Tile.TILESIZE, yCoord+Tile.TILESIZE);
			default:
					return null;
	
		}
	}
	
	
	public int getXCoord(){
		return xCoord;
	}
	
	public void setXCoord(int xCoord){
		this.xCoord = xCoord;
	}
	
	public int getYCoord(){
		return yCoord;
	}
	
	public void setYCoord(int yCoord){
		this.yCoord = yCoord;
	}
	
	public int getSize(){
		return size;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	/*public boolean isDay(){
		return isDay;
	}
	
	public void setDay(boolean isDay){
		this.isDay = isDay;
	}*/

}
