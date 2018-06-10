package model;

import java.io.File;

import javafx.scene.media.AudioClip;

/**
 * class to play music in background
 * 
 * @author team 10
 *@version 1.0
 *
 */
@SuppressWarnings("restriction")
public class Music
{
	public Music()
	{
		AudioClip aC = new AudioClip(new File("music.mp3").toURI().toString());
		aC.setVolume(0.4);
		aC.play();
	}
}
