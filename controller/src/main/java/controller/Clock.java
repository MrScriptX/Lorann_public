package controller;

import model.IModel;
import view.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
/**
 * Class to manage the game clock
 * 
 * @author Team 10
 *@version 1.0
 */
@SuppressWarnings("deprecation")
public class Clock extends Observable implements IClock
{
	final int GAME_SPEED = 1;
	
	private long last_time = 0;
	private int level_nb;
	private int game_tick;
	private int tick_count;
	private boolean next_level = true;
	private boolean needUpdate = true;
	
	private boolean build_level;
	private boolean exit;
	private EntityManager entity_manager;
	private List<Boolean> keys;
	
	public Clock()
	{
		this.game_tick = 0;
		this.tick_count = 0;
		this.build_level = true;
		this.exit = false;
		this.entity_manager = new EntityManager(this);
		this.keys = new ArrayList<Boolean>();

		this.keys.add(false);
		this.keys.add(false);
		this.keys.add(false);
		this.keys.add(false);
		this.keys.add(false);
	}
	
	/**
	 * Launching the game clock
	 * 
	 * @param model manage AI and updates
	 */
	public void run(IModel model)
	{
		this.level_nb = 0;
		
		do
		{
			long time = System.nanoTime() * 1000000;
			int delta_time = (int) ((time - last_time) / 10000000);
			this.last_time = time;
			
			this.tick_count++;
			
			if(tick_count >= GAME_SPEED * delta_time)
			{
				game_tick++;
				
				//check if level is loaded
				if(this.build_level == true)
				{
					if(this.next_level)
					{
						this.next_level = false;
						level_nb++;
					}
					
					model.loadLevel(level_nb);
					this.entity_manager.init(model);
					build_level = false;
				}
 
				//update IA  
				if(game_tick % 12000 == 0)
				{
					for(int i = 0; i < model.getEntities().size(); i++)
					{
						model.getEntities().get(i).localClock(this.game_tick);
					}
					
					//update hero
					this.entity_manager.performMove(this.keys);
					
					try {
						Thread.sleep(60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					setChanged();
					needUpdate = true;
				}
				
				
				//update model
				model.update(this);
				
				//update view
				notifyObservers(needUpdate);
				needUpdate = false;
				
				//System.out.println(this.game_tick);
				
				if(this.game_tick > 30000000)
				{
					this.game_tick = 0;
				}
				
				this.tick_count = 0;
			}
			
		}while(!exit);
	}
	
	@Override
	public void setNeedRebuild(boolean rebuild)
	{
		this.build_level = rebuild;
	}
	
	public boolean getNeedRebuild()
	{
		return this.build_level;
	}
	
	/**
	 * associate the key with the action
	 * 
	 * @param key key detected
	 * @param action can be either press or released
	 */
	@Override
	public void orderPerform(Order key, boolean action)
	{
		if(key == Order.KEY_UP)
		{
			this.keys.set(0, action);
		}
		else if(key == Order.KEY_DOWN)
		{
			this.keys.set(1, action);
		}
		else if(key == Order.KEY_RIGHT)
		{
			this.keys.set(2, action);
		}
		else if(key == Order.KEY_LEFT)
		{
			this.keys.set(3, action);
		}
		else if(key == Order.KEY_SPELL)
		{
			this.keys.set(4, action);
		}
		else
		{
			throw new java.lang.RuntimeException("Order doesn't exist!");
		}
	}

	/**
	 * @param next define if next level need to be loaded
	 */
	@Override
	public void setNextLevel(boolean next)
	{	
		this.next_level = next;
	}
	
	public boolean getNextLevel()
	{
		return this.next_level;
	}

	/**
	 * @deprecated compiling necessity
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
