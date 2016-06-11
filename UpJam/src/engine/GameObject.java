package engine;

import java.awt.Graphics;

public abstract class GameObject {
	
	private int xCoord;
	private int yCoord;
	private int size;
	private boolean isDay = true;
	
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public GameObject(int xCoord, int yCoord, int size){
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.size = size;
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
	
	public boolean isDay(){
		return isDay;
	}
	
	public void setDay(boolean isDay){
		this.isDay = isDay;
	}

}
