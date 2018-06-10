package model;

/**
 * class containing monster's information, movement and collision check method
 * @author team 10
 *
 */
public class Monster implements IEntity
{
	private Behavior behavior;
	private int step;
	private boolean alive = true;
	private ModelFacade model;
	private BehaviorRage rage;
	
	private Direction direction;
	private Position position;
	private boolean ally = false;
	
	final private boolean is_hero = false;
	private char sprite;
	
	public Monster(Behavior behavior, int x, int y, ModelFacade model, char sprite)
	{
		this.position = new Position(x, y);
		this.behavior = behavior;
		this.step = 0;
		this.model = model;
		this.sprite = sprite;
		this.ally = false;
		this.rage = new BehaviorRage(model, this, this.behavior);

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
	public void localClock(int tick_rate)
	{	
		this.perform(tick_rate);
	}
		
	/**
	 * move the monster, calling check collision method and on range to rush method to look if he needs to change behavior	
	 */
	@Override
	public void perform (int tick_rate)
	{
			boolean canMove = false;
			boolean isOnRush = false;
			Position wanted_pos;
			
			if(rage.abs(model.getHeros().getPosition().getX()-this.getPosition().getX()) +rage.abs(model.getHeros().getPosition().getY()-this.getPosition().getY()) <=3) 
			{
				this.direction = rage.rushHero();
				isOnRush = true;
			}
						
			do
			{
				if(!isOnRush)
				{
					this.direction = behavior.getBehavior().get(this.step);
				}
				
				wanted_pos = getNextPos(this.direction);
				canMove = !willCollide(wanted_pos);
				
				if(!canMove)
				{
					isOnRush = false;
				}
				
				if(this.step >= 7)
				{
					this.step = 0;
				}
				else
				{
					this.step++;
				}
			} while(!canMove);
			
			this.position = wanted_pos;	
	}
	
	/**
	 * Check collision and interact with it if collision happened
	 * 
	 * @param position Requested position
	 * @return boolean detected a collision
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
				if(entity.isHero())
				{
					entity.setAlive(false);
				}
				else if(entity.isAlly())
				{
					new Audio("mobDead.mp3");
					this.setAlive(false);
					entity.setAlive(false);
					findHero = true;
				}
			}
			
			if(entity.isHero())
			{
				hero_index = i;
			}
			else if(findHero == true)
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

	@Override
	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}

	@Override
	public boolean isAlly()
	{
		return this.ally;
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

	/**
	 * @deprecated dependency method
	 */
	public void setDirection(Direction direction)
	{
	}

	/**
	 * @deprecated dependency method
	 */
	@Override
	public void launchSpell()
	{
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
