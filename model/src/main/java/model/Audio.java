package model;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.scene.media.AudioClip;

/**
 * 
 * @author Team 10
 *
 * Audio manager allows to play some songs on the game
 *
 */
@SuppressWarnings("restriction")
public class Audio 
{
	/**
	 * 
	 * @param file Sound file path
	 */
	public Audio(String file)
	{
		URL url = null;
		
		try
		{
			File fileObj = new File(file);
			if (fileObj.canRead())
			{
				url = fileObj.toURI().toURL();
			}	
		}
		catch(MalformedURLException e)
		{
			throw new IllegalArgumentException("could not play '" + file + "'", e);
		}
		
		if (url == null)
		{
			throw new IllegalArgumentException("could not play '" + file + "'");
		}
		
		AudioClip aC = new AudioClip(url.toString());
		aC.setVolume(1);
		aC.play();	
	}
}
