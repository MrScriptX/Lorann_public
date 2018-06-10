package controller;

import java.sql.SQLException;
import model.IModel;
import view.IView;

/**
 * Class initialize the controller and start the game.
 *Will manage the game state in later version
 * 
 * @author Team 10
 *@version 1.0
 */
public class ControllerFacade implements IController
{
    private final IView  view;
    private final IModel model;
    
    private final Clock clock;

    public ControllerFacade(final IView view, final IModel model)
    {
        super();
        this.view = view;
        this.model = model;
        this.clock = new Clock();
    }

    /**
     * Launches the controller
     * 
     * @throws SQLException if level couldn't be loaded
     */
    public void start() throws SQLException
    {
    	clock.run(this.model);
    }

    public IView getView()
    {
        return this.view;
    }

    public IModel getModel()
    {
        return this.model;
    }
    
    public IClock getClock()
    {
    	return this.clock;
    }
}
