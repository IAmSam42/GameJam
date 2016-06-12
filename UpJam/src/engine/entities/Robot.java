package engine.entities;

import java.awt.Graphics;

import engine.ai.RobotIntelligence;
import map.Map;
import misc.Direction;

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
		ai = new RobotIntelligence(xCoord, yCoord, map);
		
	}

	public void nextPosition()
	{
		
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

	}

}
