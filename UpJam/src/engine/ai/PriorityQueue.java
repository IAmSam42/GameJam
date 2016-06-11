package engine.ai;

import java.util.ArrayList;

public class PriorityQueue {
	
	private ArrayList<QueueElement> elements;
	
	public PriorityQueue() 
	{
		elements = new ArrayList<QueueElement>();
	}
	
	public void put(TilePosition tilePos, int weight)
	{
		for(QueueElement elem : elements)
		{
			if(elem.getValue().equals(tilePos))
			{
				if(elem.getWeight() > weight)
				{
					elem.setWeight(weight);
				}
				return;
			}
		}
		
		QueueElement newElem = new QueueElement(tilePos, weight);
		
		elements.add(newElem);
		
		for(int i = elements.size() - 1; i>0; i--)
		{
			if(elements.get(i).getWeight() < elements.get(i-1).getWeight())
			{
				QueueElement temp = elements.get(i);
				elements.set(i, elements.get(i-1));
				elements.set(i-1, temp);
			}
		}
	}
	
	public TilePosition pop()
	{
		TilePosition retVal = elements.get(0).getValue();
		elements.remove(0);
		
		return retVal;
	}
	
	public TilePosition peak()
	{
		return elements.get(0).getValue();
	}

	public void clear()
	{
		elements.clear();
	}
}
