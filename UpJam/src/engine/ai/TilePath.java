package engine.ai;

import java.util.ArrayDeque;
import java.util.Deque;

public class TilePath 
{
	private Deque<TilePosition> path;
	
	public TilePath()
	{
		path = new ArrayDeque<TilePosition>();
	}
	
	public TilePath(TilePath path)
	{
		this.path = new ArrayDeque<TilePosition>(path.getStack());
	}
	
	public TilePath(TilePosition firstPos)
	{
		path = new ArrayDeque<TilePosition>();
		path.addFirst(firstPos);
	}
	
	public void put(TilePosition newPos)
	{
		path.addFirst(newPos);
	}
	
	public TilePosition getDestination()
	{
		return path.getFirst();
	}
	
	public int length()
	{
		return path.size() - 1;
	}
	
	public Deque<TilePosition> getStack()
	{
		return path;
	}
	
	public String toString()
	{
		String string = "";
		for(TilePosition pos : path)
		{
			string += pos.toString() + " ";
		}
		
		return string;
	}
}
