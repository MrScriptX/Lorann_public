package model;

/**
 * Class grouping all elements of the map
 * @author Team 10
 *
 */
public abstract class Element implements IElement
{
	protected Position position;
	protected char sprite;
	
	public char getSprite() 
	{
		return sprite;
	}
	
	
}
