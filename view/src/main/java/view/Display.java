package view;

/**
 * Class Display, extends from JPanel class, use to display the frame .
 *
 * @author Team 10
 * @version 1.0
 * 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.IModel;


public class Display extends JPanel
{
	private static final long serialVersionUID = 1L;
	private IModel model;



	private boolean           placement    = true;
	Image m,l,o,p,m4,m3,m2,m1,b,a,v,s1, s2, s3, s4, s5, h1, h2, h3, h4, h5, h6, h7, h8;
	int lorannx;
	int loranny;
	Image Lorann;
	int direction_lorann =0;
	Graphics g;


	public Display(IModel model)
	{
		this.setBackground(Color.BLACK);
		this.model = model;
		
		try 
		{
			this.loadImage();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Method used to load the different pictures of the program.
	 * 
	 * @throws IOException 
	 * if file are not found or fails to be opened
	 */
	public void loadImage() throws IOException {

		m = ImageIO.read(new File("image\\sprite\\horizontal_bone.png"));
		l = ImageIO.read(new File("image\\sprite\\vertical_bone.png"));
		o = ImageIO.read(new File("image\\sprite\\bone.png"));
		p = ImageIO.read(new File("image\\sprite\\gate_closed.png"));
		m4 = ImageIO.read(new File("image\\sprite\\monster_4.png"));
		m3 = ImageIO.read(new File("image\\sprite\\monster_3.png"));
		m2 = ImageIO.read(new File("image\\sprite\\monster_2.png"));
		m1 = ImageIO.read(new File("image\\sprite\\monster_1.png"));
		b = ImageIO.read(new File("image\\sprite\\purse.png"));
		a = ImageIO.read(new File("image\\sprite\\gate_open.png"));
		v = ImageIO.read(new File("image\\sprite\\crystal_ball.png"));
		s5 = ImageIO.read(new File("image\\sprite\\fireball_5.png"));
		s4 = ImageIO.read(new File("image\\sprite\\fireball_4.png"));
		s3 = ImageIO.read(new File("image\\sprite\\fireball_3.png"));
		s2 = ImageIO.read(new File("image\\sprite\\fireball_2.png"));
		s1 = ImageIO.read(new File("image\\sprite\\fireball_1.png"));
		h1 = ImageIO.read(new File("image\\sprite\\lorann_b.png"));
		h2 = ImageIO.read(new File("image\\sprite\\lorann_bl.png"));
		h3 = ImageIO.read(new File("image\\sprite\\lorann_l.png"));
		h4 = ImageIO.read(new File("image\\sprite\\lorann_ul.png"));
		h5 = ImageIO.read(new File("image\\sprite\\lorann_u.png"));
		h6 = ImageIO.read(new File("image\\sprite\\lorann_ur.png"));
		h7 = ImageIO.read(new File("image\\sprite\\lorann_r.png"));
		h8 = ImageIO.read(new File("image\\sprite\\lorann_br.png"));
	}


	/**
	 * Method used to load the picture the character.
	 */
	public void drawLorann()
	{
		switch (direction_lorann)
		{
		case 0:
			Lorann = h1;
			break;
		case 1:
			Lorann = h2;
			break;  
		case 2:
			Lorann = h3;
			break;
		case 3:
			Lorann = h4;
			break;
		case 4:
			Lorann = h5;
			break;
		case 5:
			Lorann = h6;
			break;
		case 6:
			Lorann = h7;
			break;
		case 7:
			Lorann = h8;
			break;
		default:
			Lorann = h1 ;             
		}
	}

	/**
	 * Method used to retrieve the location of the different map objects and display them.
	 * 
	 * @throws IOException error on reading file fails
	 * @throws InterruptedException on thread intteruption
	 * 
	 * @param g use to draw object on the screen
	 */
	public void drawWall(Graphics g) throws IOException, InterruptedException
	{
		try
		{
			for(int i = 0; i < this.model.getMotionless().size(); i++)
			{
				//Vertical_bone
				if (this.model.getMotionless().get(i).getSprite() == 'm')
				{
					g.drawImage(m, this.model.getMotionless().get(i).getPosition().getX()*32, this.model.getMotionless().get(i).getPosition().getY()*32, this);
				}

				//Vertical_bone
				if (this.model.getMotionless().get(i).getSprite() == 'l')
				{
					g.drawImage(l, this.model.getMotionless().get(i).getPosition().getX()*32, this.model.getMotionless().get(i).getPosition().getY()*32, this);
				}

				//Bone
				if (this.model.getMotionless().get(i).getSprite() == 'o') 
				{
					g.drawImage(o, this.model.getMotionless().get(i).getPosition().getX()*32, this.model.getMotionless().get(i).getPosition().getY()*32, this);
				}

				//Door
				if (this.model.getMotionless().get(i).getSprite() == 'p')
				{
					if (this.model.getMotionless().get(i).getIsOpen() == true) 
					{
						g.drawImage(a, this.model.getMotionless().get(i).getPosition().getX()*32, this.model.getMotionless().get(i).getPosition().getY()*32, this);
					}
					else
					{
						g.drawImage(p, this.model.getMotionless().get(i).getPosition().getX()*32, this.model.getMotionless().get(i).getPosition().getY()*32, this); 
					}
				}

				//Crystal_ball
				if (this.model.getMotionless().get(i).getSprite() == 'b') 
				{
					g.drawImage(b, this.model.getMotionless().get(i).getPosition().getX()*32, this.model.getMotionless().get(i).getPosition().getY()*32, this);
				}

				//Orbe
				if (this.model.getMotionless().get(i).getSprite() == 'v')
				{
					g.drawImage(v, this.model.getMotionless().get(i).getPosition().getX()*32, this.model.getMotionless().get(i).getPosition().getY()*32, this);
				}
			}
		}
		catch(IndexOutOfBoundsException exception)
		{
			//System.out.println("overflow on iteration of motionless elements");
		}

		this.drawLorann(); 

		/**
		 * loop used to catch the direction of the character and the monster/fireball position.
		 */

		try 
		{
			for(int i = 0; i < this.model.getEntities().size(); i++)
			{

				if (this.model.getEntities().get(i).getSprite() == 'H') 
				{
					lorannx = this.model.getEntities().get(i).getPosition().getX()*32;
					loranny = this.model.getEntities().get(i).getPosition().getY()*32;
					g.drawImage(h1, lorannx, loranny, this);
				}
				else if(this.model.getEntities().get(i).getSprite() == 'h')
				{
					lorannx = this.model.getEntities().get(i).getPosition().getX()*32;
					loranny = this.model.getEntities().get(i).getPosition().getY()*32;
					g.drawImage(h2, lorannx, loranny, this);
				}
				else if(this.model.getEntities().get(i).getSprite() == 'N')
				{
					lorannx = this.model.getEntities().get(i).getPosition().getX()*32;
					loranny = this.model.getEntities().get(i).getPosition().getY()*32;
					g.drawImage(h3, lorannx, loranny, this);
				}
				else if(this.model.getEntities().get(i).getSprite() == 'n')
				{
					lorannx = this.model.getEntities().get(i).getPosition().getX()*32;
					loranny = this.model.getEntities().get(i).getPosition().getY()*32;
					g.drawImage(h4, lorannx, loranny, this);
				}
				else if(this.model.getEntities().get(i).getSprite() == 'W')
				{
					lorannx = this.model.getEntities().get(i).getPosition().getX()*32;
					loranny = this.model.getEntities().get(i).getPosition().getY()*32;
					g.drawImage(h5, lorannx, loranny, this);
				}
				else if(this.model.getEntities().get(i).getSprite() == 'w')
				{
					lorannx = this.model.getEntities().get(i).getPosition().getX()*32;
					loranny = this.model.getEntities().get(i).getPosition().getY()*32;
					g.drawImage(h6, lorannx, loranny, this);
				}
				else if(this.model.getEntities().get(i).getSprite() == 'z')
				{
					lorannx = this.model.getEntities().get(i).getPosition().getX()*32;
					loranny = this.model.getEntities().get(i).getPosition().getY()*32;
					g.drawImage(h7, lorannx, loranny, this);
				}
				else if(this.model.getEntities().get(i).getSprite() == 'Z')
				{
					lorannx = this.model.getEntities().get(i).getPosition().getX()*32;
					loranny = this.model.getEntities().get(i).getPosition().getY()*32;
					g.drawImage(h8, lorannx, loranny, this);
				}

				if (this.model.getEntities().get(i).getSprite() == 's')
				{
					g.drawImage(s1, this.model.getEntities().get(i).getPosition().getX()*32, this.model.getEntities().get(i).getPosition().getY()*32, this);
				}
				else if(this.model.getEntities().get(i).getSprite() == 'u')
				{
					g.drawImage(s2, this.model.getEntities().get(i).getPosition().getX()*32, this.model.getEntities().get(i).getPosition().getY()*32, this);
				}
				else if(this.model.getEntities().get(i).getSprite() == 'i')
				{
					g.drawImage(s3, this.model.getEntities().get(i).getPosition().getX()*32, this.model.getEntities().get(i).getPosition().getY()*32, this);
				}
				else if(this.model.getEntities().get(i).getSprite() == 'e')
				{
					g.drawImage(s4, this.model.getEntities().get(i).getPosition().getX()*32, this.model.getEntities().get(i).getPosition().getY()*32, this);
				}
				else if(this.model.getEntities().get(i).getSprite() == 'c')
				{
					g.drawImage(s5, this.model.getEntities().get(i).getPosition().getX()*32, this.model.getEntities().get(i).getPosition().getY()*32, this);
				}

				if (this.model.getEntities().get(i).getSprite() == '1') {
					g.drawImage(m1, this.model.getEntities().get(i).getPosition().getX()*32, this.model.getEntities().get(i).getPosition().getY()*32, this);
				}

				if (this.model.getEntities().get(i).getSprite() == '2') {
					g.drawImage(m2, this.model.getEntities().get(i).getPosition().getX()*32, this.model.getEntities().get(i).getPosition().getY()*32, this);
				}

				if (this.model.getEntities().get(i).getSprite() == '3') {
					g.drawImage(m3, this.model.getEntities().get(i).getPosition().getX()*32, this.model.getEntities().get(i).getPosition().getY()*32, this);
				}

				if (this.model.getEntities().get(i).getSprite() == '4') {
					g.drawImage(m4, this.model.getEntities().get(i).getPosition().getX()*32, this.model.getEntities().get(i).getPosition().getY()*32, this);
				}
			}
		}
		catch(IndexOutOfBoundsException exception)
		{
			//System.out.println("overflow on iteration of motionless elements");
		}


		paintscore(g);
		this.repaint();
	}


	/**
	 * Allows to paint credits of the game
	 * @param z Object use to draw credits
	 */
	public void paintcredit(Graphics z)
	{                
		Font font = new Font("Courier", Font.BOLD, 15);
		z.setFont(font);
		z.setColor(Color.green);          
		z.drawString("Credit : Exia ST A1 Groupe 10 2017/2018 ", 150, 470);
		this.repaint();
	}


	/**
	 * Allows to paint the score of the game
	 * @param z Object use to draw score
	 */
	public void paintscore(Graphics z)
	{                
		Font font = new Font("Courier", Font.BOLD, 30);
		z.setFont(font);
		z.setColor(Color.yellow);          
		z.drawString("Score : " + this.model.getScore(), 350, 450);    
		this.repaint();
		
		Font fontz = new Font("Courier", Font.BOLD, 30);
		z.setFont(fontz);
		z.setColor(Color.yellow);          
		z.drawString("Time : " + this.model.getTotalTime(), 30, 450);    
		this.repaint();
	}

	/**
	 * Method used to call the draw wall method.
	 * 
	 * 
	 * @param g Object use to draw motionless elements
	 * 
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (placement)
		{
			try
			{
				drawWall(g);
			} 
			catch (IOException e1)
			{
				e1.printStackTrace();
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		paintcredit(g); 
	}

	/**
	 * Method used to update the frame
	 */
	public void update() 
	{
		this.repaint();
	}

}
