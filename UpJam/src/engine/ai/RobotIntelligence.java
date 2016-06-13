package engine.ai;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import engine.entities.Player;
import engine.entities.Robot;
import map.Map;
import map.Tile;
import misc.Direction;

public class RobotIntelligence
{
	private TilePosition tilePos;
	private TilePosition tileGoal;
	
	private Random generator;
	
	private Map map;
	private TilePath path;
	private Robot robot;
	private Player player;
	
	public RobotIntelligence(Map map, Robot robot, Player player) 
	{
		this.map = map;
		this.robot = robot;
		this.player = player;
		
		tilePos = new TilePosition(0, 0);
		tileGoal = new TilePosition(0, 0);
		
		generator = new Random();
		
		updateTileCoord();
		newRandomGoal();
		
		calculatePath();
	}
	
	private void updateTileCoord()
	{
		this.tilePos.setX(robot.getXCoord() / Tile.TILESIZE);
		this.tilePos.setY(robot.getYCoord() / Tile.TILESIZE);
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
				if(!(new TilePosition(xCoord, yCoord) == tileGoal))
				{
					break;
				}
			}
		}
		
		this.tileGoal.setX(xCoord);
		this.tileGoal.setY(yCoord);
	}
	
	private void calculatePath()
	{
		SearchAlgorithm pathing = new SearchAlgorithm(tilePos, tileGoal, map);
		path = pathing.search();
	}
	
	public void setGoal(int xCoord, int yCoord)
	{
		this.tileGoal.setX(xCoord);
		this.tileGoal.setY(yCoord);
		
		calculatePath();
	}
	
	public boolean scanPlayer()
	{
		if(detectPixel(player.getXCoord() + (player.getSize()/2), 
				player.getYCoord() + (player.getSize()/2)))
		{
			int playerXTile = (player.getXCoord()+(player.getSize()/2))/32;
			int playerYTile = (player.getYCoord()+(player.getSize()/2))/32;
			
			if(!(tileGoal.equals(new TilePosition(playerXTile, playerYTile))))
			{
				setGoal(playerXTile, playerYTile);
			}
			robot.setTracking(true);
			return true;
		}
		
		return false;
	}
	
	public boolean detectPixel(int xCoord, int yCoord)
	{
		int xCenter = robot.getXCoord() + robot.getSize();
		int yCenter = robot.getYCoord() + robot.getSize();
		
		int distSqr = ((xCenter-xCoord) * (xCenter-xCoord)) + ((yCenter-yCoord)*(yCenter-yCoord));
		double dist = Math.sqrt((double)distSqr);
		
		if(dist> (robot.getSight()*Tile.TILESIZE))
		{
			return false;
		}
		
		Line2D sightLine = new Line2D.Double(xCenter, yCenter, xCoord, yCoord);
		
		for(int i=0; i<map.getWidth(); i++)
		{
			for(int j=0; j<map.getHeight(); j++)
			{
				if(map.getTile(i, j).isSolid())
				{
					Rectangle2D block = new Rectangle(i*Tile.TILESIZE, j*Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE); 
					if(sightLine.intersects(block))
					{
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public void nextMove()
	{
		if(tilePos.equals(path.getNextTile()))
		{
			if((robot.getXCoord() % Tile.TILESIZE) != 0)
			{
				moveRight();
				return;
			}
			else if((robot.getYCoord() % Tile.TILESIZE) != 0)
			{
				moveUp();
				return;
			}
			path.popNextTile();
			updateTileCoord();
			
		}
		
		if(path.length() > 0)
		{
			if(tilePos.getX() < path.getNextTile().getX())
			{
				moveLeft();
			}
			else if(tilePos.getX() > path.getNextTile().getX())
			{
				moveRight();
			}
			else if(tilePos.getY() < path.getNextTile().getY())
			{
				moveDown();
			}
			else if(tilePos.getY() > path.getNextTile().getY())
			{
				moveUp();
			}
		}
		else
		{
			if(!scanPlayer())
			{
				robot.setTracking(false);
				newRandomGoal();
				calculatePath();
			}
		}
	}	
	
	public void moveLeft()
	{
		robot.setDirection(Direction.DOWN);
		robot.setXCoord(robot.getXCoord() + 1);
		updateTileCoord();
	}
	
	public void moveRight()
	{
		robot.setDirection(Direction.DOWN);
		robot.setXCoord(robot.getXCoord() - 1);
		updateTileCoord();
	}
	
	public void moveDown()
	{
		robot.setDirection(Direction.DOWN);
		robot.setYCoord(robot.getYCoord() + 1);
		updateTileCoord();
	}
	
	public void moveUp()
	{
		robot.setDirection(Direction.UP);
		robot.setYCoord(robot.getYCoord() - 1);
		updateTileCoord();
	}
}
