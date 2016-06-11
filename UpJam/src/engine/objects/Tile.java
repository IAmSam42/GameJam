package engine.objects;

public abstract class Tile extends GameObject
{
	private boolean solid;
	public static final int TileSize = 32;
	
	public Tile(int xCoord, int yCoord) 
	{
		super(xCoord, yCoord, TileSize);
	}

	public boolean isSolid()
	{
		return solid;
	}
	
	public void setSolid(boolean solid)
	{
		this.solid = solid;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
}
