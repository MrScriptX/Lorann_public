package model;

/**
 * Class to manage the door
 * @author Team 10 
 *
 */
public class Door extends Motionless
{

	private boolean permeable = false;
	private boolean is_open = false;
	private boolean is_activated = false;
	final private char sprite = 'p';
	final private TypeMotionless type = TypeMotionless.DOOR;
	
	public void setPosition(Position position)
	{
		this.position = position;
	}
	
	@Override
	public char getSprite()
	{
		return this.sprite;
	}
	
	public boolean getIsOpen()
	{
		return is_open;
	}
	
	public void setOpen(boolean open) 
	{
		this.is_open = open;
		this.permeable = open;
	}
	
	/**
	 * check if we can cross the element
	 */
	@Override
	public boolean isPermeable()
	{
		return this.permeable;
	}
	/**
	 * How to check if a bonus has been activated
	 */
	@Override
	public boolean isActivated()
	{
		return this.is_activated;
	}
	/**
	 * Allows to perform the door action
	 */
	@Override
	public void perform()
	{
		
	}

	@Override
	public TypeMotionless getType()
	{
		return this.type;
	}

	@Override
	public Position getPosition()
	{
		return this.position;
	}

}
