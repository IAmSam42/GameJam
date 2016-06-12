package engine.entities;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import map.Map;
import map.Tile;
import misc.Direction;
import engine.ai.RobotIntelligence;

public class Robot extends Entities 
{
	private RobotIntelligence ai;
	private int sight; //How many tiles the robot can see
	private int scanRate = 200; //How many many ticks a scan happens
	private int scanValue; //Counter until a scan happens
	
	private boolean trapped;
	
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
		this.velocity = 1;
		this.trapped = false;
		
		this.scanValue = scanRate;
		
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
	
	public boolean isTrapped()
	{
		return trapped;
	}
	
	@Override
	public void tick() 
	{
		for(int i=0; i<this.velocity; i++)
		{
			//System.out.println("Move");
			
			ai.nextMove();
		}
		
		if(scanValue-- == 0)
		{
			//System.out.println("Scan");
			
			//ai.scanPlayer();
			scanValue = scanRate;
		}
	}

	@Override
	public void render(Graphics g) {
		if(this.direction == Direction.UP){
			g.drawImage(new ImageIcon("resources/sprites/bobBackSprite.png").getImage() , this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE,null);
		}else{
			g.drawImage(new ImageIcon("resources/sprites/bobFrontSprite.png").getImage() , this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE,null);
		}
	}

}
