package engine.ai;

import java.util.PriorityQueue;

import map.Map;

public class SearchAlgorithm 
{
	private Map map;
	private TilePosition start;
	private TilePosition goal;
	
	private PriorityQueue<TilePath> positionQueue;
			
	public SearchAlgorithm(Map map, TilePosition start, TilePosition goal) 
	{
		this.map = map;
		this.start = start;
		this.goal = goal;
	}

	public void setStart(TilePosition start)
	{
		this.start = start;
	}
	
	public void setGoal(TilePosition goal)
	{
		this.goal = goal;
	}
	
	public void search()
	{
		
	}
}
