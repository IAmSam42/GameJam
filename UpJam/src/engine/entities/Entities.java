package engine.entities;

import map.Map;
import engine.GameObject;

public abstract class Entities extends GameObject {
	private int velX, velY;
	protected Map map;
	
	//1 if character has no buffs, if they are slowed by 50% then .5 etc. 
	private double velocityBuff;
	
	public Entities(int xCoord, int yCoord, int size) 
	{
		super(xCoord, yCoord, size);
		velX = 0;
		velY = 0;
		velocityBuff = 1;
	}
	
	public int getVelX(){
		return velX;
	}
	
	public int getVelY(){
		return velY;
	}
	
	public double getVelocityBuff(){
		return velocityBuff;
	}
	
	public void setVelX(int velX){
		this.velX = velX;
	}
	
	public void setVelY(int velY){
		this.velY = velY;
	}
	
	public void setVelocityBuff(double velbuff){
		this.velocityBuff = velbuff;
	}
	
	public void addMap(Map map) {
		this.map = map;
	}
	
	
}
