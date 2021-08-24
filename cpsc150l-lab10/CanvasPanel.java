/**
 * Class CanvasPanel - a class to allow for simple graphical
 * drawing on a canvas.
 *
 * @author: Matthew McCarthy
 * date: 02-06-2016
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel
{
	// Fields
	private ArrayList<Shape> draw_us;
	private ArrayList<Color> color_us;

	public CanvasPanel(Color bg)
	{
		setBackground(bg);
		draw_us  = new ArrayList<Shape>();
		color_us = new ArrayList<Color>();
		repaint();
	}

	public void draw()
	{
		repaint();
	}

	public void add(Shape shape, Color color)
	{
		draw_us.add(shape);
		color_us.add(color);
	}

	public void clear()
	{
		draw_us  = new ArrayList<Shape>();
		color_us = new ArrayList<Color>();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		for (int i = 0 ; i < draw_us.size() ; i++)
		{
			if (draw_us.get(i) != null && color_us.get(i) != null)
			{
				g2.setColor(color_us.get(i));
				g2.draw(draw_us.get(i));
				g2.fill(draw_us.get(i));
			}
		}
	}
}
