package engine.ai;

import java.util.Stack;

import map.Map;
import map.Tile;

public class RobotIntelligence {
	
	private int xPixelCoord;
	private int yPixelCoord;
	
	private TilePosition tilePos;
	private TilePosition tileGoal;
	
	
	private Map map;
	private Stack<TilePosition> tileMoves;
	
	public RobotIntelligence(int xStart, int yStart, Map map) 
	{
		xPixelCoord = xStart;
		yPixelCoord = yStart;
		
		updateTileCoord();
		
		this.map = map;
	}
	
	private void updateTileCoord()
	{
		this.tilePos.setX(xPixelCoord / Tile.TILESIZE);
		this.tilePos.setY(yPixelCoord / Tile.TILESIZE);
	}

	public void nextPosition()
	{
		TilePosition nextTile = tileMoves.peek();
		if(tilePos.equals(nextTile))
		{
			//tileMoves
		}
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
