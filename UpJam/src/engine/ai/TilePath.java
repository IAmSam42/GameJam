package engine.ai;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class TilePath 
{
	private ArrayList<TilePosition> path;
	
	public TilePath()
	{
		path = new ArrayList<TilePosition>();
	}
	
	public TilePath(TilePosition firstPos)
	{
		path = new ArrayList<TilePosition>();
		path.add(firstPos);
	}
	
	public void add(TilePosition newPos)
	{
		path.add(newPos);
	}
	
	public int length()
	{
		return path.size();
	}
	
	public Deque<TilePosition> getStack()
	{
		return new ArrayDeque<TilePosition>(path);
	}
}
