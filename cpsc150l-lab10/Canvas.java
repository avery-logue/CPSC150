/**
 * Class Canvas - a class to allow for simple graphical
 * drawing on a canvas.
 *
 * @author: Matthew McCarthy
 * date: 02-06-2016
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Canvas extends JFrame
{
    // instance variables
    private CanvasPanel panel;
    private Color       background_color;

    /**
     * Constructor for objects of class DisplayCanvas
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bg_color  the desired background clour of the canvas
     */
    public Canvas(String title, int width, int height, Color bg_color)
    {
        super(title);
        panel            = new CanvasPanel(bg_color);
        background_color = bg_color;

        add(panel);
        setSize(width, height);

        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    }

    /**
     * Constructor for objects of class DisplayCanvas with default
     * height, width and background colour (600, 600, white).
     * @param title  title to appear in Canvas Frame
     */
    public Canvas(String title)
    {
        this(title, 600, 400, Color.white);
    }

    /**
     * Constructor for objects of class DisplayCanvas with a default
     * background colour (white).
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     */
    public Canvas(String title, int width, int height)
    {
        this(title, width, height, Color.white);
    }

    /**
     * Draws a shape on the Canvas in a colors.
     * @param shape The shape.
     * @param color The color.
     **/
    public void draw()
    {
        panel.draw();
    }

    /**
     * Adds a shape on the Canvas in a colors.
     * @param shape The shape.
     * @param color The color.
     **/
    public void add(Shape shape, Color color)
    {
        panel.add(shape, color);
    }

    /**
     * Clears all shapes from the canvas.
     **/
    public void clear()
    {
        panel.clear();
    }

    /**
     * Sets the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     *
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false)
     */
    @Override
    public void setVisible(boolean flag)
    {
        super.setVisible(flag);
    }

    /**
     * waits for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  milliseconds  the number
     **/
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (Exception e)
        {
            // ignoring exception at the moment
        }
    }

    /**
     * simulates a bouncing ball
     *
     */
      public void bounce(BouncingBall ball, BouncingBall ball2)
    {
        setVisible(true);

        // Make the ground
        int ground       = (int) (panel.getHeight()*0.9); // position of the ground line
        int left_start   = (int) (panel.getWidth()*0.1);  // Starting position
        int top_start    = (int) (panel.getHeight()*0.1); // Starting height
        int right_end    = (int) (panel.getWidth()*0.9);  // End position
        Line2D.Double gr = new Line2D.Double(0, ground, panel.getWidth(), ground);

        ball.setGround(ground);
        ball2.setGround(ground);

        ball.setPosition(left_start, top_start);
        ball2.setPosition(left_start + 20, top_start + 40);

        // Add our shapes and their respective colors.
        add(gr, Color.black);
        add(ball.getCircle(), ball.getColor());
        add(ball2.getCircle(), ball2.getColor());

        draw();

        boolean finished =  false;
        while(!finished)
        {
            wait(50); // small delay
            ball.move();
            ball2.move();
            draw();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= right_end && ball2.getXPosition() >= right_end)
                finished = true;
        }
        // clear();
        draw();
    }
}
