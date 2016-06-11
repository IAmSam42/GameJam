package engine;

import java.awt.Graphics;

public abstract class GameObject {
	
	private int x;
	private int y;
	private int valX;
	private int valY;
	private int objectID;
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public GameObject(int x, int y, int objectID){
		this.x = x;
		this.y = y;
		this.objectID = objectID;
		valX = 0;
		valY = 0;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getValX(){
		return valX;
	}
	
	public void setValX(int valX){
		this.valX = valX;
	}
	
	public int getValY(){
		return valY;
	}
	
	public void setValY(int valY){
		this.valY = valY;
	}
	
	public int getObjectID(){
		return objectID;
	}

}
