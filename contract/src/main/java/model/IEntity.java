package model;

public interface IEntity extends IElement
{
	public boolean isAlive();
	public void setAlive(boolean alive);
	
	public boolean isHero();
	
	public boolean isAlly();
	public Direction getDirection();
	public void setDirection(Direction direction);
	public void perform(int tick_rate);
	public void localClock(int tick_rate);
	public void setPosition(int x, int y);
	public char getSprite();
	public void launchSpell();
	public IPosition getPosition();
	
	public void checkCollision();
	public void setMana(boolean mana);
}
