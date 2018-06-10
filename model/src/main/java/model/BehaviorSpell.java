package model;

import java.util.ArrayList;
import java.util.List;
/**
 * Class to give direction to the spell
 * @author Team 10
 *
 */
public class BehaviorSpell extends Behavior
{
	private List<Direction> behave;
	
	public BehaviorSpell()
	{
		this.behave = new ArrayList<Direction>();
		
		this.behave.add(Direction.RIGHT);
		this.behave.add(Direction.BOTTOM);
		this.behave.add(Direction.TOPLEFT);
		this.behave.add(Direction.TOPRIGHT);
		this.behave.add(Direction.LEFT);
		this.behave.add(Direction.TOP);
		this.behave.add(Direction.BOTTOMRIGHT);
		this.behave.add(Direction.BOTTOMLEFT);
	}
	
	/**
	 * @return List of type Direction
	 */
	@Override
	public List<Direction> getBehavior()
	{
		return this.behave;
	}
}
