package controller;

import model.IModel;
import model.IEntity;
/**
 * class to manage move
 * @author Team 10
 *
 */
public class MoveManager
{
	private CollisionManager collision_manager;
	
	public MoveManager(Clock clock)
	{
		this.collision_manager = new CollisionManager(clock);
	}
	
	public MoveManager getInstance()
	{
		return this;
	}
	
	
	/**
	 * Initialize the model
	 * 
	 * @param model collision_manager need model to be used
	 */
	public void init(IModel model)
	{
		this.collision_manager.init(model);
	}
	
	
	/**
	 * Verify if the entity is an enemy
	 * 
	 * @param entity check perform on this entity
	 */
	public void checkEnnemy(IEntity entity)
	{
		if(collision_manager.hasCollide(entity))
		{
			entity.setAlive(false);
		}
	}
	/**
	 * Verify if the entity can move on the wanted position
	 * 
	 * @param x position on x
	 * @param y position on y
	 * @return boolean 
	 */
	
	
	public boolean canMoveOn(int x, int y)
	{
		int wanted_x = x;
		int wanted_y = y;
		
		
		if(collision_manager.hasCollide(wanted_x, wanted_y))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	/**
	 * Moves the entity
	 * 
	 * @param entity entity to perform on
	 * @param x position on x
	 * @param y position on y
	 */
	public void move(IEntity entity, int x, int y)
	{
		entity.setPosition(x, y);
	}
}
