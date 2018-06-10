package view;
 
import java.util.Observer;

import controller.IController;

@SuppressWarnings("deprecation")
public interface IView
{

	void repaint();


	void openFrame();


	Observer getObserver();


	void setController(IController controller);
}
