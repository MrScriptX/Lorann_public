package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.IClock;
import model.dao.DAO;

/**
 * Class containing list of elements that are on the map and load and update method
 * 
 * @author team 10
 *@version 1.0
 *
 */
public class ModelFacade implements IModel
{
	private long startTime;
	private long endTime;
	private long secondTime;
	private long millisTime;
	private String totalTime;
	
	public String getTotalTime() {
		return totalTime;
	}
	private int score;
	private int heros_index;
	private Level level;
	private List<IMotionless> motionless;
	private List<IEntity> entities;

	
	public ModelFacade()
	{
		this.score = 0;
		this.heros_index = -1;
		this.motionless = new ArrayList<IMotionless>();
		this.entities = new ArrayList<IEntity>();
	}
	
	public Level getLevel()
	{
		return this.level;
	}
	
	public int getScore() 
	{
		return this.score;
	}

	public void addScore(int score) 
	{
		this.score = this.score + score;
	}
 

	/**
	 * get the level for database, create object and add in a list each object depending on the sprite
	 * 
	 * @param id level number to load
	 * 
	 */
	@Override
	public void loadLevel(int id) 
	{
		try
		{
			level = DAO.sqlGetLevel(id);
		}
		catch(SQLException exception)
		{
			System.out.println(exception.getMessage());
		}

		String[] raw_data = level.getData().split("");
		char[] data = new char[240];

		for(int i = 0; i < data.length; i++)
		{
			data[i] = raw_data[i].charAt(0);
		}

		for(int y = 0; y < 12; y++)
		{
			for(int x = 0; x < 20; x++)
			{
				Position position = new Position(x, y);
				int index = x + y * 20;
				if(data[index] == 'o')
				{
					Wall element = new Wall(TypeMotionless.CROSS, x, y,'o');
					this.motionless.add(element);
				}
				else if(data[index] == 'm')
				{
					Wall element = new Wall(TypeMotionless.HORIZONTAL, x, y,'m');
					this.motionless.add(element);
				}
				else if(data[index] == 'l')
				{
					Wall element = new Wall(TypeMotionless.VERTICAL, x, y,'l');
					this.motionless.add(element);
				}
				else if(data[index] == 'p')
				{
					Door element = this.level.getExit();
					element.setPosition(position);
					this.motionless.add(element);
				}
				else if(data[index] == 'b')
				{
					Bonus element = new Bonus(TypeMotionless.PURSE, this.level, x, y,'b',this);
					this.motionless.add(element);
				}
				else if(data[index] == 'v')
				{
					Bonus element = new Bonus(TypeMotionless.ORB, this.level, x, y,'v',this);
					this.motionless.add(element);
				}
				else if(data[index] == 'H')
				{
					Hero entity = new Hero(position,this);
					entity.setPosition(position);
					this.heros_index = this.entities.size();
					this.entities.add(entity);
				}
				else if(data[index] == '1')
				{
					Behavior behavior = new BehaviorOne();
					Monster entity = new Monster(behavior, x, y, this,'1');
					this.entities.add(entity);
				}
				else if(data[index] == '2')
				{
					Behavior behavior = new BehaviorTwo();
					Monster entity = new Monster(behavior, x, y, this,'2');
					this.entities.add(entity);
				}
				else if(data[index] == '3')
				{
					Behavior behavior = new BehaviorThree();
					Monster entity = new Monster(behavior, x, y, this,'3');
					this.entities.add(entity);
				}
				else if(data[index] == '4')
				{
					Behavior behavior = new BehaviorFour();
					Monster entity = new Monster(behavior, x, y, this,'4');
					this.entities.add(entity);
				}
			}
		}
		this.startTime = System.nanoTime();
	}

	public void addSpell(Spell spell)
	{
		this.entities.add(spell);
	}

	@Override
	public List<IEntity> getEntities()
	{
		return this.entities;
	}

	@Override
	public List<IMotionless> getMotionless()
	{
		return this.motionless;
	}

	/**
	 * Update all elements on the map, look if bonus are activated and if there are collision with the hero or the spell. 
	 * Then it removes what needed to be removed .
	 * 
	 * @param clock use to set rebuild level boolean
	 */
	@Override
	public void update(IClock clock)
	{
		this.time();
		for(int i = 0; i < motionless.size(); i++)
		{
			Motionless element = (Motionless) motionless.get(i);

			if(element.isActivated())
			{
				element.perform();
				motionless.remove(i);
			}
		}

		for(int i = 0; i < entities.size(); i++)
		{
			IEntity entity = entities.get(i);
			entity.checkCollision();

			if(entity.isHero())
			{
				this.heros_index = i;
			}
			
			if(!entity.isAlive())
			{
				if(entity.isHero())
				{
					new Audio("dead.mp3");
					clock.setNeedRebuild(true);
					this.motionless.clear();
					this.entities.clear();
					this.score = 0;
					return;
				}
				else
				{
					entities.remove(i);
				}
			}
		}
	}

	/**
	 * Returns the Entity hero in the list of entity
	 * 
	 * @return IEntity
	 */
	@Override
	public IEntity getHeros()
	{
		return this.entities.get(this.heros_index);
	}

	
	
	public void  time() {
		this.endTime   = System.nanoTime();
		this.secondTime = (this.endTime - this.startTime)/1000000000;
		if (this.secondTime>0)
		{
		this.millisTime = (this.endTime % (this.secondTime * 1000000000)/10000000);
		}else
		{
			this.millisTime = ((this.endTime - this.startTime) /10000000);
		}
		this.totalTime = this.secondTime  + "." + this.millisTime;
	}
	/**
	 * play victory sound when level ended
	 */
	public void celebration()
	{
		new Audio("end.mp3");	
		System.out.println(this.totalTime);

	}
}
	
