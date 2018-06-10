package model;

import java.util.ArrayList;
import java.util.List;
/**
 * Class of monster 3
 * @author Team 10
 *
 */
public class BehaviorThree extends Behavior
{
	private List<Direction> behave;
	
	public BehaviorThree()
	{
		this.behave = new ArrayList<Direction>();
		
		this.behave.add(Direction.RIGHT);
		this.behave.add(Direction.RIGHT);
		this.behave.add(Direction.TOP);
		this.behave.add(Direction.TOP);
		this.behave.add(Direction.LEFT);
		this.behave.add(Direction.LEFT);
		this.behave.add(Direction.BOTTOM);
		this.behave.add(Direction.BOTTOM);
	}
	
	@Override
	public List<Direction> getBehavior()
	{
		return this.behave;
	}
}
