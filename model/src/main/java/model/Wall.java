package model;

/**
 * class containing wall's information
 * @author team 10
 *
 */
public class Wall extends Motionless
{
	
	final private boolean permeable = false;
	final private boolean is_activated = false;
	final private TypeMotionless type;
	private Position position;

	public Wall(TypeMotionless type, int x, int y, char sprite)
	{
		this.type = type;
		this.position =  new Position(x, y);
		this.sprite = sprite;
	}
	
	
	@Override 
	public char getSprite(){
		return this.sprite;
	}
	@Override
	public boolean isPermeable()
	{
		return this.permeable;
	}

	@Override
	public boolean isActivated()
	{
		return this.is_activated;
	}

	@Override
	public void perform()
	{
		// TODO nothing/switch animation?
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
	public boolean getIsOpen() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
