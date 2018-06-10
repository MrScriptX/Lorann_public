package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author team 10
 *
 * Behavior class test and its child class
 *
 */

public class BehaviorTest {

	BehaviorOne behavior;
	
	@Before
	public void setUp() throws Exception
	{
		behavior = new BehaviorOne();
	}

	
	/**
	 * 
	 * test each case plus a failing one
	 * 
	 */
	@Test
	public void test() 
	{
		assertEquals(Direction.TOP, behavior.convert(0));
		assertEquals(Direction.BOTTOM, behavior.convert(1));
		assertEquals(Direction.LEFT, behavior.convert(2));
		assertEquals(Direction.RIGHT, behavior.convert(3));
		assertEquals(Direction.TOPRIGHT, behavior.convert(4));
		assertEquals(Direction.TOPLEFT, behavior.convert(5));
		assertEquals(Direction.BOTTOMRIGHT, behavior.convert(6));
		assertEquals(Direction.BOTTOMLEFT, behavior.convert(7));
		assertEquals(Direction.IDLE, behavior.convert(8));
		assertEquals(null, behavior.convert(9));
	}

}
