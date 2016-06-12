package engine.ai;

import java.util.HashSet;
import java.util.Set;

import javax.swing.plaf.SliderUI;

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
		if((!map.getTile(pos.getX(), pos.getY()).isSolid()) && !expanded.contains(pos))
		{
			TilePath newPath = new TilePath(pathTo);
			
			newPath.put(pos);
			double weight = getHValue(pos, newPath);
			
			System.out.println("path added: " + newPath);
		
			positionQueue.put(newPath, weight);
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
			
			System.out.println("Frontier path: " + frontierPath);
			System.out.println("Frontier: " + frontier);
			
			if(frontier.equals(goal))
			{
				expanded.clear();
				return frontierPath;
			}
			
			expand(frontier, frontierPath);
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
		TilePosition t1 = new TilePosition(3, 4);
		TilePosition t4 = new TilePosition(3, 6);
		
		SearchAlgorithm testSearch = new SearchAlgorithm(t1, t4, new Map());
		
		System.out.println(testSearch.search());
	}
}
