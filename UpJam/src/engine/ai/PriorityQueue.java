package engine.ai;

import java.util.ArrayList;

public class PriorityQueue {
	
	private ArrayList<QueueElement> elements;
	
	public PriorityQueue() 
	{
		elements = new ArrayList<QueueElement>();
	}
	
	public boolean put(TilePath path, double weight)
	{
		for(QueueElement elem : elements)
		{
			if(elem.getValue().equals(path.getDestination()))
			{
				if(elem.getWeight() > weight)
				{
					elem.setWeight(weight);
					elem.setPath(path);
				}
				return false;
			}
		}
		
		QueueElement newElem = new QueueElement(path.getDestination(), path, weight);
		
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
		
		return true;
	}
	
	public TilePath pop()
	{
		TilePath retVal = elements.get(0).getPath();
		elements.remove(0);
		
		return retVal;
	}
	
	public TilePath peak()
	{
		return elements.get(0).getPath();
	}

	public void clear()
	{
		elements.clear();
	}
}
