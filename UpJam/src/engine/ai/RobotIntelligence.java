package engine.ai;

import java.util.Random;

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
	
	public RobotIntelligence(Map map, Robot robot) 
	{
		this.map = map;
		this.robot = robot;
		
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
				break;
			}
		}
		
		this.tileGoal.setX(xCoord);
		this.tileGoal.setY(yCoord);

		System.out.println("Goal is: " + tileGoal);
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
	
	public void nextMove()
	{
		if(tilePos.equals(path.getNextTile()))
		{
			if((robot.getXCoord() % Tile.TILESIZE) != 0)
			{
				System.out.println("Centering Right!");
				moveRight();
				return;
			}
			else if((robot.getYCoord() % Tile.TILESIZE) != 0)
			{
				System.out.println("Centering Up!");
				moveUp();
				return;
			}
			else if(path.length() == 0)
			{
				System.out.println("Reached Goal!");
				newRandomGoal();
				return;
			}
			else
			{
				path.popNextTile();
				updateTileCoord();
			}
		}
		
		if(tilePos.getX() < path.getNextTile().getX())
		{
			System.out.println("Moving Left!");
			moveLeft();
		}
		else if(tilePos.getX() < path.getNextTile().getX())
		{
			System.out.println("Moving Right!");
			moveRight();
		}
		else if(tilePos.getY() < path.getNextTile().getY())
		{
			System.out.println("Moving Down!");
			moveDown();
		}
		else if(tilePos.getY() > path.getNextTile().getY())
		{
			System.out.println("Moving Up!");
			moveUp();
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
