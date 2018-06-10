package model;

/**
 * abstract class containing Motionless elements' information
 * @author team 10
 *
 */
abstract public class Motionless extends Element implements IMotionless
{
	
	protected boolean permeable;
	protected boolean is_activated;
	protected TypeMotionless type;
	protected Position position;
	
	abstract public boolean isPermeable();
	abstract public boolean isActivated();
	
	abstract public TypeMotionless getType();
	abstract public Position getPosition();
	
	public void setActive(boolean is_activated)
	{
		this.is_activated = is_activated;
	}
	
	abstract public void perform();
}
