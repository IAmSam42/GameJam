package engine.entities;

import java.awt.Color;
import java.awt.Graphics;

import engine.ai.RobotIntelligence;
import map.Map;
import map.Tile;

public class Robot extends Entities 
{
	private RobotIntelligence ai;
	private int sight; //How many tiles the robot can see
	
	/**
	 * Create a robot entity
	 * 
	 * @param xCoord The x coordinate of the top left pixel of the robot
	 * @param yCoord The x coordinate of the top right pixel of the robot 
	 * @param size The size of the robot entity
	 */
	public Robot(int xCoord, int yCoord, int size, Map map, Player player) 
	{
		super(xCoord, yCoord, size);
		this.sight = 3;
		ai = new RobotIntelligence(map, this, player);
	}
	
	public int getSight()
	{
		return sight;
	}
	
	public void setSight(int sight)
	{
		this.sight = sight;
	}
	
	@Override
	public void tick() 
	{
		for(int i=0; i<1; i++)
		{
			ai.nextMove();
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE);

	}

}
