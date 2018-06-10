package model;

import java.util.ArrayList;
import java.util.List;
/**
 * Class of monster 2
 * @author Team 10
 *
 */
public class BehaviorTwo extends Behavior
{
	private List<Direction> behave;
	
	public BehaviorTwo()
	{
		this.behave = new ArrayList<Direction>();
		
		this.behave.add(Direction.RIGHT);
		this.behave.add(Direction.LEFT);
		this.behave.add(Direction.TOP);
		this.behave.add(Direction.BOTTOM);
		this.behave.add(Direction.LEFT);
		this.behave.add(Direction.RIGHT);
		this.behave.add(Direction.BOTTOM);
		this.behave.add(Direction.TOP);
	}
	
	@Override
	public List<Direction> getBehavior()
	{
		return this.behave;
	}
	
}
