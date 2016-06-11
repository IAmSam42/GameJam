package engine.ai;

public class QueueElement
{
	private TilePosition value;
	private int weight;
	
	public QueueElement(TilePosition value, int weight) 
	{
		this.value = value;
		this.weight = weight;
	}

	public TilePosition getValue()
	{
		return value;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	
	
	public boolean equals(QueueElement elem)
	{
		return this.value.equals(elem.getValue());
	}
}
