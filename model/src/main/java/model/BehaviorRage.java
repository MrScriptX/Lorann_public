package model;

import java.util.List;

/**
 * 
 * Behavior : follow player
 * 
 * @author Team 10
 * @version 1.0
 *
 */

public class BehaviorRage extends Behavior
{
	private ModelFacade model;
	private Monster monster;

	public BehaviorRage(ModelFacade model, Monster monster, Behavior base_behavior)
	{
		this.model = model;
		this.monster = monster;
	}
	
	/**
	 * 
	 * Return the absolute value of a int
	 * 
	 * @param x value to return the abs
	 * @return int
	 */
	public int abs(int x) 
	{
		if (x < 0) 
		{
			return -x;
		}else 
		{
			return x;
		}
	}


	/**
	 * AI path finding to follow the player in a specific area
	 * 
	 * @return Direction or return null
	 */
	public Direction rushHero()
	{
		int directionX = abs(this.model.getHeros().getPosition().getX() - this.monster.getPosition().getX());
		int directionY = abs(this.model.getHeros().getPosition().getY() - this.monster.getPosition().getY());

		if(directionX <= 3 ) 
		{
			if (this.model.getHeros().getPosition().getX() > this.monster.getPosition().getX()) 
			{
				return Direction.RIGHT;
			}
			else if(this.model.getHeros().getPosition().getX() < this.monster.getPosition().getX())
			{
				return Direction.LEFT;
			}
		}

		if (directionY <= 3)  
		{
			if (model.getHeros().getPosition().getY() < monster.getPosition().getY())
			{
				return Direction.TOP;
			}
			else if(model.getHeros().getPosition().getY() > monster.getPosition().getY())
			{
				return Direction.BOTTOM;
			}

		}

		return null;
	}

	/**
	 * @deprecated not use, needed for the dependency of the class
	 * @return null pointer
	 */
	@Override
	public List<Direction> getBehavior()
	{
		return null;
	}
}
