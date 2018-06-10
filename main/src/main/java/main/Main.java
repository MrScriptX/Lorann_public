package main;


import view.View;
import model.ModelFacade;
import model.Music;

import java.sql.SQLException;

import controller.Clock;
import controller.ControllerFacade;


public class Main 
{
  @SuppressWarnings("deprecation")
public static void main(String[] args)
  {
    
    ModelFacade model = new ModelFacade();
    View view = new View(model);
    ControllerFacade controller = new ControllerFacade(view, model);
    
    ((Clock) controller.getClock()).addObserver(view);
    
    Music music = new Music();
    try
    {
    	view.setController(controller);
    	controller.start();
    }
    catch(SQLException exception)
    {
    	System.out.println(exception.getMessage());
    }
  }       
}