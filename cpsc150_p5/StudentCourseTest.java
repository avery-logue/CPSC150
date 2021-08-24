import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class StudentCourseTest.
 *
 * @author William Dzubak
 * @author Avery Logue
 * 
 * @version December 6th, 2017
 */
public class StudentCourseTest
{
    /**
     * Default constructor for test class StudentCourseTest
     */
    public StudentCourseTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    
    @Test
    public void getNameTest()
    {
        StudentCourse test = new StudentCourse("PHYS151");
        
        String expected = "PHYS151";
        
        String actual = test.getName();
        
        String err = "test.getName() returned incorrect output of " + actual + ", expected " + expected;
        
        assertEquals(err, expected, actual);
    }
    
    @Test
    public void getGradesTest()
    {
        ArrayList<Double> inputGrades = new ArrayList<Double>();
        
        inputGrades.add(57.0);

        inputGrades.add(79.0);
        
        StudentCourse test = new StudentCourse("MUSC112", inputGrades);

        ArrayList<Double> expectedGrades = new ArrayList<Double>();
        
        expectedGrades.add(57.0);

        expectedGrades.add(79.0);
        
        ArrayList<Double> actualGrades = test.getGrades();
        
        String err = "test.getGrades() returned incorrect output of " + actualGrades + ", expected " + expectedGrades;
        
        assertEquals(err, expectedGrades, actualGrades);
    }
    
    @Test
    public void calcAverageTest()
    {
        ArrayList<Double> inputGrades = new ArrayList<Double>();
        
        inputGrades.add(100.0);

        inputGrades.add(95.0);
        
        inputGrades.add(90.0);
        
        StudentCourse test = new StudentCourse("CPSC150", inputGrades);
        
        double expected = 95.0;
        
        double actual = test.calcAverage();
        
        double delta = 0.0001;
        
        String err = "test.calcAverage() returned incorrect output of " + actual + ", expected " + expected;
        
        assertEquals(err, expected, actual, delta);
    }
    
    @Test
    public void toStringTest()
    {
        ArrayList<Double> inputGrades = new ArrayList<Double>();
        
        inputGrades.add(94.0);

        inputGrades.add(85.0);
        
        inputGrades.add(74.0);
        
        StudentCourse test = new StudentCourse("CPSC420", inputGrades);
        
        String expected = "CPSC420 [94.0, 85.0, 74.0]";
        
        String actual = test.toString();
        
        String err = "test.toString() returned incorrect output of " + actual + ", expected " + expected;
        
        assertEquals(err, expected, actual);
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
