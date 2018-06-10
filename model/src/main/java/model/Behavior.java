package model;

import java.util.List;
/**
 * Class to create a pattern to the monster
 * @author Team 10
 *
 */
abstract public class Behavior
{
	protected List<Direction> behave;
	
	abstract public List<Direction> getBehavior();
	
	/**
	 * Allow to convert a number in direction
	 * @param x
	 * @return
	 */
	protected Direction convert(int x)
	{
		switch(x)
		{
		case 0:
			return Direction.TOP;
		case 1:
			return Direction.BOTTOM;
		case 2:
			return Direction.LEFT;
		case 3:
			return Direction.RIGHT;
		case 4:
			return Direction.TOPRIGHT;
		case 5:
			return Direction.TOPLEFT;
		case 6:
			return Direction.BOTTOMRIGHT;
		case 7:
			return Direction.BOTTOMLEFT;
		case 8:
			return Direction.IDLE;
		default:
			return null;
		}
	}
}
