package controller;

import model.IModel;
import model.IEntity;
import model.IMotionless;
/**
 * Class checking for collisions between hero and others elements
 * 
 * @author Team 10
 *@version 1.0
 */
public class CollisionManager
{
	private IModel model;
	private Clock clock;
	
		public CollisionManager(Clock clock)
	{
		this.clock = clock;
	}
	
	public CollisionManager getInstance()
	{
		return this;
	}
	
	
	/**
	 * Set the model for dependency purposes
	 * 
	 * @param model class containing all elements for collision checking
	 */
	public void init(IModel model)
	{
		this.model = model;
	}
	
	
	/**
	 * Check a collision with an entity
	 * 
	 * @param entity entity to check collision on
	 * @return boolean if a collision was detected or not
	 */
	public boolean hasCollide(IEntity entity)
	{
		for(int i = 0; i < this.model.getEntities().size(); i++)
		{
			if(!this.model.getEntities().get(i).isHero())
			{
				IEntity ennemy = this.model.getEntities().get(i);

				if(ennemy.getPosition().getX() == entity.getPosition().getX() && ennemy.getPosition().getY() == entity.getPosition().getY())
				{
					if(ennemy.isAlly())
					{
						return false;
					}
					else
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	
	/**
	 * Allows to check a collision with coordinates
	 * 
	 * @param x wanted position x
	 * @param y wanted position y
	 * @return boolean if a collision was detected or not
	 */
	public boolean hasCollide(int x, int y)
	{
		for(int i = 0; i < this.model.getMotionless().size(); i++)
		{
			IMotionless element = this.model.getMotionless().get(i);
			
			if(element.getPosition().getX() == x && element.getPosition().getY() == y)
			{
				if(element.isPermeable())
				{
					if(element.getIsOpen())
					{
						this.model.celebration();
						clock.setNextLevel(true);
						clock.setNeedRebuild(true);
						this.model.getMotionless().clear();
						this.model.getEntities().clear();
						return false;
					}
					
					element.setActive(true);
					return false;
				}
				else
				{
					return true;
				}
			}
		}
		
		return false;
	}
}
