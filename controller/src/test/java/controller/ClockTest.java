package controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import view.Order;

public class ClockTest {

	Clock clock;
	
	@Before
	public void setUp() throws Exception
	{
		clock = new Clock();
	}

	/**
	 * @author Team 10
	 * 
	 * test setters and getters for rebuilding level
	 */
	@Test
	public void testSetNeedRebuild()
	{
		clock.setNeedRebuild(false);
		assertEquals(false, clock.getNeedRebuild());
		
		clock.setNeedRebuild(true);
		assertEquals(true, clock.getNeedRebuild());
	}

	/**
	 * 
	 * @author Team 10
	 * 
	 * test if key mapping doesn't throw an error
	 * 
	 */
	@Test
	public void testOrderPerform() 
	{	
		try
		{
			clock.orderPerform(Order.KEY_UP, true);
			clock.orderPerform(Order.KEY_DOWN, true);
			clock.orderPerform(Order.KEY_LEFT, true);
			clock.orderPerform(Order.KEY_RIGHT, true);
			clock.orderPerform(Order.KEY_SPELL, true);
		}
		catch(java.lang.RuntimeException e)
		{
			fail("Order doesnt exist!");
		}
	}

	
	/**
	 * @author Team 10
	 * 
	 * test getters and setters for next level generation
	 * 
	 */
	@Test
	public void testSetNextLevel()
	{
		clock.setNextLevel(false);
		assertEquals(false, clock.getNextLevel());
		
		clock.setNextLevel(true);
		assertEquals(true, clock.getNextLevel());
	}
}
