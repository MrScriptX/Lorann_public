package controller;

import model.IModel;
import model.Direction;
import model.IEntity;

import java.util.List;


/**
 * Class to manage the entity hero
 * 
 * @author Team 10
 *@version 1.0
 */
public class EntityManager
{
	private IEntity hero;
	private MoveManager move_manager;
	private int x;
	private int y;

	public EntityManager(Clock clock)
	{
		this.move_manager = new MoveManager(clock);
	}


	/**
	 * Initialize the Move manager and get the entity hero
	 * 
	 * @param model move_manager depends on model
	 */
	public void init(IModel model)
	{
		this.hero = model.getHeros();
		this.move_manager.init(model);
	}


	/**
	 * Check collision and authorize wanted displacements
	 * 
	 * @param keys key map defining which key is pressed
	 */
	public void performMove(List<Boolean> keys)
	{
		this.x = hero.getPosition().getX();
		this.y = hero.getPosition().getY();

		defineWantedPosition(keys);

		if(move_manager.canMoveOn(this.x, this.y))
		{
			move_manager.move(hero, this.x, this.y);
			move_manager.checkEnnemy(hero);
		}
	}
	/**
	 * Define the wanted position and defining the Direction
	 * 
	 * @param keys key map defining which key is pressed
	 */
	private void defineWantedPosition(List<Boolean> keys)
	{
		if(keys.get(0))
		{
			y--;
			hero.setDirection(Direction.TOP);
		}

		if(keys.get(1))
		{
			y++;
			hero.setDirection(Direction.BOTTOM);
		}

		if(keys.get(2))
		{
			x++;
			hero.setDirection(Direction.RIGHT);
		}

		if(keys.get(3))
		{
			x--;
			hero.setDirection(Direction.LEFT);
		}
		if(keys.get(4))
		{
			hero.launchSpell();
		}
	}
}
