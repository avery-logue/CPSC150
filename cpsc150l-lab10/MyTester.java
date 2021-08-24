import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Write a description of class MyTester here.
 *
 * @author Avery Logue
 * @version 11/1/17
 */
public class MyTester
{
    public static void main(String args[])
    {
        Canvas FirstCanvas = new Canvas("First one");
        FirstCanvas.setVisible(true);
        //Canvas SecondCanvas = new Canvas("Second one", 700, 300);
        //SecondCanvas.setVisible(true);
        //Canvas ThirdCanvas = new Canvas("Third one", 400, 400, Color.blue);
        //ThirdCanvas.setVisible(true);
        
        BouncingBall ball = new BouncingBall(0, 0, 24, Color.red);
        BouncingBall ball2  = new BouncingBall(0,0, 50, Color.green);
        BouncingBall ball3 = new BouncingBall(0,0, 100, Color.red);
        FirstCanvas.add(ball.getCircle(), ball.getColor());
        FirstCanvas.draw();
        FirstCanvas.bounce(ball2, ball3);
        
    }

}
