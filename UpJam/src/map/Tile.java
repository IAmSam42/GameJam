package map;

import engine.GameObject;
import misc.Directions;

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
	
	public void calculateOpacity(Map map, Directions direction, double inputopacity) {
		opacity += inputopacity;
		if(transparency>.2){
			switch(direction){
			case UP:
				map.getTile((getXCoord()/TILESIZE)+1, getYCoord()/TILESIZE-1).calculateOpacity(map, direction, inputopacity*.7*transparency);
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE-1).calculateOpacity(map, direction, inputopacity*.7*transparency);
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE+-1).calculateOpacity(map, direction, inputopacity*transparency);
			case UPRIGHT:
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE-1).calculateOpacity(map, direction, inputopacity*transparency);
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE-1).calculateOpacity(map, direction, inputopacity*transparency*.7);
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE).calculateOpacity(map, direction, inputopacity*transparency*.7);
			case UPLEFT:
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE-1).calculateOpacity(map, direction, inputopacity*transparency);
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE-1).calculateOpacity(map, direction, inputopacity*transparency*.7);
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE).calculateOpacity(map, direction, inputopacity*transparency*.7);
			case DOWN:
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE+1).calculateOpacity(map, direction, inputopacity*.7*transparency);
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE+1).calculateOpacity(map, direction, inputopacity*.7*transparency);
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE+1).calculateOpacity(map, direction, inputopacity*transparency);
			case DOWNRIGHT:
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE+1).calculateOpacity(map, direction, inputopacity*transparency);
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE+1).calculateOpacity(map, direction, inputopacity*transparency*.7);
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE).calculateOpacity(map, direction, inputopacity*transparency*.7);
			case DOWNLEFT:
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE+1).calculateOpacity(map, direction, inputopacity*transparency);
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE+1).calculateOpacity(map, direction, inputopacity*transparency*.7);
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE).calculateOpacity(map, direction, inputopacity*transparency*.7);
			case LEFT:
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE-1).calculateOpacity(map, direction, inputopacity*transparency*.7);
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE+1).calculateOpacity(map, direction, inputopacity*transparency*.7);
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE).calculateOpacity(map, direction, inputopacity*transparency*.7);
			case RIGHT:
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE-1).calculateOpacity(map, direction, inputopacity*transparency*.7);
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE+1).calculateOpacity(map, direction, inputopacity*transparency*.7);
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE).calculateOpacity(map, direction, inputopacity*transparency*.7);
			}
		}
	}
	
	
}
