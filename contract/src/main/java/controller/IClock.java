package controller;

import java.util.Observer;

import view.Order;

@SuppressWarnings("deprecation")
public interface IClock extends Observer
{
	void setNeedRebuild(boolean rebuild);
	void orderPerform(Order key, boolean action);
	void setNextLevel(boolean next);
}
