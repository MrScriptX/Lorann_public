package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Team 10
 * 
 * Test ModelFacade logic and list of objects
 *
 */

public class ModelFacadeTest {

	ModelFacade model;
	
	@Before
	public void setUp() throws Exception 
	{
		model = new ModelFacade();
	}

	
	/**
	 * 
	 * test if list of Entity is return correctly and is functional
	 * 
	 */
	@Test
	public void testGetEntities()
	{
		Behavior behavior = new BehaviorFour();
		Monster entity = new Monster(behavior, 10, 5, model,'4');
		
		model.getEntities().add(entity);
		model.getEntities().add(entity);
		model.getEntities().add(entity);
		
		assertEquals(3, model.getEntities().size());
	}

	
	/**
	 * 
	 * test if list of Motionless is return correctly and is functional
	 * 
	 */
	@Test
	public void testGetMotionless()
	{
		Wall element = new Wall(TypeMotionless.CROSS, 1, 2,'o');
		
		model.getMotionless().add(element);
		model.getMotionless().add(element);
		model.getMotionless().add(element);
		
		assertEquals(3, model.getMotionless().size());
	}

	
	/**
	 * 
	 * test is list iteration throws an nullpointerexception
	 * 
	 */
	@Test
	public void testUpdate()
	{
		try
		{
			for(int i = 0; i < model.getEntities().size(); i++)
			{
				
			}
			
			for(int i = 0; i < model.getMotionless().size(); i++)
			{
				
			}
		}
		catch(NullPointerException e)
		{
			fail("overflow error on list!");
		}
	}

}
