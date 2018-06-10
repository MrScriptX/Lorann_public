package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AudioTest {

	Audio audio;
	
	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testAudio()
	{
		try
		{
			audio = new Audio("");
		}
		catch(IllegalArgumentException e)
		{
			return;
		}
		
		fail("didn't throw any error!");
	}

}
