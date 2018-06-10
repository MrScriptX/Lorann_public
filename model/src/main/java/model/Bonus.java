package model;
/**
 * Class of the different bonus present on the map
 * @author Team 10
 *
 */
public class Bonus extends Motionless
{

	private TypeMotionless type;
	private Level level;
	private ModelFacade modelfacade;
	final protected boolean permeable = true;
	protected boolean is_activated = false;
	private Position position;
	
	public Bonus(TypeMotionless type, Level level, int x, int y, char sprite, ModelFacade modelfacade) 
	{
		this.type = type;
		this.level = level;
		this.position = new Position(x, y);
		this.sprite = sprite;
		this.modelfacade = modelfacade;
	}
	
	@Override
	public char getSprite()
	{
		return this.sprite;
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
	 * check if we can cross the element
	 */
	@Override
	public boolean isPermeable()
	{
		return this.permeable;
	}
	/**
	 * Allows to perform the bonus action
	 */
	@Override
	public void perform () 
	{
		switch(this.type)
		{
		case PURSE:
			{
				this.modelfacade.addScore(100);
				new Audio("purse.mp3");
			}
			break;
		case ORB:
				new Audio("open.mp3");
				this.level.getExit().setOpen(true);
			break;
		default:
				throw new RuntimeException("Unknown bonus type");
				
		}
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

	@Override
	public boolean getIsOpen() 
	{
		return false;
	}
	
	@Override
	public void setActive(boolean active)
	{
		this.is_activated = active;
	}
	
}
