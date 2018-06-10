package view;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import model.IModel;


/**
 * 
 * @author Team 10
 *
 * Test on display class
 *
 */
public class DisplayTest {

	IModel model;
	Display display;
	
	@Before
	public void setUp() throws Exception
	{
		display = new Display(model);
	}

	/**
	 * test to acquire image should throw an error since image are not accessible
	 */
	@Test
	public void testLoadImage()
	{	
		try
		{
			display.loadImage();
		}
		catch(IOException e)
		{
			return;
		}
		
		fail("failed to acquire image!");
	}

}
