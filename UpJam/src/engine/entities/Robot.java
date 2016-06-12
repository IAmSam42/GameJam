package engine.entities;

import java.awt.Color;
import java.awt.Graphics;

import engine.ai.RobotIntelligence;
import map.Map;
import map.Tile;

public class Robot extends Entities 
{
	private RobotIntelligence ai;
	
	/**
	 * Create a robot entity
	 * 
	 * @param xCoord The x coordinate of the top left pixel of the robot
	 * @param yCoord The x coordinate of the top right pixel of the robot 
	 * @param size The size of the robot entity
	 */
	public Robot(int xCoord, int yCoord, int size, Map map) 
	{
		super(xCoord, yCoord, size);
		ai = new RobotIntelligence(map, this);		
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
