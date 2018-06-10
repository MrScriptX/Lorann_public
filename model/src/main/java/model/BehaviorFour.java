package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class for monster 4 
 * @author Team 10
 *
 */
public class BehaviorFour extends Behavior
{
	private List<Direction> behave;
	

	public BehaviorFour()
	{
		behave = new ArrayList<Direction>();
		Random rnd = new Random();
		int value = 0;
		
		for(int i = 0; i < 4; i++)
		{
			value = rnd.nextInt(9);
			this.behave.add(convert(value));
		}
		this.behave.add(Direction.BOTTOM);
		this.behave.add(Direction.LEFT);
		this.behave.add(Direction.TOP);
		this.behave.add(Direction.RIGHT);
	}
	
	@Override
	public List<Direction> getBehavior()
	{
		return this.behave;
	}

}
