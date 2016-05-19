package lessons.sort.pancake.universe.operations;

import lessons.sort.pancake.universe.PancakeEntity;



public class FlipOperation extends PancakeOperation {
	
	private int number;
	private int oldNumber;
	
	public FlipOperation(PancakeEntity entity, int nb, int old)
	{
		super("flipOperation", entity);
		this.number = nb;
		this.oldNumber = old;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public int getOldNumber()
	{
		return oldNumber;
	}

}
