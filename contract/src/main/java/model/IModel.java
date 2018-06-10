package model;

import java.util.List;

import controller.IClock;

public interface IModel
{	
    public void loadLevel(int id);
    public void update(IClock clock);
    public void celebration();
    
    public IEntity getHeros();
    
	public List<IEntity> getEntities();
	public List<IMotionless> getMotionless();
	public int getScore();
	public String getTotalTime();
}
