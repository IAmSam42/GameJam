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
	
	public void setX(int xCoord)
	{
		this.xCoord = xCoord;
	}
	
	public int getY()
	{
		return yCoord;
	}
	
	public void setY(int yCoord)
	{
		this.yCoord = yCoord;
	}
	
	public boolean equals(TilePosition tile)
	{
		return (this.xCoord == tile.xCoord) && (this.yCoord == tile.yCoord);
	}
	
	public String toString()
	{
		return("(" + xCoord + ", " + yCoord + ")");
	}
}
