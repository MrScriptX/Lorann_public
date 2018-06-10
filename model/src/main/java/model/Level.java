package model;

/**
 * Class containing level info
 * 
 * @author team 10
 *@version 1.0
 */
public class Level
{
	private boolean finished = false; 
	private String name;
	private String data;
	private Door exit;
	private int local_score;
	
	public Level(Door door)
	{
		this.exit = door;
	}
	
	public int getScore()
	{
		return this.local_score;
	}
	
	public void addScore(int new_points)
	{
		this.local_score += new_points;
	}
	
	public void resetScore()
	{
		this.local_score = 0;
	}
	
	public Door getExit()
	{
		return this.exit;
	}
	
	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public boolean isFinished()
	{
		return finished;
	}
	
	
	public void setFinished(boolean finished) 
	{
		this.finished = finished;
	}
}
