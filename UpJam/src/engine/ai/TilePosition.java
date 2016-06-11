package engine.ai;

public class TilePosition 
{
	private int xCoord;
	private int yCoord;
	
	public TilePosition(int xCoord, int yCoord) 
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public int getX()
	{
		return xCoord;
	}
	
	public int getY()
	{
		return yCoord;
	}
}
