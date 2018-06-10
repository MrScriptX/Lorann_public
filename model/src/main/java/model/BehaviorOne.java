package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class of monster 1
 * @author Team 10
 *
 */
public class BehaviorOne extends Behavior
{
	private List<Direction> behave;
	
	public BehaviorOne()
	{
		this.behave = new ArrayList<Direction>();
		
		this.behave.add(Direction.TOPRIGHT);
		this.behave.add(Direction.BOTTOMLEFT);
		this.behave.add(Direction.TOPLEFT);
		this.behave.add(Direction.BOTTOMRIGHT);
		this.behave.add(Direction.BOTTOMLEFT);
		this.behave.add(Direction.TOPRIGHT);
		this.behave.add(Direction.BOTTOMRIGHT);
		this.behave.add(Direction.TOPLEFT);
	}

	
	@Override
	public List<Direction> getBehavior()
	{
		return this.behave;
	}
}
