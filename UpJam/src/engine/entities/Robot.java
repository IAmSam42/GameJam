package engine.entities;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import map.Map;
import map.Tile;
import misc.Direction;
import engine.ai.RobotIntelligence;

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
		if(this.direction == Direction.UP){
			g.drawImage(new ImageIcon("resources/sprites/bobBackSprite.png").getImage() , this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE,null);
		}else{
			g.drawImage(new ImageIcon("resources/sprites/bobFrontSprite.png").getImage() , this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE,null);
		}
	}

}
