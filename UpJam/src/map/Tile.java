package map;

import engine.GameObject;
import misc.Direction;

public abstract class Tile extends GameObject
{
	private double opacity;
	protected double transparency;
	private boolean solid;
	protected String path = "resources/textures/";
	
	public static final int TILESIZE = 32;
	
	
	public Tile(int xCoord, int yCoord) {
		super(xCoord, yCoord, TILESIZE);
	}

	public boolean isSolid(){
		return solid;
	}
	
	public void setSolid(boolean solid){
		this.solid = solid;
	}
	
	public synchronized double getOpacity(){
		return opacity;
	}
	public synchronized void setOpacity(double op){
		opacity = op;
	}

	public double getTransparancy(){
		return transparency;
	}
	
	
	
}
