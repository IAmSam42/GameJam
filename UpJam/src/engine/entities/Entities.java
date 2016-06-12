package engine.entities;

import map.Map;
import misc.Direction;
import engine.GameObject;

public abstract class Entities extends GameObject {
	protected int velocity;
	protected Map map;
	protected Direction direction;
	
	//1 if character has no buffs, if they are slowed by 50% then .5 etc. 
	private double velocityBuff;
	
	public Entities(int xCoord, int yCoord, int size) 
	{
		super(xCoord, yCoord, size);
		velocity = 0;
		velocityBuff = 1;
	}
	
	public int getVelocity(){
		return velocity;
	}
	
	public double getVelocityBuff(){
		return velocityBuff;
	}
	
	public void setVelocity(int velocity){
		this.velocity = velocity;
	}
	
	public void setVelocityBuff(double velbuff){
		this.velocityBuff = velbuff;
	}
	
	public void addMap(Map map) {
		this.map = map;
	}
	
	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	public Direction getDirection()
	{
		return direction;
	}
	
	
}
