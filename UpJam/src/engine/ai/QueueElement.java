package engine.ai;

public class QueueElement
{
	private TilePosition value;
	private TilePath path;
	private double weight;
	
	public QueueElement(TilePosition value, TilePath path, double weight) 
	{
		this.value = value;
		this.path = path;
		this.weight = weight;
	}

	public TilePosition getValue()
	{
		return value;
	}
	
	public TilePath getPath()
	{
		return path;
	}
	
	public void setPath(TilePath path)
	{
		this.path = path;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public void setWeight(double weight)
	{
		this.weight = weight;
	}
	
	
	public boolean equals(QueueElement elem)
	{
		return this.value.equals(elem.getValue());
	}
}
