package engine.ai;

import map.Map;

public class SearchAlgorithm 
{
	private Map map;
	private TilePosition start;
	private TilePosition goal;
	
	private PriorityQueue positionQueue;
			
	public SearchAlgorithm(Map map, TilePosition start, TilePosition goal) 
	{
		this.map = map;
		this.start = start;
		this.goal = goal;
		
		positionQueue = new PriorityQueue();
	}

	public void setStart(TilePosition start)
	{
		this.start = start;
		positionQueue.clear();
		makeFirstElem();
	}
	
	public void setGoal(TilePosition goal)
	{
		this.goal = goal;
		positionQueue.clear();
		makeFirstElem();
	}
	
	private void makeFirstElem()
	{
		TilePath startPath = new TilePath(start);
		double weight = getHValue(start, startPath);
		
		positionQueue.put(start, startPath, weight);
	}
	
	private double getHValue(TilePosition pos, TilePath path)
	{
		int distSqr = ((goal.getX() - pos.getX())*(goal.getX() - pos.getX())) + ((goal.getY() - pos.getY())*(goal.getY() - pos.getY()));
		double dist = Math.sqrt((double)distSqr); 
		
		double pathLength = (double)path.length();
		
		return dist + pathLength;
	}
	
	public void search()
	{
		
	}
}
