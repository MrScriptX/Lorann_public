package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import controller.IController;
import model.IModel;



/**
 * Class Frame, extends from JFrame class, use to set the frame parameter and the user interaction with the program.
 *
 * @author Team 10
 * @version 1.0
 */



public class Frame extends JFrame implements KeyListener
{
	
	private static final long serialVersionUID = -7393744101067014109L;
	private int width = 660;
	private int height = 520;
	
	private Display affichage;
	private IController controller;
	private IModel model;
	
	
	public Frame(IModel model)
	{
		this.model = model;
		this.affichage = new Display(this.model);
		
		this.setTitle("Lorran");
	    this.setContentPane(this.affichage);
	    this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.addKeyListener(this);
		this.setVisible(true);
	}
	

	/**
	 * Method to check the key pressed.
	 * 
	 * @param keyEvent Register the key pressed by the user
	 * 
	 */
	public void keyPressed(KeyEvent keyEvent) 
	{
		switch(keyEvent.getKeyCode())
		{
		case KeyEvent.VK_UP:
			this.controller.getClock().orderPerform(Order.KEY_UP, true);
			break;
		case KeyEvent.VK_DOWN:
			this.controller.getClock().orderPerform(Order.KEY_DOWN, true);
			break;
		case KeyEvent.VK_LEFT :
			this.controller.getClock().orderPerform(Order.KEY_LEFT, true);
			break;
		case KeyEvent.VK_RIGHT:
			this.controller.getClock().orderPerform(Order.KEY_RIGHT, true);
			break;
		case KeyEvent.VK_SPACE:
			this.controller.getClock().orderPerform(Order.KEY_SPELL, true);
			break;
		}
	}

	
	
	/**
	 * Method to check the key released.
	 * 
	 * @param keyEvent Register the key that was released
	 */
	public void keyReleased(KeyEvent keyEvent) 
	{
		switch(keyEvent.getKeyCode())
		{
			case KeyEvent.VK_UP:
				this.controller.getClock().orderPerform(Order.KEY_UP, false);
				break;
			case KeyEvent.VK_DOWN:
				this.controller.getClock().orderPerform(Order.KEY_DOWN, false);
				break;
			case KeyEvent.VK_LEFT :
				this.controller.getClock().orderPerform(Order.KEY_LEFT, false);
				break;
			case KeyEvent.VK_RIGHT:
				this.controller.getClock().orderPerform(Order.KEY_RIGHT, false);
				break;
			case KeyEvent.VK_SPACE:
				this.controller.getClock().orderPerform(Order.KEY_SPELL, false);
				break;
		}
	}


	
	
	/**
	 * Method to check the key typed, never used in the program.
	 * 
	 * @param keyEvent register the key that was press once
	 * 
	 * @deprecated Is not needed
	 */
	public void keyTyped(KeyEvent keyEvent) 
	{
	}
	
	
	
	/**
	 * Method repaint, used to repaint the frame.
	 * 
	 * 
	 */
	public void repaint()
	{
		this.affichage.repaint();
	}
	
	public IController getController()
	{
		return controller;
	}
	
	public Display getAffichage()
	{
		return affichage;
	}
	
	/**
	 * 
	 * @param controller Get the controller without having the frame to depend on it
	 */
	public void setController(IController controller)
	{
		this.controller = controller;
	}
	
	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	/**
	 * 
	 * @param affichage Set the display class without having the frame class to depends on it
	 */
	public void setAffichage(Display affichage)
	{
		this.affichage = affichage;
	}
	
}
