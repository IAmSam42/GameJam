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
	
	
	
	/*
	public void calculateOpacityForward(Map map, Direction direction, double inputopacity) {
		opacity = inputopacity;
		double outputOpacity = inputopacity*transparency;
		double peripherySight = .8;
		
		try{
		if(outputOpacity>.1){
			switch(direction){
			case UP:
				map.getTile((getXCoord()/TILESIZE)+1, getYCoord()/TILESIZE-1).calculateOpacityDiagonalStarboard(map, direction, outputOpacity*peripherySight);
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE-1).calculateOpacityDiagonalPort(map, direction, outputOpacity*peripherySight);
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE-1).calculateOpacityForward(map, direction, outputOpacity);
			case UPRIGHT:
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE-1).calculateOpacityForward(map, direction, outputOpacity);
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE-1).calculateOpacityDiagonalPort(map, direction, outputOpacity*peripherySight);
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE).calculateOpacityDiagonalStarboard(map, direction, outputOpacity*peripherySight);
			case UPLEFT:
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE-1).calculateOpacityForward(map, direction, outputOpacity);
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE-1).calculateOpacityDiagonalStarboard(map, direction, outputOpacity*peripherySight);
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE).calculateOpacityDiagonalPort(map, direction, outputOpacity*peripherySight);
			case DOWN:
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE+1).calculateOpacityDiagonalPort(map, direction, outputOpacity*peripherySight);
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE+1).calculateOpacityDiagonalStarboard(map, direction, outputOpacity*peripherySight);
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE+1).calculateOpacityForward(map, direction, outputOpacity);
			case DOWNRIGHT:
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE+1).calculateOpacityForward(map, direction, outputOpacity);
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE+1).calculateOpacityDiagonalStarboard(map, direction, outputOpacity*peripherySight);
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE).calculateOpacityDiagonalPort(map, direction, outputOpacity*peripherySight);
			case DOWNLEFT:
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE+1).calculateOpacityForward(map, direction, outputOpacity);
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE+1).calculateOpacityDiagonalPort(map, direction, outputOpacity*peripherySight);
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE).calculateOpacityDiagonalStarboard(map, direction, outputOpacity*peripherySight);
			case LEFT:
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE-1).calculateOpacityDiagonalStarboard(map, direction, outputOpacity*peripherySight);
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE+1).calculateOpacityDiagonalPort(map, direction, outputOpacity*peripherySight);
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE).calculateOpacityForward(map, direction, outputOpacity);
			case RIGHT:
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE-1).calculateOpacityDiagonalPort(map, direction, outputOpacity*peripherySight);
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE+1).calculateOpacityDiagonalStarboard(map, direction, outputOpacity*peripherySight);
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE).calculateOpacityForward(map, direction, outputOpacity);
			}
		}
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Trying to set opacity for non existent tile");
		}
		
	}

	private void calculateOpacityDiagonalPort(Map map, Direction direction, double inputopacity) {
		opacity = inputopacity;
		double outputOpacity = inputopacity*transparency;
//		System.out.println("FINDING PORT FOR ("+getXCoord()+","+getYCoord()+")");
		try{
		if(outputOpacity>.1){
			switch(direction){
			case UP:
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE-1).calculateOpacityDiagonalPort(map, direction, outputOpacity);
			case UPLEFT:
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE).calculateOpacityDiagonalPort(map, direction, outputOpacity);
			case UPRIGHT:
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE-1).calculateOpacityDiagonalPort(map, direction, outputOpacity);
			case LEFT:
				map.getTile(getXCoord()/TILESIZE-1, getYCoord()/TILESIZE+1).calculateOpacityDiagonalPort(map, direction, outputOpacity);
			case DOWNLEFT:
				map.getTile(getXCoord()/TILESIZE, getYCoord()/TILESIZE+1).calculateOpacityDiagonalPort(map, direction, outputOpacity);
			case DOWN:
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()/TILESIZE+1).calculateOpacityDiagonalPort(map, direction, outputOpacity);
			case DOWNRIGHT:
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()).calculateOpacityDiagonalPort(map, direction, outputOpacity);
			case RIGHT:
				map.getTile(getXCoord()/TILESIZE+1, getYCoord()-1).calculateOpacityDiagonalPort(map, direction, outputOpacity);
			}
		}
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Trying to set opacity for non existent tile");
		}
	
	}

	private void calculateOpacityDiagonalStarboard(Map map, Direction direction, double inputopacity) {
		opacity = inputopacity;
		double outputOpacity = inputopacity*transparency;
//		System.out.println("FINDING STARBOARD FOR ("+getXCoord()+","+getYCoord()+")");
		if(outputOpacity>.1){
			switch(direction){
			case UP:
				map.getTile(getXCoord()+1, getYCoord()-1).calculateOpacityDiagonalStarboard(map, direction, outputOpacity);
			case UPLEFT:
				map.getTile(getXCoord(), getYCoord()-1).calculateOpacityDiagonalStarboard(map, direction, outputOpacity);
			case UPRIGHT:
				map.getTile(getXCoord()+1, getYCoord()).calculateOpacityDiagonalStarboard(map, direction, outputOpacity);
			case LEFT:
				map.getTile(getXCoord()-1, getYCoord()-1).calculateOpacityDiagonalStarboard(map, direction, outputOpacity);
			case DOWNLEFT:
				map.getTile(getXCoord()-1, getYCoord()).calculateOpacityDiagonalStarboard(map, direction, outputOpacity);
			case DOWN:
				map.getTile(getXCoord()-1, getYCoord()+1).calculateOpacityDiagonalStarboard(map, direction, outputOpacity);
			case DOWNRIGHT:
				map.getTile(getXCoord(), getYCoord()+1).calculateOpacityDiagonalStarboard(map, direction, outputOpacity);
			case RIGHT:
				map.getTile(getXCoord()+1, getYCoord()+1).calculateOpacityDiagonalStarboard(map, direction, outputOpacity);
			}
		}
		
	}
	*/
	
}
