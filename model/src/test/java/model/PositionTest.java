package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Team 10
 * 
 * Test position class
 *
 */

public class PositionTest {

	Position position;
	
	@Before
	public void setUp() throws Exception
	{
		position = new Position(10, 10);
	}

	/**
	 * test if position on X is return
	 */
	@Test
	public void testGetX() 
	{
		assertEquals(10, position.getX());
	}

	/**
	 * test if position on X is set
	 */
	@Test
	public void testSetX()
	{
		position.setX(20);
		assertEquals(20, position.getX());
	}

	/**
	 * test if position on Y is return
	 */
	@Test
	public void testGetY()
	{
		assertEquals(10, position.getY());
	}

	/**
	 * test if position on Y is set
	 */
	@Test
	public void testSetY()
	{
		position.setY(20);
		assertEquals(20, position.getY());
	}

}
