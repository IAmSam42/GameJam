package engine.ai;

import java.util.HashSet;
import java.util.Set;

import map.Map;

public class SearchAlgorithm 
{
	private TilePosition start;
	private TilePosition goal;
	private Map map;
	
	private PriorityQueue positionQueue;
	private Set<TilePosition> expanded;
			
	public SearchAlgorithm(TilePosition start, TilePosition goal, Map map) 
	{
		this.start = start;
		this.goal = goal;
		this.map = map;
		
		positionQueue = new PriorityQueue();
		expanded = new HashSet<TilePosition>();
		
		addPos(start, new TilePath());
	}

	public void setStart(TilePosition start)
	{
		this.start = start;
		positionQueue.clear();
		expanded.clear();
		addPos(start, new TilePath());
	}
	
	public void setGoal(TilePosition goal)
	{
		this.goal = goal;
		positionQueue.clear();
		expanded.clear();
		addPos(start, new TilePath());
	}
	
	private void addPos(TilePosition pos, TilePath pathTo)
	{
		if((!map.getTile(pos.getX(), pos.getY()).isSolid()) || expanded.contains(pos))
		{
			pathTo.put(pos);
			double weight = getHValue(pos, pathTo);
		
			positionQueue.put(pathTo, weight);
			expanded.add(pos);
		}
	}
	
	private double getHValue(TilePosition pos, TilePath path)
	{
		int distSqr = ((goal.getX() - pos.getX())*(goal.getX() - pos.getX())) + ((goal.getY() - pos.getY())*(goal.getY() - pos.getY()));
		double dist = Math.sqrt((double)distSqr); 
		
		double pathLength = (double)path.length();
		
		return dist + pathLength;
	}
	
	public TilePath search()
	{
		while(!positionQueue.isEmpty())
		{
			TilePath frontierPath = positionQueue.pop();
			TilePosition frontier = frontierPath.getDestination();
			
			if(frontier.equals(goal))
			{
				expanded.clear();
				return frontierPath;
			}
			
			expand(frontier, frontierPath);
			search();
		}
		
		expanded.clear();
		return new TilePath();
	}
	
	private void expand(TilePosition elem, TilePath pathTo)
	{
		if(elem.getX() > 0)
		{
			addPos(new TilePosition(elem.getX() - 1, elem.getY()), pathTo);
		}
		if(elem.getX() < map.getWidth() - 1)
		{
			addPos(new TilePosition(elem.getX() + 1, elem.getY()), pathTo);
		}
		if(elem.getY() > 0)
		{
			addPos(new TilePosition(elem.getX(), elem.getY() - 1), pathTo);
		}
		if(elem.getY() < map.getHeight() - 1)
		{
			addPos(new TilePosition(elem.getX(), elem.getY() + 1), pathTo);
		}
	}
	
	public static void main(String[] args)
	{
		TilePosition t1 = new TilePosition(4, 1);
		TilePosition t4 = new TilePosition(4, 2);
		
		SearchAlgorithm testSearch = new SearchAlgorithm(t1, t4, new Map());
		
		System.out.println(testSearch.search());
	}
}
