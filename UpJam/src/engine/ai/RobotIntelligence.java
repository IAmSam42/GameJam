package engine.ai;

import java.util.Queue;

import map.Map;

public class RobotIntelligence {
	
	private int xPixelCoord;
	private int yPixelCoord;
	private Map map;
	private Queue<TilePosition> tileMoves;
	
	public RobotIntelligence(int xStart, int yStart, Map map) 
	{
		xPixelCoord = xStart;
		yPixelCoord = yStart;
		this.map = map;
	}

	public void nextPosition()
	{
		
	}
	
	public int getX()
	{
		return xPixelCoord;
	}
	
	public int getY()
	{
		return yPixelCoord;
	}
}
