package view;

import java.util.Observable;
import java.util.Observer;

import controller.IController;
import model.IModel;

/**
 * Class View, use to control different parts of the display.
 *
 * @author Team 10
 * @version 1.0
 */

@SuppressWarnings("deprecation")
public class View implements IView, Observer
{	
		private Frame frame;
	
		
		public View(IModel model)
		{			
			this.frame = new Frame(model);
		}
		
		/**
		 * @deprecated not needed
		 */
		public void repaint()
		{
		}
		
		/** Method use to open the frame, the visibility of the frame is turn to true */
		public void openFrame()
		{
			this.frame.setVisible(true);
		}
		
		/** Method use to close the frame, the visibility of the frame is turn to false */
		public void closeFrame()
		{
			this.frame.setVisible(false);
		}
			
		/**
		 * @param controller Pass the controller to the frame
		 */
		public void setController(IController controller) 
		{
			this.frame.setController(controller);
		}

		/**
		 * @deprecated needed to compile, to not use
		 */
		@Override
		public Observer getObserver() 
		{
			return null;
		}

		/** Update method */
		@Override
		public void update(Observable obj, Object arg)
		{
			this.frame.getAffichage().update();
		}
	}
