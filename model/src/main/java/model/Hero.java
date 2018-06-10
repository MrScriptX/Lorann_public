package model;

/**
 * Class containing hero's information and handle hero's animation and spell launching
 * 
 * @author team 10
 *@version 1.0
 */
public class Hero implements IEntity
{
	private boolean alive = true;
	private Direction cast_direction;
	private boolean mana = true;
	private boolean switch_sprite = true;
	private Spell spell;
	final private boolean is_hero = true;
	private ModelFacade model;
	
	private int char_count = 0;
	private char sprite = 'H';
	char[] animation = {'H', 'h', 'N', 'n', 'W', 'w', 'z', 'Z'};
	
	
	private Position position;
	private Direction direction = Direction.IDLE;
	
	private int localclock = 0;
	private int sum = 0;
	
	public Hero(Position position, ModelFacade model)
	{		
		setPosition(position);
		this.model = model;
	}
	
	
	public void setPosition(Position position)
	{
		this.position = position;
	}
	

	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	
	@Override
	public char getSprite()
	{
		return this.sprite;
	}
	
	public boolean isMana() 
	{
		return mana;
	}
	
	
	public void setMana(boolean mana) 
	{
		this.mana = mana;
	}
	
	/**
	 * launch the spell or interact with it when already launched depending on the boolean mana 
	 */
	@Override
	public void launchSpell()
	{
		Position spellPosition = new Position(this.position.getX(), this.position.getY());

		if (mana==true) 
		{
			this.mana = false;

			switch (this.direction) 
			{
			case LEFT :
			{
				this.cast_direction = Direction.RIGHT;
				spellPosition.setX(spellPosition.getX() + 1);
			}
			break;
			case RIGHT : 
			{
				this.cast_direction = Direction.LEFT;
				spellPosition.setX(spellPosition.getX() - 1);
			}
			break;
			case TOP :
			{
				this.cast_direction = Direction.BOTTOM;
				spellPosition.setY(spellPosition.getY() + 1);
			}	
			break;
			case BOTTOM : 
			{
				this.cast_direction = Direction.TOP;
				spellPosition.setY(spellPosition.getY() - 1);
			}
			break;
			case BOTTOMRIGHT : this.cast_direction = Direction.TOPLEFT;
			break;
			case BOTTOMLEFT : this.cast_direction = Direction.TOPRIGHT;
			break;
			case TOPRIGHT : this.cast_direction = Direction.BOTTOMLEFT;
			break;
			case TOPLEFT : this.cast_direction = Direction.BOTTOMRIGHT;
			break;
			case IDLE:
			{
				this.cast_direction = Direction.RIGHT;
				spellPosition.setX(spellPosition.getX() + 1);
			}
			break;
			default:
				throw new RuntimeException("Unknown direction!");
			}
			
			this.spell = new Spell(spellPosition, this.cast_direction, this.model);
			this.model.addSpell(spell);
			new Audio("soundTest.mp3");
		}
		else 
		{
			this.spell.getBack(this);
		}
		
	}
	

	@Override
	public boolean isHero()
	{
		return this.is_hero;
	}
	
	/**
	 * make hero's animation when not moving by changing the sprite each tick of the clock
	 * 
	 * @param tick_rate regulates speed
	 */
	@Override
	public void perform(int tick_rate)
	{
		char_count++;

		if(switch_sprite)
		{
			this.sprite = animation[char_count];

			if(char_count > 6)
			{
				char_count = 0;
			}
		}
	}
	

	@Override
	public boolean isAlive()
	{
		return this.alive;
	}
	

	@Override
	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}
	

	@Override
	public boolean isAlly() 
	{
		return true;
	}
	
	
	@Override
	public Direction getDirection()
	{
		return this.direction;
	}
	
	
	@Override
	public void setPosition(int x, int y) 
	{
		this.position.setX(x);
		this.position.setY(y);
	}

	
	@Override
	public Position getPosition()
	{
		return this.position;
	}

	
	@Override
	public void localClock(int tick_rate)
	{
		if (localclock < 100000000)
		{
			try
			{
				Thread.sleep(10);
			}
			catch(InterruptedException e) 
			{
				throw new RuntimeException("Thread sleep was interrupted");
			}
			localclock ++;
			
			if (sum%5 == 0)
			{
				this.perform(tick_rate);
			}
			
			
			sum++;
		}
	}

	/**
	 * @deprecated dependency method
	 */
	public void checkCollision()
	{
	}

}
