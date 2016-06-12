package map;

import engine.entities.Entities;


public class Camera {
	
	public float x;
	public float y;
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void tick(Entities player){
		x = -player.getXCoord() + (32*12);
		y = -player.getYCoord() + (32*5);
	}
	
	
	public float getX(){
		return x;
	}
	
    public void setX(float x){
    	this.x = x;
    }

	public float getY(){
		return y;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	
	
}
