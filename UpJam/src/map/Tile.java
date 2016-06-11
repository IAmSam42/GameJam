package map;

import engine.GameObject;

public abstract class Tile extends GameObject
{
	private boolean solid;
	protected String path = "res/textures/";
	
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
	
	public void setTexture(String texture){
	}
}
