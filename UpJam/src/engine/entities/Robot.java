package engine.entities;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import audioController.RobotAudio;
import map.Map;
import map.Tile;
import misc.Direction;
import engine.Handler;
import engine.ai.RobotIntelligence;

public class Robot extends Entities 
{
	private RobotIntelligence ai;
	private int sight = 5; //How many tiles the robot can see
	private int scanRate = 5; //How many many ticks a scan happens
	private int scanValue; //Counter until a scan happens
	private LinkedList<Entities> extras;
	private boolean trapped;
	private boolean tracking;
	private RobotAudio audio;
	/**
	 * Create a robot entity
	 * 
	 * @param xCoord The x coordinate of the top left pixel of the robot
	 * @param yCoord The x coordinate of the top right pixel of the robot 
	 * @param size The size of the robot entity
	 */
	public Robot(int xCoord, int yCoord, int size, Map map, Player player, Handler handler) 
	{
		super(xCoord, yCoord, size);
		this.velocity = 1;
		this.trapped = false;
		this.extras = handler.getExtras();
		this.scanValue = scanRate;
		audio = new RobotAudio(this, player, handler);
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
	
	public boolean isTracking()
	{
		return tracking;
	}
	
	public void setTracking(boolean tracking)
	{
		if(tracking && !this.tracking)
		{
			this.velocity = 2;
		}
		if(!tracking && this.tracking)
		{
			this.velocity = 1;
		}
		
		this.tracking = tracking;
	}
	
	private int count = 0;
	
	
	@Override
	public void tick() 
	{
		for (int i = 0; i < this.extras.size(); i++) 
		{
			Trap current = (Trap) this.extras.get(i);
			if((int)((current.getXCoord()+(Tile.TILESIZE/2))/Tile.TILESIZE) == (int)((this.getXCoord()+(Tile.TILESIZE/2))/Tile.TILESIZE)&& 
					(int)((current.getYCoord()+(Tile.TILESIZE/2))/Tile.TILESIZE) == (int)((this.getYCoord()+(Tile.TILESIZE/2))/Tile.TILESIZE))
			{
				this.trapped = true;
				scanValue = 0;
				this.extras.remove(i);
				break;
			}
		}
		
		if(!isTrapped())
		{
			for(int i=0; i<this.velocity; i++)
			{
				ai.nextMove();
			}
			
			if(scanValue-- == 0)
			{
				ai.scanPlayer();
				scanValue = scanRate;
			}
		}
		else
		{
			count++;
		}
		
		if(count > 300)
		{
			this.trapped = false;
			count = 0;
		}
		audio.tick();
	}

	@Override
	public void render(Graphics g) {
		if(isTrapped()){
			g.drawImage(new ImageIcon("resources/sprites/bobMagnetSprite.gif").getImage() , this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE,null);
		}
		else if(this.direction == Direction.UP)
		{
			if(isTracking())
			{
				g.drawImage(new ImageIcon("resources/sprites/bobBackSpriteRed.png").getImage() , this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE,null);
			}
			else
			{
				g.drawImage(new ImageIcon("resources/sprites/bobBackSprite.png").getImage() , this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE,null);
			}
		}
		else
		{
			if(isTracking())
			{
				g.drawImage(new ImageIcon("resources/sprites/bobFrontSpriteRed.png").getImage() , this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE,null);
			}
			else
			{
				g.drawImage(new ImageIcon("resources/sprites/bobFrontSprite.png").getImage() , this.getXCoord(), this.getYCoord(), Tile.TILESIZE, Tile.TILESIZE,null);
			}
		}
	}
	
	public RobotAudio getRobotAudio(){
		return audio;
	}
	
	public void mute()
	{
		audio.stop();
	}

}
