package model;

public interface IMotionless extends IElement
{
	public boolean isPermeable();
	public void setActive(boolean active);
	public char getSprite();
	public boolean getIsOpen();
}
