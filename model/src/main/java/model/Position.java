package model;

/**
 * class to create position Type that regroup X and Y coordinate
 * @author team 10
 *
 */

public class Position implements IPosition
{
	private int x;
	private int y;
	
	public Position(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}
	
	
	public int getX() 
	{
		return x;
	}
	public void setX(int x) 
	{
		this.x = x;
	}
	
	
	public int getY() 
	{
		return y;
	}
	public void setY(int y) 
	{
		this.y = y;
	}

}
