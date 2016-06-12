package engine.ai;

import java.util.Random;

import map.Map;
import map.Tile;

public class RobotIntelligence
{
	
	private int xPixelCoord;
	private int yPixelCoord;
	
	private TilePosition tilePos;
	private TilePosition tileGoal;
	
	private Random generator;
	
	private Map map;
	private TilePath tileMoves;
	
	public RobotIntelligence(int xStart, int yStart, Map map) 
	{
		xPixelCoord = xStart;
		yPixelCoord = yStart;
		this.map = map;
		
		tilePos = new TilePosition(0, 0);
		tileGoal = new TilePosition(0, 0);
		
		generator = new Random();
		
		updateTileCoord();
		newRandomGoal();
		
		SearchAlgorithm pathing = new SearchAlgorithm(tilePos, tileGoal, map);
		tileMoves = pathing.search();
	}
	
	private void updateTileCoord()
	{
		this.tilePos.setX(xPixelCoord / Tile.TILESIZE);
		this.tilePos.setY(yPixelCoord / Tile.TILESIZE);
	}
	
	private void newRandomGoal()
	{
		int xCoord;
		int yCoord; 
		
		while(true)
		{
			xCoord = generator.nextInt(map.getWidth() - 1);
			yCoord = generator.nextInt(map.getHeight() - 1);
			
			if(!map.getTile(xCoord, yCoord).isSolid())
			{
				break;
			}
		}
		
		this.tileGoal.setX(xCoord);
		this.tileGoal.setY(yCoord);
	}
}
