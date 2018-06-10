package model;

/**
 * class containing spell's information, movement and collision check method
 * 
 * @author team 10
 *@version 1.0
 *
 */
public class Spell implements IEntity
{
	private boolean alive = false;
	final private boolean is_hero = false;
	private int step;
	private ModelFacade model;
	private char sprite = 's';
	private Direction direction;
	private Position position;
	
	private Behavior behavior = new BehaviorSpell();
	
	public Spell(Position position, Direction direction,ModelFacade model) 
	{
		this.alive = true;
		this.direction = direction;
		setPosition(position);
		this.model = model;
		this.step = DirectionToInt(this.direction);
		if (willCollide(this.position))
		{
			this.setAlive(false);
			this.model.getHeros().setMana(true);
		}
		}
	
	
	public int DirectionToInt(Direction direction) 
	{
		switch (direction) 
		{
		case RIGHT :  
			return 0;
		case BOTTOM :
			return 1;
		case TOPLEFT :
			return 2;
		case TOPRIGHT :
			return 3;
		case LEFT :
			return 4;
		case TOP :
			return 5;
		case BOTTOMRIGHT :
			return 6;
		case BOTTOMLEFT :
			return 7;
		default:
			return 0;
		}
	}
	
	
	@Override
	public char getSprite()
	{
		return this.sprite;
	}
	
	@Override
	public boolean isAlive()
	{
		return this.alive;
	}

	@Override
	public boolean isHero()
	{
		return this.is_hero;
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

	public void setPosition(Position position)
	{
		this.position = position;
	}
	

	@Override
	public Position getPosition()
	{
		return this.position;
	}

	/**
	 * spell's animation method changing sprite depending on actual sprite
	 */
	@Override
	public void localClock(int tick_rate)
	{
		this.perform(tick_rate);
		
		if(this.sprite == 's')
		{
			this.sprite = 'u';
		}
		else if(this.sprite == 'u')
		{
			this.sprite = 'i';
		}
		else if(this.sprite == 'i')
		{
			this.sprite = 'e';
		}
		else if(this.sprite == 'e')
		{
			this.sprite = 'c';
		}
		else if(this.sprite == 'c')
		{
			this.sprite = 's';
		}
	}

	@Override
	public void launchSpell() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(int x, int y) {
		this.position.setX(x);
		this.position.setY(y);
	}
	
	/**
	 * move the spell, calling check collision method
	 */
	@Override
	public void perform (int tick_rate)
	{
			boolean canMove = false;
			Position wanted_pos;
			
			do
			{
				this.direction = behavior.getBehavior().get(this.step);
				wanted_pos = getNextPos(this.direction);
				canMove = !willCollide(wanted_pos);
				
				if (!canMove)
				{
					step += 4;
				}
				
				if(this.step > 7)
				{
					this.step -= 8 ;
				}
						
			} while(!canMove);
			
			this.position = wanted_pos;	
	}
	
	/**
	 * check collision and interact with it if collision happened
	 * @param position
	 * @return
	 */
	private boolean willCollide(Position position)
	{
		int hero_index = -1;
		boolean findHero = false;
		
		for(int i = 0; i < this.model.getEntities().size(); i++)
		{
			IEntity entity = this.model.getEntities().get(i);
			
			if(entity.getPosition().getX() == position.getX() && entity.getPosition().getY() == position.getY())
			{
				if(entity == this)
				{
					//do nothing
				}
				else if(entity.isAlly())
				{
					this.setAlive(false);
					((Hero) entity).setMana(true);
					break;
				}
				else
				{
					entity.setAlive(false);
					this.setAlive(false);
					findHero = true;
				}
			}
			
			if(entity.isHero())
			{
				hero_index = i;
			}
			
			if(findHero == true)
			{
				if(hero_index != -1)
				{
					((Hero) this.model.getEntities().get(hero_index)).setMana(true);
				}
			}
		}
		
		for(int i = 0; i < this.model.getMotionless().size(); i++)
		{
			Motionless element = (Motionless) this.model.getMotionless().get(i);
			
			if(element.getPosition().getX() == position.getX() && element.getPosition().getY() == position.getY())
			{
				if(element.isPermeable())
				{
					return false;
				}
				else
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	private Position getNextPos(Direction direction)
	{
		int wanted_x = 0;
        int wanted_y = 0;
        
        if(direction == Direction.TOP)
        {
            wanted_y = this.position.getY() - 1;
            wanted_x = this.position.getX();
        }
        else if(direction == Direction.BOTTOM)
        {
            wanted_y = this.position.getY() + 1;
            wanted_x = this.position.getX();
        }
        else if(direction == Direction.LEFT)
        {
            wanted_y = this.position.getY();
            wanted_x = this.position.getX() - 1;
        }
        else if(direction == Direction.RIGHT)
        {
            wanted_y = this.position.getY();
            wanted_x = this.position.getX() + 1;
        }
        else if(direction == Direction.TOPRIGHT)
        {
            wanted_y = this.position.getY() - 1;
            wanted_x = this.position.getX() + 1;
        }
        else if(direction == Direction.TOPLEFT)
        {
            wanted_y = this.position.getY() - 1;
            wanted_x = this.position.getX() - 1;
        }
        else if(direction == Direction.BOTTOMRIGHT)
        {
            wanted_y = this.position.getY() + 1;
            wanted_x = this.position.getX() + 1;
        }
        else if(direction == Direction.BOTTOMLEFT)
        {
            wanted_y = this.position.getY() + 1;
            wanted_x = this.position.getX() - 1;
        }
        
        Position wanted_pos = new Position(wanted_x, wanted_y);
        
        return wanted_pos;
	}


	/**
	 * set the spell to the opposite way
	 * @param hero use to get where the hero is
	 */
	public void getBack(Hero hero) 
	{
		this.step = (this.step + 4) % 8;
	}
	
	/**
	 * @deprecated dependency method
	 */
	@Override
	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}


	@Override
	public void checkCollision()
	{
		willCollide(this.position);
	}


	@Override
	public void setMana(boolean mana) {
		// TODO Auto-generated method stub
		
	}
	
}
