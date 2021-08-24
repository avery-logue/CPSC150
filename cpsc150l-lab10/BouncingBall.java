/**
 * Class BouncingBall - a graphical ball that observes the effect of gravity.
 *
 * @author: Bruce Quig
 * date: 13/09/1999
 * Heavily edited by Matthew McCarthy.
 * date: 02/06/2016
 */

import java.awt.*;
import java.awt.geom.*;

public class BouncingBall
{
	private int gravity = 3;         // effect of gravity
	private int ground  = 0;         // y position of ground
	private Color color;

	private int ballDegradation = 2;
	private Ellipse2D.Double circle;
	private int diameter;
	int xPosition;
	int yPosition;
	int ySpeed = 1;                  // downward speed

	/**
	 * Constructor for objects of class BouncingBall
	 */
	public BouncingBall(int xPos, int yPos, int ballDiameter, Color ballColor)
	{
		xPosition = xPos;
		yPosition = yPos;
		circle    = new Ellipse2D.Double(xPos, yPos, ballDiameter, ballDiameter);
		diameter  = (int)circle.getHeight();
		color     = ballColor;
	}

	/**
	 * Sets the ground position.
	 */
	public void setGround(int gnd)
	{
		ground = gnd;
	}

	/**
	 * Move this ball according to its position and speed and redraw.
	 **/
	public void move()
	{
		// compute new position
		ySpeed    += gravity;
		yPosition += ySpeed;
		xPosition += 4;

		// check if it has hit the ground
		if(yPosition >= (ground - diameter) && ySpeed > 0)
		{
			yPosition = (int)(ground - diameter);
			ySpeed    = -ySpeed + ballDegradation;
		}
		circle.setFrame(xPosition, yPosition, diameter, diameter);
	}

	public void setPosition(int x, int y)
	{
		circle.setFrame(x, y, diameter, diameter);
		xPosition = x;
		yPosition = y;
	}

	/**
	 * return the horizontal position of this ball
	 */
	public int getXPosition()
	{
		return xPosition;
	}

	/**
	 * return the vertical position of this ball
	 */
	public int getYPosition()
	{
		return yPosition;
	}

	/**
	 * Returns the circle object embedded in this.
	 */
	public Shape getCircle()
	{
		return circle;
	}

	/**
	 * Returns the color object embedded in this.
	 */
	public Color getColor()
	{
		return color;
	}
}
